package server.db.model

import org.springframework.beans.factory.annotation.Autowired
import server.db.report.Report
import server.db.report.ReportDTO
import server.service.query.GroceryItemQueryService
import server.service.query.GroceryListQueryService
import server.service.query.UserQueryService
import java.util.*

class WeeklyReport : Report {

    @Autowired
    private lateinit var groceryListQueryService: GroceryListQueryService

    @Autowired
    private lateinit var groceryItemQueryService: GroceryItemQueryService

    @Autowired
    private lateinit var userQueryService: UserQueryService

    override fun computeWastedCalories(userId: Int): ReportDTO {
        var calories = 0
        var items: ArrayList<GroceryItem> = ArrayList<GroceryItem>()
        val lists = groceryListQueryService.getUserLists(userId)
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
            if (then[Calendar.WEEK_OF_YEAR] == now[Calendar.WEEK_OF_YEAR]) {
                calories +=
                        item.calorieValue * item.itemQuantity - userQueryService.getUser(userId).calorieIntake
            }
        }
        return ReportDTO(calories)
    }
}