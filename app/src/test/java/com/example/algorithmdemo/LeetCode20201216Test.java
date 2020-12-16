package com.example.algorithmdemo;


import org.junit.Test;

import java.util.HashMap;

/**
 方法一：哈希表
 思路及解法
 */
public class LeetCode20201216Test {

    @Test
    public void test() {
        char c = "123".charAt(1);

        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog dog dog dog"));


    }


    /**
     方法一：哈希表
     思路及解法
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if (array.length != pattern.length()){
            return false;
        }
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String s1 = array[i];
            char c = pattern.charAt(i);
            String orDefault = map.getOrDefault(c, "");
           if (orDefault.equals("") && !map.values().contains(s1) ){
                map.put(c,s1);
            }else if ((orDefault.equals("") && map.values().contains(s1))
                || !s1.equals(orDefault)){
               return false;
            }
        }
        return true;
    }



}