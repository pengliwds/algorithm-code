package com.pengli.designPattern.structural.proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(T target) {

        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DynamicProxyHandler<>(target));

    }

    private static class DynamicProxyHandler<T> implements InvocationHandler {

        private T target;

        public DynamicProxyHandler(T target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            // 扩展的功能
            System.out.println("代理类说我爱你");

            return method.invoke(target, args);
        }
    }

}
