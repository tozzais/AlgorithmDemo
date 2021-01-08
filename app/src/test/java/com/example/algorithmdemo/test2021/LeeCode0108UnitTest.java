package com.example.algorithmdemo.test2021;

import org.junit.Test;


/**
 旋转数组
 */
public class LeeCode0108UnitTest {
    @Test
    public void test() {
        int[] a = new int[]{1,2,3,4,5,6,7};
        rotate(a,3);

    }



    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }



}