package com.example.algorithmdemo.test;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class LeetCode20201223Test {

    @Test
    public void test() {
        Map<Character, Integer> map = new LinkedHashMap<>();

        map.put('b', 1);
        map.put('b', 3);
        map.put('d', 3);
        map.put('a', 1);
        Set<Character> characters = map.keySet();
        for (Character c : characters) {
            System.out.println(c);
        }


    }


    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Set<Character> set = map.keySet();
        for (Character character:set){
            if (map.get(character) == 1){
                return s.indexOf(character);
            }
        }
        return -1;

    }


}