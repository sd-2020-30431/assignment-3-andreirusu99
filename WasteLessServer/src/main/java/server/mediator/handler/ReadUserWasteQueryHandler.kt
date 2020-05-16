package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import server.mediator.Handler
import server.mediator.query.ReadUserWasteQuery
import server.mediator.response.ReadUserWasteQueryResponse
import server.service.query.UserQueryService

class ReadUserWasteQueryHandler : Handler<ReadUserWasteQuery, ReadUserWasteQueryResponse> {

    @Autowired
    private lateinit var userQueryService: UserQueryService

    override fun handle(request: ReadUserWasteQuery): ReadUserWasteQueryResponse {
        return ReadUserWasteQueryResponse(userQueryService.getWaste(request.userId))
    }
}