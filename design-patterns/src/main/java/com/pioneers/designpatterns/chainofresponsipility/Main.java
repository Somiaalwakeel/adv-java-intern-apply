package com.pioneers.designpatterns.chainofresponsipility;

public class Main {
    public static void main(String[] args) {
        final Handler<String> fourthHandler = new FourthHandler(null);
        final Handler<String> thirdHandler = new ThirdHandler(fourthHandler);
        final Handler<String> secondHandler = new SecondHandler(thirdHandler);
        final Handler<String> firstHandler = new FirstHandler(secondHandler);

        try {
            firstHandler.handle("fourth");
        } catch (ChainOfResponsibilityException e) {
            System.out.println(e.getMessage());
        }
    }
}
