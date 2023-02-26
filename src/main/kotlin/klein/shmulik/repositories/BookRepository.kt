package klein.shmulik.repositories

import klein.shmulik.models.Book

interface BookRepository {
    fun add(book: Book): Int

    fun listAll(): List<Book>
}