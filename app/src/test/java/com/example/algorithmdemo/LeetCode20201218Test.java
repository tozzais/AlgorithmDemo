package com.example.algorithmdemo;


import org.junit.Test;

import java.util.Map;

/**
 方法一：哈希表
 思路及解法
 */
public class LeetCode20201218Test {

    @Test
    public void test() {

        System.out.println(findTheDifference("abcd","eabcd"));

    }

    /**
     * 随机重拍
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int length = s.length();
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < length+1; i++) {
            if (i != length){
                char c = s.charAt(i);
                a[c-'a'] ++;
            }
            char c1 = t.charAt(i);
            b[c1-'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]){
                return (char) ('a'+i);
            }
        }
        return ' ';
    }

}