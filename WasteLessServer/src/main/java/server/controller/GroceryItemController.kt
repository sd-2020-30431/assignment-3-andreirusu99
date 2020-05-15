package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import server.db.model.GroceryItem
import server.mediator.Mediator
import server.mediator.command.AddItemCommand
import server.mediator.command.DeleteItemCommand
import server.mediator.query.ReadListItemsQuery
import server.mediator.response.AddItemCommandResponse
import server.mediator.response.EmptyResponse
import server.mediator.response.ReadListItemsQueryResponse

@RestController
@RequestMapping("/wasteless")
class GroceryItemController {

    @Autowired
    private lateinit var mediator: Mediator

    @RequestMapping("/items/get/{listId}", method = [RequestMethod.GET])
    fun getListItems(@PathVariable listId: Int): ResponseEntity<List<GroceryItem>> {
        val request = ReadListItemsQuery(listId)
        val handler = mediator.handle<ReadListItemsQuery, ReadListItemsQueryResponse>(request)
        val response = handler.handle(request)
        return ResponseEntity.ok(response.items)
    }

    @RequestMapping("/items/add/{listId}", method = [RequestMethod.POST])
    fun addItem(@PathVariable listId: Int, @RequestBody item: GroceryItem) {
        val request = AddItemCommand(listId, item)
        val handler = mediator.handle<AddItemCommand, AddItemCommandResponse>(request)
        val response = handler.handle(request)
    }

    @RequestMapping("/items/delete/{itemId}", method = [RequestMethod.DELETE])
    fun deleteItem(@PathVariable itemId: Int) {
        val request = DeleteItemCommand(itemId)
        val handler = mediator.handle<DeleteItemCommand, EmptyResponse>(request)
        handler.handle(request)
    }
}