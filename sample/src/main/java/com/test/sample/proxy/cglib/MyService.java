package com.test.sample.proxy.cglib;

//目标类，未实现任何接口
public class MyService {
    public void serve() {
        System.out.println("Serving...");
    }
}
