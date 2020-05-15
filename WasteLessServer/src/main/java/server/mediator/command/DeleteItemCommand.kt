package server.mediator.command

import server.mediator.Request

class DeleteItemCommand constructor(var itemId: Int)
    : Request {
}