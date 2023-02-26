package klein.shmulik.repositories

import klein.shmulik.models.Book

class InMemoryBookRepository : BookRepository {
    val books = mutableListOf<Book>()
    override fun add(book: Book): Int {
        TODO("Not yet implemented")
    }

    override fun listAll(): List<Book> = books
}