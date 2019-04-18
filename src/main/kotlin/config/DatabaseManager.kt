package config


import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.koin.core.KoinComponent

class DatabaseManager:KoinComponent {
	
	val mongoClient:MongoClient = getClient()
	
	fun getClient():MongoClient {
		
		val bindIp:String = MongoProperties.server
		val port = MongoProperties.port

		return MongoClients.create("mongodb://$bindIp:$port")
	}
	
}