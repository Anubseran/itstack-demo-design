package org.itstack.demo.desgin.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        //在方法中，创建了一个  JDKInvocationHandler  对象作为代理对象的调用处理器。
        //cacheAdapter实现类的方法不会被同步到动态生成的代理对象中，代理对象只会实现接口定义的方法，并通过调用处理器来处理方法调用。
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        //获取当前线程的类加载器作为代理对象的类加载器。
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 获取接口的 Class 对象数组，通常只取第一个接口。
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }

}
