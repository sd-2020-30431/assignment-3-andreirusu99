package server.mediator.command

import server.db.model.GroceryList
import server.mediator.Request

class AddListCommand constructor(var list: GroceryList)
    : Request