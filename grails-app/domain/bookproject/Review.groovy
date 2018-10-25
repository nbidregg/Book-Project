package bookproject

class Review {
    String comment
    int rating
    static belongsTo = [user: User, book: Book]
    String title
    static constraints = {
        comment(blank: false, size: 5..150)
        rating(blank: false)
        user(nullable: true)
        title(nullable: false)
    }
}