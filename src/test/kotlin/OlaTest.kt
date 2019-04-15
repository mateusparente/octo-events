import org.junit.Test
import kotlin.test.assertEquals

class OlaTest {
	
	private val hello = Hello()
	
    @Test
    fun testGetHelloString() {
        assertEquals("Hi", hello.getHelloString())
    }
	
}