package klein.shmulik.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import klein.shmulik.repositories.BookRepository

fun Route.bookRouting(bookRepository: BookRepository) {
    route("/books") {
        get {
            call.respond(bookRepository.listAll())
        }
        get("{id?}") {

        }
        post {

        }
        delete("{id?}") {

        }
    }
}