package server.mediator.command

import server.db.model.User
import server.mediator.Request

class LoginUserCommand constructor(var user: User)
    : Request