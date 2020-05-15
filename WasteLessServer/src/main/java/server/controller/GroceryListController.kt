package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import server.db.model.GroceryList
import server.mediator.Mediator
import server.mediator.query.ReadUserListsQuery
import server.mediator.response.ReadUserListsQueryResponse
import server.service.grocery_list.GroceryListService

@RestController
@RequestMapping("/wasteless")
class GroceryListController {

    @Autowired
    private lateinit var groceryListService: GroceryListService

    @Autowired
    private lateinit var mediator: Mediator

    @RequestMapping("/lists/get/{userId}", method = [RequestMethod.GET])
    fun getUserLists(@PathVariable userId: Int): ResponseEntity<List<GroceryList>> {
        val request = ReadUserListsQuery(userId)
        val handler = mediator.handle<ReadUserListsQuery, ReadUserListsQueryResponse>(request)
        val response = handler.handle(request)
        //return response.lists
        return ResponseEntity.ok(groceryListService.getUserLists(userId))
    }


    @RequestMapping("/lists/add/{userId}", method = [RequestMethod.POST])
    fun addList(@PathVariable userId: Int, @RequestBody groceryList: GroceryList) =
            ResponseEntity.ok(groceryListService.addList(userId, groceryList.listName))

    @RequestMapping("lists/update/{listId}", method = [RequestMethod.PUT])
    fun updateList(@PathVariable listId: Int, @RequestBody groceryList: GroceryList) =
            ResponseEntity.ok(groceryListService.updateList(listId, groceryList.listName))

    @RequestMapping("/lists/delete/{listId", method = [RequestMethod.DELETE])
    fun deleteList(@PathVariable listId: Int) =
            ResponseEntity.ok(groceryListService.deleteList(listId))
}

