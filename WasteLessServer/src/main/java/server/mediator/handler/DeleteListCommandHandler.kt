package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.command.DeleteListCommand
import server.mediator.response.EmptyResponse
import server.service.command.GroceryListCommandService

@Component
class DeleteListCommandHandler
    : Handler<DeleteListCommand, EmptyResponse> {

    @Autowired
    private lateinit var groceryListCommandService: GroceryListCommandService

    override fun handle(request: DeleteListCommand): EmptyResponse {
        groceryListCommandService.deleteList(request.listId)
        return EmptyResponse()
    }
}