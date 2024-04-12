package org.itstack.demo.desgin.test;

import org.itstack.demo.desgin.CacheService;
import org.itstack.demo.desgin.factory.JDKProxy;
import org.itstack.demo.desgin.factory.impl.EGMCacheAdapter;
import org.itstack.demo.desgin.factory.impl.IIRCacheAdapter;
import org.itstack.demo.desgin.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_CacheService() throws Exception {

        //这是个动态生成的代理对象，没有代码上的具体实现？
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        //这是个动态生成的代理对象，没有代码上的具体实现？
        CacheService proxy_EGM2 = JDKProxy.getProxy(CacheServiceImpl.class, new CacheServiceImpl());
        proxy_EGM2.set("user_name_01", "小傅哥");
        String val012 = proxy_EGM2.get("user_name_01");
        System.out.println("测试结果：" + val012);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);

    }

}
