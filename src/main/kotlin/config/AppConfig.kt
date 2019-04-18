package config

import RouterV1
import de.flapdoodle.embed.mongo.MongodExecutable
import io.javalin.Javalin
import io.javalin.JavalinEvent
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.IOException
import org.koin.core.context.stopKoin

class AppConfig: KoinComponent {
	
	private val router: RouterV1 by inject()
	private val mongodExecutable:MongodExecutable by inject()

	fun setup(): Javalin {
        
		return Javalin
				.create()
				.disableRequestCache()
				.maxBodySizeForRequestCache(10000)
				.also { app ->
					
					router.register(app)
					app.port(7000)
					
					try {
						
						var instance = mongodExecutable.start()
						
						app.event(JavalinEvent.SERVER_STOPPING) {
							instance.stop()
							mongodExecutable.stop()
							stopKoin()
						}
						
					} catch(e: IOException){
						stopKoin()
						throw Exception("NAO FOI POSSIVEL INICIAR O MONGODB.")
					}
				}
    }
	
}