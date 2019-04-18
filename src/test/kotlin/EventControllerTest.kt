import junit.framework.TestCase
import io.javalin.Javalin
import config.AppConfig
import config.Modules
import org.koin.core.context.startKoin

class EventControllerTest: TestCase() {
	
	private lateinit var app: Javalin
	private val url = "http://localhost:7000"

    override fun setUp() {
        startKoin { modules(Modules.allModules) }
		app = AppConfig().setup().start()
    }

    override fun tearDown() {
        app.stop()
    }
	
	fun testShouldFindIssues() {
        
		val response = khttp.get(url = url + "/api/v1/issues/1000/events")
		assertEquals(200, response.statusCode)
		
	}
	
	fun testShouldInsertEvent() {
        
		val example = mapOf("action" to "opened")
		
		val responsePost = khttp.post(url + "/api/v1/issues", json=example)
		assertEquals(201, responsePost.statusCode)
	}
	
}