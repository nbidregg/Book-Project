package bookproject

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured


@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class ReviewController {
    static Boolean linkMe = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    //default page is a list of all reviews, used for testing. this reviews should always default back to book/index
    def index() {
        def reviews = Review.list()
        [reviews: reviews]
    }

    //Action to add a review, will (eventually) redirect to a page if not currently logged in to a valid user account
    def addReview() {
        def bookInstance = Book.findByAuthorAndTitle(params.author, params.title)

        [book: bookInstance]
    }
    //saves the review and associates it with the appropriate book
    def saveReview() {

        if (request.method == 'POST') {
            //things like this to be moved to a service.
            def bookInstance = Book.findByAuthorAndTitle(params.author, params.title)
            def userInstance = authenticatedUser
            def r = new Review(comment: params.comment, rating: params.rating, user: userInstance, book: bookInstance, title: bookInstance.title)

            if (!r.save(flush: true, failOnError: true)) {
                redirect(action: 'addReview')

            } else {
                bookInstance.addToReviews(r)
                userInstance.addToReviews(r)
                bookInstance.save()
                userInstance.save()
                redirect(controller: 'book', view: 'index')
            }
        }
    }
    //returns user to the book without saving the review.
    def cancel() {
        def bookInstance = Book.findByAuthorAndTitle(params.author, params.title)
        redirect(controller: 'book', action: 'displayBook', params: [title: bookInstance.title, author: bookInstance.author])
    }
}
