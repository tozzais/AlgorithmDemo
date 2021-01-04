package com.example.algorithmdemo.test;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *330. 按要求补齐数组
 */
public class LeetCode20201229Test {

    @Test
    public void test() {

        int[] num = new int[]{1,5,10};
        System.out.println(minPatches(num,20));

    }

        public int minPatches(int[] nums, int n) {
            int patches = 0;
            long x = 1;
            int length = nums.length, index = 0;
            while (x <= n) {
                if (index < length && nums[index] <= x) {
                    x += nums[index];
                    index++;
                } else {
                    x *= 2;
                    patches++;
                }
            }
            return patches;
        }





}