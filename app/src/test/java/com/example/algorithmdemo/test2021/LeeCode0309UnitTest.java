package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


/**
 * 503. 下一个更大元素 II
 */
public class LeeCode0309UnitTest {
    @Test
    public void test() {
        System.out.println(removeDuplicates("abbaca"));

    }

    public String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);

    }






}