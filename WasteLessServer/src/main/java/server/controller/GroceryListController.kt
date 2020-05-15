package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import server.db.model.GroceryList
import server.mediator.Mediator
import server.mediator.command.AddListCommand
import server.mediator.command.DeleteListCommand
import server.mediator.query.ReadUserListsQuery
import server.mediator.response.AddListCommandResponse
import server.mediator.response.EmptyResponse
import server.mediator.response.ReadUserListsQueryResponse

@RestController
@RequestMapping("/wasteless")
class GroceryListController {

    @Autowired
    private lateinit var mediator: Mediator

    @RequestMapping("/lists/get/{userId}", method = [RequestMethod.GET])
    fun getUserLists(@PathVariable userId: Int): ResponseEntity<List<GroceryList>> {
        val request = ReadUserListsQuery(userId)
        val handler = mediator.handle<ReadUserListsQuery, ReadUserListsQueryResponse>(request)
        val response = handler.handle(request)
        return ResponseEntity.ok(response.lists)
    }

    @RequestMapping("/lists/add/{userId}", method = [RequestMethod.POST])
    fun addList(@PathVariable userId: Int, @RequestBody groceryList: GroceryList) {
        val request = AddListCommand(userId, groceryList)
        val handler = mediator.handle<AddListCommand, AddListCommandResponse>(request)
        val response = handler.handle(request)
    }

    @RequestMapping("/lists/delete/{listId", method = [RequestMethod.DELETE])
    fun deleteList(@PathVariable listId: Int) {
        val request = DeleteListCommand(listId)
        val handler = mediator.handle<DeleteListCommand, EmptyResponse>(request)
        handler.handle(request)
    }
}

