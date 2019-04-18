import config.AppConfig
import config.Modules
import org.koin.core.context.startKoin

object OctoEventsApplication {
	
	@JvmStatic
	fun main(args : Array<String>) {
	    
		startKoin {
			modules(Modules.allModules)
		}
		
		AppConfig().setup().start();
		
	}
	
}