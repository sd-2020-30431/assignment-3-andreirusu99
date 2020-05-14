package server.mediator.handler

import server.mediator.Request

interface Handler<in TRequest : Request, out TResponse> {

    fun handle(request: TRequest): TResponse
}