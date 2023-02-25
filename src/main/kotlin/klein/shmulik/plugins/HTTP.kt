package klein.shmulik.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureHTTP() {
    routing {
        // openAPI(path = "openapi")
    }
}
