package server.mediator.handler

import org.springframework.stereotype.Component
import server.mediator.query.ReadListItemsQuery
import server.mediator.response.ReadListItemsResponse

@Component
class ReadListItemsQueryHandler : Handler<ReadListItemsQuery, ReadListItemsResponse> {

    override fun handle(request: ReadListItemsQuery): ReadListItemsResponse {
        TODO("Not yet implemented")
    }
}