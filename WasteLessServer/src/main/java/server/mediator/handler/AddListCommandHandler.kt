package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.command.AddListCommand
import server.mediator.response.AddListCommandResponse
import server.service.command.GroceryListCommandService

@Component
class AddListCommandHandler : Handler<AddListCommand, AddListCommandResponse> {

    @Autowired
    private lateinit var groceryListCommandService: GroceryListCommandService

    override fun handle(request: AddListCommand): AddListCommandResponse {
        return AddListCommandResponse(
                groceryListCommandService.addList(
                        request.userId, request.list.listName))
    }
}