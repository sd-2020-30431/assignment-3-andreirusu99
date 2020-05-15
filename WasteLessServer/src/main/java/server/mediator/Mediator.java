package server.mediator;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import server.mediator.command.AddListCommand;
import server.mediator.handler.AddListCommandHandler;
import server.mediator.handler.ReadListItemsQueryHandler;
import server.mediator.handler.ReadUserListsQueryHandler;
import server.mediator.query.ReadListItemsQuery;
import server.mediator.query.ReadUserListsQuery;

import java.util.HashMap;
import java.util.Map;

@Component
public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final Map<Class<? extends Request>,
            Class<? extends Handler<? extends Request, ? extends Response>>> handlerMap;

    public Mediator() {
        this.handlerMap = new HashMap<>();
        handlerMap.put(AddListCommand.class, AddListCommandHandler.class);
        handlerMap.put(ReadUserListsQuery.class, ReadUserListsQueryHandler.class);
        handlerMap.put(ReadListItemsQuery.class, ReadListItemsQueryHandler.class);
    }

    public <T extends Request, R extends Response> Handler<T, R> handle(T request) {
        Class<? extends Handler<? extends Request, ? extends Response>> handlerType = handlerMap.get(request.getClass());
        return (Handler<T, R>) applicationContext.getBean(handlerType);
    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}