package com.pioneers.designpatterns.chainofresponsipility;

public interface Handler<T> {
    void handle(T input);
}
