package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 402. 移掉K位数字
 * 备注：
 *
 */
public class LeetCode20201115Test {

    @Test
    public void test(){
        System.out.println(removeKdigits("1234654",4));

    }

            public String removeKdigits(String num, int k) {
                Deque<Character> deque = new LinkedList<Character>();
                int length = num.length();
                for (int i = 0; i < length; ++i) {
                    char digit = num.charAt(i);
                    while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                        deque.pollLast();
                        k--;
                    }
                    deque.offerLast(digit);
                }

                for (int i = 0; i < k; ++i) {
                    deque.pollLast();
                }

                StringBuilder ret = new StringBuilder();
                boolean leadingZero = true;
                while (!deque.isEmpty()) {
                    char digit = deque.pollFirst();
                    if (leadingZero && digit == '0') {
                        continue;
                    }
                    leadingZero = false;
                    ret.append(digit);
                }
                return ret.length() == 0 ? "0" : ret.toString();
            }







}