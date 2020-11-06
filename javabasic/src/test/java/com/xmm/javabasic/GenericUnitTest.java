package com.xmm.javabasic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的测试
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GenericUnitTest {
    @Test
    public void addition_isCorrect() {
        /**
         *
         */
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();
        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();
        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("类型相同");
        }
    }

    @Test
    public void test1() {
        /**
         * 泛型的作用
         * 1：代码复用
         * 2：不用强转
         */
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();
        stringArrayList.add("123");
        integerArrayList.add(456);
        integerArrayList.add(476);
        getData(stringArrayList);
        getData(integerArrayList);

//        Object obj = genericMethod(Class.forName("com.test.test"));
    }

    /**
     * 泛型通配符
     * @param objects
     */
    public void getData(List<?> objects){
        for (Object o:objects){
            System.out.println(o.toString());
        }
    }
    //泛型类
    public class Person<M>{

    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
    //三 类中的泛型方法
    public class GenericFruit {
        class Fruit{
            @Override
            public String toString() {
                return "fruit";
            }
        }
        class Apple extends Fruit{
            @Override
            public String toString() {
                return "apple";
            }
        }
        class Person{
            @Override
            public String toString() {
                return "Person";
            }
        }
        class GenerateTest<T>{
            public void show_1(T t){
                System.out.println(t.toString());
            }
            //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
            //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
            public <E> void show_3(E t){
                System.out.println(t.toString());
            }
            //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
            public <T> void show_2(T t){
                System.out.println(t.toString());
            }
        }
        @Test
        public void test3(){
            Apple apple = new Apple();
            Person person = new Person();

            GenerateTest<Fruit> generateTest = new GenerateTest<Fruit>();
            //apple是Fruit的子类，所以这里可以
            generateTest.show_1(apple);
            //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
            //generateTest.show_1(person);

            //使用这两个方法都可以成功
            generateTest.show_2(apple);
            generateTest.show_2(person);

            //使用这两个方法也都可以成功
            generateTest.show_3(apple);
            generateTest.show_3(person);
        }


    }


    /**
     * 四 泛型数组
     * 1:不能创建一个确切的泛型类型的数组
     *      比如 List<String>[] lsa = new List<String>[10];
     *    但是使用通配符确实可以的
     *      比如 List<?>[] lsa = new List<?>[10];
     *      或者这样
     *      List<?>[] lsa = new List[10];
     */
    @Test
    public void test4(){
        List<?> list = new ArrayList<>();
        List<?>[] lsa = new List[10]; // OK, array of unbounded wildcard type.
        lsa[0] = list;

        List<String> list1 = (List<String>) lsa[0];

        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Correct.
        Integer i = (Integer) lsa[1].get(0); // OK
    }

    /**
     * 五：获取泛型的参数类型
     */
    @Test
    public void test5(){
        /**
         * Type是什么
         * 这里的Type指java.lang.reflect.Type, 是Java中所有类型的公共高级接口, 代表了Java中的所有类型.
         * Type体系中类型的包括：
         * 数组类型(GenericArrayType)、带有泛型的数组，即T[]
         * 参数化类型(ParameterizedType)、,就是我们平常所用到的泛型List、Map；
         * 类型变量(TypeVariable)、
         * 通配符类型(WildcardType)、
         * 原始类型(Class)、
         * 基本类型(Class),
         * 以上这些类型都实现Type接口.
         *
         */
    }
    /**
     * 10，虚拟机是如何实现泛型的
     * 泛型在编译期间使用的，运行期间会被擦除成他的上级类型，没有上级类型则转换成Object
     * 目的：1：代码的
     * */
    @Test
    public void test6(){
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();
        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();
        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("类型===相同");
        }
    }


}