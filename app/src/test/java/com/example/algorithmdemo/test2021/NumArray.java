package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 832. 翻转数组
 */
public class NumArray {
    @Test
    public void test() {
        int[][] a = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

    }

    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j ; k++) {
            sum += nums[k];
        }
        return sum;
    }

}