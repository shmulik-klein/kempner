package klein.shmulik.models

import kotlinx.serialization.Serializable

@Serializable
data class Book(val id: Int? = null, val isbn: Long, val name: String) {
    override fun toString(): String {
        return "{isbn: $isbn; name: $name}"
    }
}