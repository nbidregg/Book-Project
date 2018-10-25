package bookproject

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_USER'])
class BookController {
    static Boolean linkMe = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    //displays a list of books with clickable links to leave reviews
    def index() {

        def bookInstance = Book.list()
        def reviewInstance = Review.list()//temporary
        [books: bookInstance, reviews: reviewInstance]

    }

    //Displays a single book, its rating, and all of its reviews.
    def displayBook() {
        def bookInstance = Book.findByAuthorAndTitle(params.author, params.title)

        def reviews = Review.findAllByTitle(bookInstance.title)//temporary, I feel like there is a better way to do this
        [bookInstance: bookInstance, reviews: reviews]
    }
}
