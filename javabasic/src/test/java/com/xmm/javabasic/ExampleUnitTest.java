package com.xmm.javabasic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        Vector<String> vector = new Vector<>();
        vector.add("123");
        vector.add("123");
        for (String s:vector){
            System.out.println(s);
        }

    }

    @Test
    public void setTest() {

        LinkedHashSet<String> vector = new LinkedHashSet<>();
        vector.add("123");
        vector.add("463");
        vector.add("4873");
        vector.add("73");
        vector.add("12373");
        vector.add("43");
        vector.add("3");
        for (String s:vector){
            System.out.println(s);
        }
    }

    @Test
    public void TreeSetTest() {

        TreeSet<String> vector = new TreeSet<>();
        vector.add("123");
        vector.add("463");
        vector.add("4873");
        vector.add("73");
        vector.add("12373");
        vector.add("43");
        vector.add("3");
        for (String s:vector){
            System.out.println(s);
        }
    }

    @Test
    public void HashMapTest() {

        HashMap<String,String> vector = new HashMap<>();
        vector.put(null,"123");
        System.out.println(vector.get(null));

        LinkedHashMap<String,String> vector2 = new LinkedHashMap<>();
        vector2.put(null,"123");
        System.out.println(vector2.get(null));

        Hashtable<String,String> vector1 = new Hashtable<>();
        vector1.put(null,"456");
        System.out.println(vector1.get(null));
    }

    @Test
    public void linkListTest() {

        List<String> vector = new LinkedList<>();
        vector.add("123");
        vector.add("123");
        for (String s:vector){
            System.out.println(s);
        }

    }

    @Test
    public void HashMapTest1() {

        WeakHashMap<String,String> vector = new WeakHashMap<>();
        vector.put(null,"123");
        System.out.println(vector.get(null));


    }
}