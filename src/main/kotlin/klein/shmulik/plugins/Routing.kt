package klein.shmulik.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import klein.shmulik.model.Book

/**
 * Registers the application's endpoints
 */
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/books") {
            call.respond(listOf(Book(1, "Book1")))
        }
    }
}
