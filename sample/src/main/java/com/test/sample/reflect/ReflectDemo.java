package com.test.sample.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        UserServiceImpl userService = new UserServiceImpl("kimi");
        Class clz = userService.getClass();

        System.out.println(clz.getName());

        Field[] declaredFields = clz.getDeclaredFields();//包含private
        System.out.println("成员变量:");
        Arrays.stream(declaredFields).forEach(field -> System.out.println(field));

        Method[] declaredMethods = clz.getDeclaredMethods();//包含private
        System.out.println("成员方法:");
        Arrays.stream(declaredMethods).forEach(method -> System.out.println(method));

        //获取无参构造方法
        Constructor constructor1 = clz.getDeclaredConstructor();
        System.out.println(constructor1);
        //调用私有构造器，必须设置它的访问全限
        constructor1.setAccessible(true);
        UserServiceImpl o1 = (UserServiceImpl)constructor1.newInstance();
        System.out.println(o1.getName() + "," + o1.getAge());

        //获取有参构造方法
        Constructor constructor2 = clz.getDeclaredConstructor(String.class, Integer.class);
        System.out.println(constructor2);
        UserServiceImpl o2 = (UserServiceImpl)constructor2.newInstance("kimi", 3);
        System.out.println(o2.getName() + "," + o2.getAge());

        //使用成员方法
        Method setNameMethod = clz.getMethod("setName", String.class);
        setNameMethod.invoke(userService, "小黑");
        System.out.println(userService.getName() + "," + userService.getAge());
    }
}
