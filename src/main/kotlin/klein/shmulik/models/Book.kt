package klein.shmulik.models

import kotlinx.serialization.Serializable

@Serializable
data class Book(val isbn: Int, val name: String) {
    override fun toString(): String {
        return "{isbn: $isbn; name: $name}"
    }
}

val booksDB = mapOf(1 to Book(1, "book1"))