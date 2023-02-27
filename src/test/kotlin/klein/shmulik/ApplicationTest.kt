package klein.shmulik

import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.testing.*
import klein.shmulik.models.Book
import klein.shmulik.plugins.configureContent
import klein.shmulik.plugins.configureRouting
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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
    fun `given no book was stored return an empty list`() = testApplication {
        application {
            configureRouting()
            configureContent()
        }
        client.get("/books").apply {
            assertEquals("{}", bodyAsText())
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun `when adding a book it is being returned`() = testApplication {
        application {
            configureRouting()
            configureContent()
        }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.post("/books") {
            contentType(ContentType.Application.Json)
            setBody(Book(isbn = 9783161484100, name = "book1"))
        }

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("""{"id":1,"isbn":9783161484100,"name":"book1"}""", response.bodyAsText())
    }

    @Test
    fun `when adding a book without name throw an exception`() = testApplication {
        application {
            configureRouting()
            configureContent()
            configureValidation()
        }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        assertFailsWith(RequestValidationException::class) {
            client.post("/books") {
                contentType(ContentType.Application.Json)
                setBody(Book(isbn = 9783161484100, name = ""))
            }
        }
    }
}
