package server.mediator.response

import server.db.model.GroceryList
import server.mediator.Response

class AddListCommandResponse constructor(var list: GroceryList)
    : Response