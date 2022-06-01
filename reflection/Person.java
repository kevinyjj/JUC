package com.example.demo.reflection;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by Liuxd on 2018/8/14.
 */
@Component
public class Person {
    public String name;// 姓名
    public int age;// 年龄

    public Person() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    @PostConstruct
    public String showInfo() {
        return "name=" + name + ", age=" + age;
    }
    @Transactional
    public void say(){
        System.out.println("Person say Hello ! ");
    }
}
