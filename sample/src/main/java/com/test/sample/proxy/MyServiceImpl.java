package com.test.sample.proxy;

public class MyServiceImpl implements MyService {
    @Override
    public void serve() {
        System.out.println("serving...");
    }
}
