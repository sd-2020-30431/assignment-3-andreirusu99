package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.query.ReadUserListsQuery
import server.mediator.response.ReadUserListsQueryResponse
import server.service.query.GroceryListQueryService

@Component
class ReadUserListsQueryHandler : Handler<ReadUserListsQuery, ReadUserListsQueryResponse> {

    @Autowired
    private lateinit var groceryListQueryService: GroceryListQueryService

    override fun handle(request: ReadUserListsQuery): ReadUserListsQueryResponse {
        return ReadUserListsQueryResponse(groceryListQueryService.getUserLists(request.userId))
    }
}