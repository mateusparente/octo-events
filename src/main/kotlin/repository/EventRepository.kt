package repository

import com.mongodb.client.MongoClient
import org.koin.core.inject
import org.koin.core.KoinComponent
import com.mongodb.client.MongoCollection
import com.mongodb.DBObject
import org.bson.Document
import com.mongodb.client.FindIterable

class EventRepository:KoinComponent {
	
	val mongoClient: MongoClient by inject()
	
	fun save(event:String){
		getCollection().insertOne(Document.parse(event));
	}
	
	fun find(query:String):List<Document> {
		return getCollection().find(Document.parse(query)).toList()
	}
	
	private fun getCollection():MongoCollection<Document> {
		val database = mongoClient.getDatabase("octo-events")
		return database.getCollection("events")
	}
	
}