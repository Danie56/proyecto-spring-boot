package com.example.proyecto_spring_boot.common.mediator;

public interface HandlerManage<T extends Request<R>, R> {
    R handle(T request);

    Class<T> getRequestType();
}
