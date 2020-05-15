package server.service.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import server.db.model.GroceryItem
import server.db.repository.GroceryItemRepo

@Service
class GroceryItemQueryService {

    @Autowired
    private lateinit var groceryItemRepo: GroceryItemRepo

    fun getListItems(listId: Int): List<GroceryItem> =
            groceryItemRepo.getListItems(listId)
}