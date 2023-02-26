package klein.shmulik.repositories

import klein.shmulik.models.Book

class InMemoryBookRepository : BookRepository {
    private val books = mutableMapOf<Int, Book>()
    override fun add(book: Book): Book {
        books[book.isbn] = book
        return books[book.isbn]!!
    }

    override fun listAll(): Map<Int, Book> = books
}