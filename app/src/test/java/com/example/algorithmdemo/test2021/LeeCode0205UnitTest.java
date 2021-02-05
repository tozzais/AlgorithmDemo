package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 1208. 尽可能使字符串相等
 */
public class LeeCode0205UnitTest {
    @Test
    public void test() {
        System.out.println(equalSubstring("aaaa","bbbbb",1));
    }


    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] array = new int[length];
        for (int i = 0; i < s.length(); i++) {
            array[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int sum = 0;
        while (end < length) {
            sum += array[end];
            while (sum > maxCost) {
                sum -= array[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;

    }
}