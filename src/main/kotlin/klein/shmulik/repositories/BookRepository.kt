package klein.shmulik.repositories

import klein.shmulik.models.Book

interface BookRepository {
    fun add(book: Book): Book

    fun listAll(): Map<Int, Book>
}