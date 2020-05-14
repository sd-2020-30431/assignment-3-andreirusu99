package server.mediator.handler

import org.springframework.stereotype.Component
import server.mediator.query.ReadUserListsQuery
import server.mediator.response.ReadUserListsQueryResponse

@Component
class ReadUserListsQueryHandler : Handler<ReadUserListsQuery, ReadUserListsQueryResponse> {

    override fun handle(request: ReadUserListsQuery): ReadUserListsQueryResponse {
        TODO("Not yet implemented")
    }
}