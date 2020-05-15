package server.mediator.command

import server.mediator.Request

class DeleteListCommand constructor(var listId: Int)
    : Request