package com.example.demo.reflection;


import java.lang.reflect.Method;

/**
 * Created by Liuxd on 2018/8/14.
 */
public class TestAttributes {

    public static void main(String[] args) {
        Class stu = null;
        try {
            stu = Class.forName("com.example.demo.reflection.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 获取对象的所有公共方法
        Method[] methods = stu.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("---------------------");
        // 获取对象所有方法，但不包含继承的
        Method[] declaredMethods = stu.getDeclaredMethods();
        for (Method ms : declaredMethods) {
            System.out.println(ms);
        }

    }
}
