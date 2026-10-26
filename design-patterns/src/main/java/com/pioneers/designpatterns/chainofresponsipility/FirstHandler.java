package com.pioneers.designpatterns.chainofresponsipility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstHandler implements Handler<String> {

    private final Handler<String> nextHandler;

    public FirstHandler(Handler<String> nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(final String message) throws ChainOfResponsibilityException {

        if (!"first".equals(message)) {
            if (nextHandler == null) {
                throw new ChainOfResponsibilityException("The next handler is null");
            }
            nextHandler.handle(message);
            return;
        }

        log.info("Implementing FirstHandler");
    }
}
