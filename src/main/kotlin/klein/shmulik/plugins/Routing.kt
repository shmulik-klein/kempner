package klein.shmulik.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import klein.shmulik.repositories.InMemoryBookRepository
import klein.shmulik.routes.bookRouting

/**
 * Registers the application's endpoints
 */
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        bookRouting(InMemoryBookRepository())
    }
}
