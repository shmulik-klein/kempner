package klein.shmulik

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
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
}
