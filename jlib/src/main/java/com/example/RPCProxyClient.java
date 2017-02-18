package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhouli on 16/11/12.
 */
public class RPCProxyClient implements InvocationHandler {
    private Object object;

    public RPCProxyClient(Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke");
        System.out.println("method:"+method.getName());
        return null;
    }

    public static Object getProxy(Object object) {
        Class<HelloWorldService> clazz=(Class)object;
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                new RPCProxyClient(object));
    }
}
