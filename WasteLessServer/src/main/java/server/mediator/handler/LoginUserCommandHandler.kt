package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.command.LoginUserCommand
import server.mediator.response.LoginUserCommandResponse
import server.service.command.UserCommandService

@Component
class LoginUserCommandHandler : Handler<LoginUserCommand, LoginUserCommandResponse> {

    @Autowired
    private lateinit var userCommandService: UserCommandService

    override fun handle(request: LoginUserCommand): LoginUserCommandResponse {
        return LoginUserCommandResponse(
                userCommandService.attemptLogin(
                        request.user.firstName,
                        request.user.lastName,
                        request.user.password
                ))
    }
}