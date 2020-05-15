package server.mediator.response

import server.db.model.GroceryItem
import server.mediator.Response

class AddItemCommandResponse constructor(var item: GroceryItem)
    : Response