package server.mediator.command

import server.db.model.GroceryItem
import server.mediator.Request

class AddItemCommand constructor(var item: GroceryItem)
    : Request