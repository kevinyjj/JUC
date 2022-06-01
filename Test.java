package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.reflection.Person;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Test {
    private final static Logger log = LoggerFactory.getLogger(Test.class);

    private final static int a = 1;
    public static void main(String[] args) throws Exception {

        /*AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = annotationConfigApplicationContext.getBean(Person.class);
        person.showInfo();
        String a = "";
        a += "1111";
        if(!a.contains("1111")){
            a += "2222";
        }
        System.out.println(a);
        Class<?> clz = Class.forName("com.example.demo.A");
        Object o = clz.newInstance();
        Method m = clz.getDeclaredMethod("hello", String.class);
        m.invoke(o,"yangjj");

        //实例化TreeMap-
        TreeMap< Integer, String > tm = new TreeMap < Integer, String > ();

        //通过使用put()方法是
        //将键值对放在
        //树状图TM-
        tm.put(1, "C");
        tm.put(4, "C++");
        tm.put(3, "Java");
        tm.put(2, "Php");

        //显示TreeMap tm-
        System.out.println("tm: " + tm);

        //通过使用get(4)方法
        //返回关联的值
        //给定关键元素“ 4”"4"
        //显示返回值元素
        System.out.println("tm.get(4): " + tm.get(4));
        String a = null;
        tm.get(a);*/



        String encode = Base64.getEncoder().encodeToString( "杨益敏".getBytes( "UTF-8"));
        System.out.println(encode);
// 解码
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println( new String(decode, "UTF-8"));

    }

    public static int getValue(){
        int j = 0;
        for(int i=0;i<5;i++){
            j = i;
            System.out.println("i=="+i);
            return j;
        }
        return j;
    }
}

class A{
    public void hello(String name) {
        System.out.println(name+",hello world");
    }
}
