package service

import org.koin.core.KoinComponent
import repository.EventRepository
import org.koin.core.inject
import org.bson.Document

class EventService:KoinComponent {
	
	private val eventRepository:EventRepository by inject()
	
	fun save(event:String){
		eventRepository.save(event);
	}
	
	fun findByIssue(issueNumber:String):List<Document> {
		var templateQuery = "{'issue.number':$issueNumber}"
		return eventRepository.find(templateQuery);
	}
	
}