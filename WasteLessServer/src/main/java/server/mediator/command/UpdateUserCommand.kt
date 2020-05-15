package server.mediator.command

import server.mediator.Request

class UpdateUserCommand constructor(var userId: Int, var calories: Int)
    : Request