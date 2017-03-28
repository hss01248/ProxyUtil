package com.hss01248.proxy;


import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class ProxyUtil {


    /**
     * 根据class字节码来生成全新的代理对象
     * @param clazz
     * @param interceptor  内部调用的方法应该是:Object result = proxy.invokeSuper(obj,args);
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> clazz,MethodInterceptor interceptor){
        return new CglibClassProxy<T>().getProxy(clazz,interceptor);
    }

    /**
     * 根据传入的对象来生成代理对象,给这个对象包了一层壳
     * @param obj
     * @param handler
     * @param <T>
     * @return
     */
    public static <T> T getProxy(T obj,InvocationHandler handler){
        return new CglibObjectProxy<T>().getProxy(obj,handler);
    }


    /**
     * jdk 自带的动态代理.只代理类所实现的接口方法.尤其要注意,不能代理抽象类的实现类(直接抛异常)
     * @param obj
     * @param handler
     * @param <T>
     * @return
     */
    public static <T> T getIProxy(T obj,InvocationHandler handler){
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }




}
