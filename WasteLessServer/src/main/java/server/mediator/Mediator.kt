package server.mediator

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import server.config.SpringConfig
import server.mediator.command.AddListCommand
import server.mediator.handler.AddListCommandHandler
import server.mediator.handler.Handler
import server.mediator.handler.ReadListItemsQueryHandler
import server.mediator.handler.ReadUserListsQueryHandler
import server.mediator.query.ReadListItemsQuery
import server.mediator.query.ReadUserListsQuery
import java.lang.reflect.Type
import kotlin.reflect.jvm.javaType
import kotlin.reflect.typeOf


@ExperimentalStdlibApi
class Mediator{

    @Autowired
    lateinit var handlerMap: HashMap<Type, Type>

    init {
        handlerMap[typeOf<AddListCommand>().javaType] = typeOf<AddListCommandHandler>().javaType
        handlerMap[typeOf<ReadUserListsQuery>().javaType] = typeOf<ReadUserListsQueryHandler>().javaType
        handlerMap[typeOf<ReadListItemsQuery>().javaType] = typeOf<ReadListItemsQueryHandler>().javaType
    }

    inline fun <reified TRequest: Request, reified TResponse> handle(request: TRequest): TResponse{
        val handlerType = handlerMap[typeOf<TRequest>().javaType]
        val context: ApplicationContext = AnnotationConfigApplicationContext(SpringConfig::class.java)
        val handler = context.getBean(handlerType!!::class.java) as Handler<TRequest, TResponse>

        return handler.handle(request)
    }

}