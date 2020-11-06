package com.xmm.javabasic;


import com.xmm.javabasic.reflection.Student;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射的测试
 *一：反射是什么：
 *  运行阶段动态获得类的class实例的方法，构造函数，成员变量，注解。并且可以调用类的方法，这种机制叫反射
 * 二：为什么要用：
 * 运行时提供的机制，所以在编写时候不清楚具体信息的就可以用反射
 *
 * 1：https://blog.csdn.net/qq_36226453/article/details/82790375
 */
public class ReflectionUnitTest {


    @Test
    public void test1() {
        System.out.println("androidx.appcompat.app".startsWith("androidx."));
        //一：获取Class对象的三种方式
        // * 1 Object ——> getClass();
        // * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
        // * 3 通过Class类的静态方法：forName（String  className）(常用)
        /**
         * 一：获取Class对象的三种方式
         *   * 1 Object ——> getClass();
         *   * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
         *   * 3 通过Class类的静态方法：forName（String  className）(常用)
         */
        //第一种
        Student student = new Student("",100);
        Class<? extends Student> aClass = student.getClass();
        System.out.println(aClass.getName());
        //第二种
        Class<Student> aClass1 = Student.class;
        System.out.println(aClass == aClass1); //返回true
        //第三种
        try {
            Class<?> aClass2 = Class.forName("com.xmm.java.reflection.Student");
            System.out.println(aClass2 == aClass1); //返回true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
    /**
     * 通过反射获取构造方法并使用：
     */
    @Test
    public void test2() throws Exception {
        Class<?> aClass = Class.forName("com.xmm.java.reflection.Student");
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor constructor:constructors){
            System.out.println(constructor);
        }
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        constructors = aClass.getDeclaredConstructors();
        for (Constructor constructor:constructors){
            System.out.println(constructor);
        }
        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor<?> constructor = aClass.getConstructor(null);
        System.out.println("con = " + constructor);
        //调用构造方法
        Object obj = constructor.newInstance();
        System.out.println("obj = " + obj);
        Student stu = (Student)obj;
        System.out.println("obj = " + stu.getName());
        System.out.println("******************获取私有构造方法，并调用*******************************");
        constructor = aClass.getDeclaredConstructor(int.class);
        System.out.println("con = " + constructor);
        constructor.setAccessible(true);
        obj = constructor.newInstance(100);
        stu = (Student)obj;
        System.out.println("obj = " + stu.getName());
    }

    /**
     * 获取成员变量并调用
     */
    @Test
    public void test3() throws Exception {
        Class<?> stuClass = Class.forName("com.xmm.java.reflection.Student");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field sex = stuClass.getField("sex");
//        System.out.println(sex);
        //获取一个对象
        Object obj = stuClass.getConstructor(String.class,int.class).newInstance("",100);
        sex.set(obj,false);
        //验证
        Student stu = (Student)obj;
        System.out.println("验证性别：" + stu.sex);

        System.out.println("**************获取私有字段****并调用********************************");
        Field name = stuClass.getDeclaredField("name");
        System.out.println(name);
        name.setAccessible(true);
        name.set(obj,"张三");
        System.out.println("验证姓名：" + stu.getName());
    }

    /**
     * 获取成员方法并调用
     */
    @Test
    public void test4() throws Exception {
        Class<?> stuClass = Class.forName("com.xmm.java.reflection.Student2");
        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methodArray  = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method show1 = stuClass.getMethod("show1", String.class);
        System.out.println(show1);
        Object o = stuClass.getConstructor().newInstance();
        show1.invoke(o,"hahaha");

        System.out.println("***************获取私有的show4()方法******************");
        Method show4 = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(show4);
        show4.setAccessible(true);
        Object invoke = show4.invoke(o, 100);
        System.out.println("返回值：" + invoke);
    }



}