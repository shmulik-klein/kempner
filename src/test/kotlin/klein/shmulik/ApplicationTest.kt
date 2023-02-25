package klein.shmulik

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import klein.shmulik.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun testFirstBook() = testApplication {
        application {
            configureRouting()
            configureContent()
        }
        client.get("/books").apply { assertEquals("""[{"isbn":1,"name":"Book1"}]""", bodyAsText()) }
    }
}
