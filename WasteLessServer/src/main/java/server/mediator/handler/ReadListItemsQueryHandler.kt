package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.query.ReadListItemsQuery
import server.mediator.response.ReadListItemsQueryResponse
import server.service.query.GroceryItemQueryService

@Component
class ReadListItemsQueryHandler : Handler<ReadListItemsQuery, ReadListItemsQueryResponse> {

    @Autowired
    private lateinit var groceryItemQueryService: GroceryItemQueryService

    override fun handle(request: ReadListItemsQuery): ReadListItemsQueryResponse {
        return ReadListItemsQueryResponse(groceryItemQueryService.getListItems(request.listId))
    }
}