package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Arrays;


/**
 * 所有点的最小链接距离
 */
public class LeeCode0120UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    }

    public int maximumProduct(int[] nums) {
        int length = nums.length;
        if (length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int i = nums[0] * nums[1] * nums[length - 1];
        int j = nums[length - 1] * nums[length - 2] * nums[length - 3];
        return Math.max(i, j);
    }
    public int maximumProduct1(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

    }
}