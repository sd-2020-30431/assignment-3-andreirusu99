package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.command.UpdateUserCommand
import server.mediator.response.EmptyResponse
import server.service.command.UserCommandService

@Component
class UpdateUserCommandHandler : Handler<UpdateUserCommand, EmptyResponse> {

    @Autowired
    private lateinit var userCommandService: UserCommandService

    override fun handle(request: UpdateUserCommand): EmptyResponse {
        userCommandService.updateUser(request.userId, request.calories)
        return EmptyResponse()
    }
}