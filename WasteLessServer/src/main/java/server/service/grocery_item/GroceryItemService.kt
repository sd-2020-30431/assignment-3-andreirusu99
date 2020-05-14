package server.service.grocery_item

import server.db.model.GroceryItem
import java.util.*

interface GroceryItemService {

    fun getListItems(listId: Int): List<GroceryItem>

    fun addItem(
        listId: Int,
        itemName: String,
        itemQuantity: Int,
        calorieValue: Int,
        purchaseDate: Date,
        consumptionDate: Date,
        expirationDate: Date
    )

    fun updateItem(
        itemId: Int,
        itemName: String,
        itemQuantity: Int,
        calorieValue: Int,
        purchaseDate: Date,
        consumptionDate: Date,
        expirationDate: Date
    )

    fun deleteItem(itemId: Int)

}