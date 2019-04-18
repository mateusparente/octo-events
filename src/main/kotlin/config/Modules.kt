package config

import RouterV1
import controller.EventController
import org.koin.dsl.module
import repository.EventRepository
import service.EventService
import org.koin.core.definition.Properties

object Modules {
	
	val controllerModule = module {
		single { EventController() }
		single { RouterV1() } 
	}
	
	var configModules = module {
		single { DatabaseManager().mongoClient }
		single { MongoExecutable().get() }
		single { Properties() }
	}
	
	var repositoryModules = module {
		single { EventRepository() }
	}
	
	var serviceModules = module {
		single { EventService() }
	}
	
	internal val allModules = listOf(
		Modules.serviceModules,
		Modules.configModules,
		Modules.controllerModule,
		Modules.repositoryModules
	)
	
}