package com.xmm.javabasic.reflection;

public class Student {
    private String name;
    protected   int age;
    public   boolean sex;
    char phoneNum;



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phoneNum=" + phoneNum +
                '}';
    }

    public String getName() {
        return name;
    }

    public Student(String name, int age) {
        System.out.println("有参构造函数");
        this.name = name;
        this.age = age;
    }

    public Student() {
        name = "公有无参构造函数";
        System.out.println("无参构造函数");
    }
    //私有构造方法
    private Student(int age){
        name = "私有无参构造函数";
        System.out.println("私有的构造方法   年龄："+ age);
    }

    //受保护的构造方法
    protected Student(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }




    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

}
