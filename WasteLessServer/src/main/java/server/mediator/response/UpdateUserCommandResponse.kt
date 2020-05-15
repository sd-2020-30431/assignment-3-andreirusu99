package server.mediator.response

import server.mediator.Response

class UpdateUserCommandResponse constructor(var userId: Int, var calories: Int)
    : Response