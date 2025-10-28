package com.example.proyecto_spring_boot.common.mediator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Mediator {

    Map<Class<?>, HandlerManage<?, ?>> handlerManageMap;

    public Mediator(List<HandlerManage<?, ?>> handlers) {
        handlerManageMap = handlers.stream().collect(Collectors.toMap(HandlerManage::getRequestType, Function.identity()));
    }

    public <R, T extends Request<R>> R dispatch(T request) {


        HandlerManage<T, R> handler = (HandlerManage<T, R>) handlerManageMap.get(request.getClass());
        if (handler == null) {
            throw new RuntimeException("Handler not found");
        }
        return handler.handle(request);
    }
}
