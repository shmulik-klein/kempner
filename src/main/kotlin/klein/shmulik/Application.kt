package klein.shmulik

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.requestvalidation.*
import klein.shmulik.models.Book
import klein.shmulik.plugins.configureContent
import klein.shmulik.plugins.configureHTTP
import klein.shmulik.plugins.configureMonitoring
import klein.shmulik.plugins.configureRouting

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
//    configureSecurity()
    configureHTTP()
    configureMonitoring()
    configureRouting()
    configureContent()
    // configureJvmMonitor()
    configureValidation()
}

fun Application.configureValidation() {
    install(RequestValidation) {
        validate<Book> {book ->
            if (book.name.isBlank()) {
                ValidationResult.Valid
            }
            ValidationResult.Invalid("Name can't be blank")
        }
    }
}
