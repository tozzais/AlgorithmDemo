package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 242. 有效的字母异位词
 *
 */
public class LeetCode20201122Test {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    @Test
    public void test(){
        System.out.println(isAnagram("rat","car"));
    }
    public boolean isAnagram(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1,char2);
    }







}