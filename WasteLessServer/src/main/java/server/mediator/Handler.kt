package server.mediator

interface Handler<in TRequest : Request, out TResponse> {

    fun handle(request: TRequest): TResponse
}