package klein.shmulik.repositories

import klein.shmulik.models.Book

class InMemoryBookRepository : BookRepository {
    private val books = mutableMapOf<Int, Book>()
    override fun add(book: Book): Book {
        val id = books.size + 1
        books[id] = Book(id, book.isbn, book.name)
        return books[id]!!
    }

    override fun listAll(): Map<Int, Book> = books
}