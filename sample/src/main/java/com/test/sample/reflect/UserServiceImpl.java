package com.test.sample.reflect;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    private Integer age;
    private String name;

    public UserServiceImpl(String name) {
        this.name = name;
    }

    public UserServiceImpl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void login() {
        System.out.println("user " + name + " login...");
    }

    private void print() {
        System.out.println("name:" + name + ",age:" + age);
    }

}
