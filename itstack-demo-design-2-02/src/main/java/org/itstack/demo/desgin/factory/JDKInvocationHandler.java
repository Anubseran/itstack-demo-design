package org.itstack.demo.desgin.factory;

import org.itstack.demo.desgin.CacheService;
import org.itstack.demo.desgin.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    private Object object;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    public JDKInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("哈哈");
        //return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
        //ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
        //Object res = proxy.getClass().getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(proxy, args);
        //Object res = method.invoke(proxy, args);
        Object res;
        if (Objects.isNull(object)) {
            res = ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
        }else {
            res = method.invoke(object, args);
        }
        System.out.println("哈哈2");
        return res;
    }

}
