# ProxyUtil
base on cglib,generate proxy by java class or object

# usage
copy  [cglib-nodep-3.2.5.jar](https://github.com/hss01248/ProxyUtil/blob/master/proxy/lib/cglib-nodep-3.2.5.jar) and the java files in [com.hss01248.proxy](https://github.com/hss01248/ProxyUtil/tree/master/proxy/src/main/java/com/hss01248/proxy) to your project

# api
```

//generate a proxy object by class:
public static <T> T getProxy(Class<T> clazz,MethodInterceptor interceptor)

//generate a proxy object by a object which already exists:
public static <T> T getProxy(T obj,InvocationHandler handler)

//a wrapper for JDK's Dynamic Proxy.the proxy only covers those  methods that  implements from its interfaces
public static <T> T getIProxy(T obj,InvocationHandler handler)


```

# demo

```
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
                methodProxy.invokeSuper(o,objects);//the useage is different from the proxy generate by object
                 MyLog.i("after-------------2");
                 return null;
             }
         });
  cat2.fly();

```
