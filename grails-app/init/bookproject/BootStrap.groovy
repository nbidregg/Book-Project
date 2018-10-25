package bookproject

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        //Populating users
        def testUser2 = new User(username: 'jane121', password: 'pass1').save()
        UserRole.create(testUser2, userRole, true)
        def testUser3 = new User(username: 'reader17', password: 'book1').save()
        UserRole.create(testUser3, userRole, true)
        def testUser4 = new User(username: 'robot', password: 'beep').save()
        UserRole.create(testUser4, userRole, true)

        //Populating a list of books
        new Book(author: 'Nate', title: 'Merlin the Dog').save()
        new Book(author: 'Maranda', title: 'Lucy Rucy').save()
        new Book(author: 'Phil', title: 'Dillweed').save()
        new Book(author: 'Clay', title: 'Annoying Noises').save()
        new Book(author: 'Daniel', title: 'Book of Lists').save()

        //Adding Reviews to the books
        new Review(comment: 'Hes a cute dog, I love him', rating: 4, user: User.list().get(0), book: Book.list().get(0), title: Book.list().get(0).title).save()
        new Review(comment: 'I prefer cats', rating: 1, user: User.list().get(2), book: Book.list().get(0), title: Book.list().get(0).title).save()
        new Review(comment: 'This dog is unbelievable.', rating: 5, user: User.list().get(1), book: Book.list().get(0), title: Book.list().get(0).title).save()
        new Review(comment: 'Rucy is cool, Lucy was not', rating: 2, user: User.list().get(2), book: Book.list().get(1), title: Book.list().get(1).title).save()
        new Review(comment: 'Pickle grass tastes funny', rating: 3, user: User.list().get(2), book: Book.list().get(2), title: Book.list().get(2).title).save()
        new Review(comment: 'Bad garden book', rating: 2, user: User.list().get(0), book: Book.list().get(2), title: Book.list().get(2).title).save()
        new Review(comment: 'The sounds where hard to read', rating: 1, user: User.list().get(0), book: Book.list().get(3), title: Book.list().get(3).title).save()
        new Review(comment: 'The book gave me a headache', rating: 2, user: User.list().get(1), book: Book.list().get(3), title: Book.list().get(3).title).save()
        new Review(comment: 'I have never seen so many lists', rating: 5, user: User.list().get(1), book: Book.list().get(4), title: Book.list().get(4).title).save()
        new Review(comment: 'A great read for anyone who likes lists', rating: 4, user: User.list().get(2), book: Book.list().get(4), title: Book.list().get(4).title).save()

    }
    def destroy = {
    }
}
