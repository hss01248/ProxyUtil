package com.hss01248.proxydemo;


import com.hss01248.proxy.ProxyUtil;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class Test {



    public static void main(String[] args){



        Cat cat = ProxyUtil.getProxy(new Cat(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                MyLog.i("before-------------");
                 method.invoke(proxy,args);
                MyLog.i("after-------------");
                return null;
            }
        });
        cat.fly();

        Cat cat2 = ProxyUtil.getProxy(Cat.class, new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                MyLog.i("before-------------2");
               methodProxy.invokeSuper(o,objects);
                MyLog.i("after-------------2");
                return null;
            }
        });
        cat2.fly();


       /* CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        Cat proxyImp = (Cat)proxy.getProxy(Cat.class);
        proxyImp.fly();*/


    }

}
