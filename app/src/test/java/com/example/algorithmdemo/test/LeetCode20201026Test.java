package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode20201022Test
 *
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class LeetCode20201026Test {
    @Test
    public void test() {
        int[] array = new int[]{6,6,6,6};
        smallerNumbersThanCurrent(array);
    }


    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[][] array = new int[nums.length][1];
        int[] array1 = new int[nums.length];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]<nums[j]){
                    array[j][0]++;
                }else if (nums[i]>nums[j]){
                    array[i][0]++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            array1[i] = array[i][0];
            System.out.println(array1[i]);
        }
        return array1;
    }

}