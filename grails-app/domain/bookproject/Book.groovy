package bookproject

class Book {

    String author
    String title
    static hasMany = [reviews: Review]


    static constraints = {
        author(blank: false)
        title(blank: false, unique: true)

    }
}
