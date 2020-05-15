package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.command.UpdateUserCommand
import server.mediator.response.UpdateUserCommandResponse
import server.service.command.UserCommandService

@Component
class UpdateUserCommandHandler : Handler<UpdateUserCommand, UpdateUserCommandResponse> {

    @Autowired
    private lateinit var userCommandService: UserCommandService

    override fun handle(request: UpdateUserCommand): UpdateUserCommandResponse {
        TODO("Not yet implemented")
    }
}