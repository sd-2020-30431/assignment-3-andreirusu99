package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.query.ReadAllUsersQuery
import server.mediator.response.ReadAllUsersQueryResponse
import server.service.query.UserQueryService

@Component
class ReadAllUsersQueryHandler
    : Handler<ReadAllUsersQuery, ReadAllUsersQueryResponse> {

    @Autowired
    private lateinit var userQueryService: UserQueryService

    override fun handle(request: ReadAllUsersQuery): ReadAllUsersQueryResponse {
        return ReadAllUsersQueryResponse(userQueryService.getAllUsers())
    }
}