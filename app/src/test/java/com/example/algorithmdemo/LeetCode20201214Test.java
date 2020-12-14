package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 柠檬水找零
 */
public class LeetCode20201214Test {

    @Test
    public void test() {

        String[] strings = new String[]{"ddddddddddg","dgggggggggg"};
        List<List<String>> lists = groupAnagrams(strings);
        for (List<String> list:lists
             ) {
            for (String s :
                    list) {
                System.out.print(s+" ");

            }
            System.out.println(" ");

        }

    }

    /**
     * 49. 字母异位词分组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (i == 0){
                List<String> list = new ArrayList<>();
                list.add(str);
                lists.add(list);
            }else {
                boolean isAdd = false;
                for (List<String> list:lists){
                    if (isEqual(list.get(0),str)){
                        //相等
                        list.add(str);
                        isAdd = true;
                        break;
                    }
                }
                if (!isAdd){
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    /**
     * 判断两个字符串是否 异位 相等
     * @param str1
     * @param str2
     * @return
     */
    private boolean isEqual(String str1,String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        Map<Character,Integer> set1 = new TreeMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            set1.put(c,set1.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> set2 = new TreeMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            set2.put(c,set2.getOrDefault(c,0)+1);
        }
        if (set1.size() != set2.size()){
            return false;
        }
        Set<Character> characters = set1.keySet();
        Set<Character> characters1 = set2.keySet();

        Object[] objects1 =  characters.toArray();
        Object[] objects2 =  characters1.toArray();
        for (int i = 0; i < objects1.length; i++) {
            if (objects1[i] != objects2[i]){
                return false;
            }
        }
        for (Character c:characters){
            Integer num1 = set1.getOrDefault(c, 0);
            Integer num2 = set2.getOrDefault(c, 0);
            if (num1 != num2){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个字符串是否 异位 相等
     * @param str1
     * @param str2
     * @return
     */
    private boolean isEqual1(String str1,String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars2);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars2[i]){
                return false;
            }
        }
        return true;
    }

}