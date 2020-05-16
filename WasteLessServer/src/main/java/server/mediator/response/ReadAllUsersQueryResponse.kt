package server.mediator.response

import server.db.model.User
import server.mediator.Response

class ReadAllUsersQueryResponse constructor(var users: List<User>)
    : Response {
}