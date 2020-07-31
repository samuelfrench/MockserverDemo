package hello.tests

import hello.getHelloString
import hello.getTimeJsonString
import kotlin.test.assertEquals
import org.junit.Test

class HelloTest {
    @Test fun testAssert() {
        assertEquals("Hello, world!", getHelloString())
    }

    /* we can't test this at the unit level because we can't hardcode the datetime...
    @Test fun testGetTimeJsonString() {
        assertEquals("", getTimeJsonString())
    }*/
}
