package server.mediator.handler

import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.query.ReadListItemsQuery
import server.mediator.response.ReadListItemsQueryResponse

@Component
class ReadListItemsQueryHandler : Handler<ReadListItemsQuery, ReadListItemsQueryResponse> {

    override fun handle(request: ReadListItemsQuery): ReadListItemsQueryResponse {
        TODO("Not yet implemented")
    }
}