package server.service.command

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import server.db.model.GroceryList
import server.db.repository.GroceryListRepo
import javax.transaction.Transactional

@Service
class GroceryListCommandService {

    @Autowired
    private lateinit var groceryListRepo: GroceryListRepo

    fun addList(userId: Int, listName: String): GroceryList {
        val groceryList = GroceryList(listName = listName, userId = userId)
        println("List {} stored".format(listName))
        return groceryListRepo.save(groceryList)
    }

    @Transactional
    fun updateList(listId: Int, newName: String) {
        groceryListRepo.findById(listId).let {
            it.ifPresent{ list ->
                list.listName = newName
            }
        }
    }

    fun deleteList(listId: Int) {
        groceryListRepo.deleteById(listId)
    }
}