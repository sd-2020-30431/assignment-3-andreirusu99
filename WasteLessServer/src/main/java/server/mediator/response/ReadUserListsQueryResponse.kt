package server.mediator.response

import server.db.model.GroceryList
import server.mediator.Response

class ReadUserListsQueryResponse constructor(var lists: List<GroceryList>)
    : Response