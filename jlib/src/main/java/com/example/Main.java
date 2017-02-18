package com.example;

public class Main {
    public static  void main(String []args) {
        HelloWorldService helloWorldService=(HelloWorldService) RPCProxyClient.getProxy(HelloWorldService.class);
        helloWorldService.sayHello();
    }
}
