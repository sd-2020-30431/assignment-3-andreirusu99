package server.mediator.command

import server.db.model.User
import server.mediator.Request

class AddUserCommand constructor(var user: User)
    : Request