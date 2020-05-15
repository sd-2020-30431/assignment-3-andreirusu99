package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import server.mediator.Handler
import server.mediator.command.DeleteItemCommand
import server.mediator.response.EmptyResponse
import server.service.command.GroceryItemCommandService

class DeleteItemCommandHandler
    : Handler<DeleteItemCommand, EmptyResponse> {

    @Autowired
    private lateinit var groceryItemCommandService: GroceryItemCommandService

    override fun handle(request: DeleteItemCommand): EmptyResponse {
        groceryItemCommandService.deleteItem(request.itemId)
        return EmptyResponse()
    }
}