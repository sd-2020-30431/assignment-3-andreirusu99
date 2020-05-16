package server.db.report.entity

import org.springframework.beans.factory.annotation.Autowired
import server.db.model.GroceryItem
import server.db.model.User
import server.db.report.Report
import server.service.query.GroceryItemQueryService
import server.service.query.GroceryListQueryService
import java.util.*

class MonthlyReport : Report{

    @Autowired
    private lateinit var groceryListQueryService: GroceryListQueryService

    @Autowired
    private lateinit var groceryItemQueryService: GroceryItemQueryService

    override fun computeWastedCalories(user: User): Int {
        var calories = 0
        var items: ArrayList<GroceryItem> = ArrayList<GroceryItem>()
        val lists = groceryListQueryService.getUserLists(user.id)
        for (list in lists) {
            items = ArrayList(groceryItemQueryService.getListItems(list.id))
            for (item in items) {
                items.add(item)
            }
        }
        val now = Calendar.getInstance()
        for (item in items) {
            val then = Calendar.getInstance()
            then.time = item.consumptionDate
            if (then[Calendar.MONTH] == now[Calendar.MONTH]) {
                calories += item.calorieValue * item.itemQuantity - user.calorieIntake
            }
        }
        return calories
    }
}