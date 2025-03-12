package com.test.sample.proxy.jdk;

import com.test.sample.proxy.jdk.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void serve() {
        System.out.println("serving...");
    }
}
