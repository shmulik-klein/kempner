package klein.shmulik

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import klein.shmulik.plugins.configureContent
import klein.shmulik.plugins.configureRouting
import kotlin.test.Test
import kotlin.test.assertEquals

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
            assertEquals("[]", bodyAsText())
            assertEquals(HttpStatusCode.OK, status)
        }
    }


}
