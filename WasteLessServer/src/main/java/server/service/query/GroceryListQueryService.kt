package server.service.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import server.db.model.GroceryList
import server.db.repository.GroceryListRepo

@Service
class GroceryListQueryService {

    @Autowired
    private lateinit var groceryListRepo: GroceryListRepo

    fun getUserLists(userId: Int): List<GroceryList> =
            groceryListRepo.getUserLists(userId)

}