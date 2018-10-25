package bookproject

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class UserController {

    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userService.list(params), model:[userCount: userService.count()]
    }

    //Display a list of all reviews by the current user
    def userReviewList(){
        //these findAllBy* statements will be moved to a service.
       // def user = authenticatedUser

        def userInstance = User.findByUsername(params.username)
        def reviewInstance = Review.findAllByUser(userInstance)
        def bookInstance = Book.findAllByTitle(reviewInstance.title)

        [reviews:reviewInstance, user:userInstance, books:bookInstance]
    }


}
