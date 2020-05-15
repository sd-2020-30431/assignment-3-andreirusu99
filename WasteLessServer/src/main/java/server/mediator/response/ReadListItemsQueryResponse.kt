package server.mediator.response

import server.db.model.GroceryItem
import server.mediator.Response

class ReadListItemsQueryResponse constructor(var items: List<GroceryItem>)
    : Response