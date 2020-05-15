package server.mediator.handler

import org.springframework.stereotype.Component
import server.mediator.Handler
import server.mediator.command.AddListCommand
import server.mediator.response.AddListCommandResponse

@Component
class AddListCommandHandler : Handler<AddListCommand, AddListCommandResponse> {

    override fun handle(request: AddListCommand): AddListCommandResponse {
        TODO("Not yet implemented")
    }
}