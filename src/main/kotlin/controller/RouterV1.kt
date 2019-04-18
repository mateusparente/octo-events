import controller.EventController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.apibuilder.ApiBuilder.get
import org.koin.core.KoinComponent
import org.koin.core.inject

class RouterV1: KoinComponent {
	
	private val eventController: EventController by inject()
	
	fun register(app: Javalin) {
		
		app.routes {
			path("/api/v1/issues") {
				post(eventController::save)
				path(":issuenumber"){
					path("events"){
						get(eventController::findByIssue)
					}
				}
            }
		}
		
	}
	
}