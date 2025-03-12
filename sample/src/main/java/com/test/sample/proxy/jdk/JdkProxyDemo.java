package com.test.sample.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理：适用于接口驱动的编程模式，创建代理对象时开销较小，但方法调用时性能略慢。
 *
 * JDK动态代理的底层逻辑主要依赖于反射机制和InvocationHandler接口。当调用代理对象的方法时，代理类会拦截该方法调用，并通过InvocationHandler.invoke()方法执行额外的逻辑。具体步骤如下：
 * 1. 创建代理对象：使用Proxy.newProxyInstance()方法创建代理对象。该方法需要三个参数：类加载器、目标类实现的接口列表和一个实现了InvocationHandler接口的处理器对象。
 * 2. 拦截方法调用：当调用代理对象的方法时，代理类会拦截该方法调用，并将调用转发给InvocationHandler的invoke()方法。
 * 3. 执行额外逻辑：在invoke()方法中，可以执行额外的逻辑（如日志记录、权限检查等），然后通过反射调用目标对象的方法来完成实际的业务逻辑。
 */


public class JdkProxyDemo {
    public static void main(String[] args) {
        MyServiceImpl service = new MyServiceImpl();

        /**
         * 当程序启动时，类加载器首先会读取类对应的字节码文件（.class文件），将其加载到JVM中。随后，JVM会基于
         * 这些字节码数据，通过类加载器创建出对应的Class对象，并根据需要进一步实例化为具体对象
         *
         * 当我们请求JVM创建一个动态代理时，JVM会为我们“临时”生成这个代理类的字节码。这并不是从文件系统中读取的，
         * 而是基于我们给定的接口和实现，即时生成的。 在这里，ClassLoader的任务是加载这个“临时生成”的字节码到JVM的内存中。
         * 这意味着，尽管代理类的字节码并没有物理存在，但ClassLoader依然可以处理它，就像处理其他常规Java类一样。
         *
         * 在Java项目中，每个类都有它自己对应的类加载器，确保了类的隔离和安全性。在动态代理的场景中，
         * 我们实际上是复用了某个现有类的加载器来加载代理类，确保代理类能够顺利地与原始 类在同一个上下文中工作
         */

        MyService proxy = (MyService) Proxy.newProxyInstance(
                //目标对象的类加载器，它负责加载动态生成的代理类
                service.getClass().getClassLoader(),
                //目标对象实现的接口，获得目标类的所有接口，代理类需要实现这些接口
                service.getClass().getInterfaces(),
                new MyInvocationHandler(service));
        proxy.serve();
    }
}
