package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 127. 单词接龙
 * <p>
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class LeetCode20201106Test {
    @Test
    public void test() {
        int[] a = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] ints = sortByBits(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    //官方解答1
    public int[] sortByBits(int[] arr) {
        final int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    //官方解答1
    public int[] sortByBits2(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
        }
        final int[] bit = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }


    public int[] sortByBits1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            map.put(i1, getOneNumber(i1));
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int i1 = arr[i];
                int i2 = arr[j];
                Integer number1 = map.get(i1);
                Integer number2 = map.get(i2);
                if (number1 > number2 || (number1 == number2 && i1 > i2)) {
                    int e = i1;
                    arr[i] = i2;
                    arr[j] = e;
                }
            }
        }
        return arr;

    }

    public int getOneNumber(int number) {
        if (number == 0) {
            return 0;
        }
        int oneNumber = 0;
        while (number != 1) {
            if (number % 2 == 1) {
                oneNumber++;
            }
            number = number / 2;
        }
        oneNumber++;
        return oneNumber;
    }


}