package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.command.AddItemCommand
import server.mediator.response.AddItemCommandResponse
import server.service.command.GroceryItemCommandService

@Component
class AddItemCommandHandler
    : Handler<AddItemCommand, AddItemCommandResponse> {

    @Autowired
    private lateinit var groceryItemCommandService: GroceryItemCommandService

    override fun handle(request: AddItemCommand): AddItemCommandResponse {
        return AddItemCommandResponse(
                groceryItemCommandService.addItem(
                        request.listId,
                        request.item.itemName,
                        request.item.itemQuantity,
                        request.item.calorieValue,
                        request.item.purchaseDate,
                        request.item.consumptionDate,
                        request.item.expirationDate
                )
        )
    }
}