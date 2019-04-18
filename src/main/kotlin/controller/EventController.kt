package controller

import io.javalin.Context
import org.koin.core.KoinComponent
import org.koin.core.inject
import service.EventService

class EventController:KoinComponent {
	
	private val eventService:EventService by inject()
	
	fun save(ctx: Context) {
        println(ctx.body())
		eventService.save(ctx.body())
		ctx.status(201)
    }
	
	fun findByIssue(ctx: Context) {
		val events = eventService.findByIssue(ctx.pathParam("issuenumber"))
		ctx.json(events)
    }
	
}