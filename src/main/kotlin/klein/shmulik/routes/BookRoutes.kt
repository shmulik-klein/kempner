package klein.shmulik.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import klein.shmulik.models.booksDB

fun Route.bookRouting() {
    route("/books") {
        get {
            call.respond(booksDB.values)
        }
        get("{id?}") {
            call.respond(booksDB[1]!!)
        }
        post {

        }
        delete("{id?}") {

        }
    }
}