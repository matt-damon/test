package com.test.sample.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * CGLIB动态代理：适用于未实现接口的类，创建代理对象时开销较大，但方法调用时性能较高。
 *
 * CGLIB动态代理的底层逻辑主要依赖于字节码生成技术和ASM框架。CGLIB通过生成目标类的子类来实现代理，并在子类中重写目标类的方法以插入额外的逻辑。具体步骤如下：
 * 1. 创建Enhancer对象：Enhancer是CGLIB中用于创建代理类的主要类。通过调用其setSuperclass()方法设置目标类的超类。
 * 2. 设置回调逻辑：通过调用Enhancer的setCallback()方法设置一个实现了MethodInterceptor接口的回调对象。该回调对象将负责拦截方法调用并执行额外的逻辑。
 * 3. 生成代理类：调用Enhancer的create()方法生成代理类的实例。在生成代理类的过程中，CGLIB会使用ASM框架修改目标类的字节码以插入代理逻辑。
 * 4. 拦截方法调用：当调用代理对象的方法时，该方法调用将被拦截并转发到回调对象的intercept()方法中。在intercept()方法中，可以执行额外的逻辑（如日志记录、权限检查等），然后通过调用MethodProxy.invokeSuper()方法执行目标类的原始方法。
 */


public class CglibProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyService.class);
        enhancer.setCallback(new MyMethodInterceptor());

        MyService proxy = (MyService) enhancer.create();
        proxy.serve();
    }
}
