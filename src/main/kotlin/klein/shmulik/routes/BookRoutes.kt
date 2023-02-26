package klein.shmulik.routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import klein.shmulik.models.Book
import klein.shmulik.repositories.BookRepository

fun Route.bookRouting(bookRepository: BookRepository) {
    route("/books") {
        get {
            call.respond(bookRepository.listAll())
        }
        get("{id?}") {

        }
        post {
            val book = call.receive<Book>()
            call.respond(bookRepository.add(book))
        }
        delete("{id?}") {

        }
    }
}