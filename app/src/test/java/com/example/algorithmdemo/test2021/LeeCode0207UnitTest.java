package com.example.algorithmdemo.test2021;

import org.junit.Test;


/**
 * 665. 非递减数列
 */
public class LeeCode0207UnitTest {
    @Test
    public void test() {
        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}));
    }


    public boolean checkPossibility(int[] nums) {
        int left = nums[0];// 比较的左边
        int right ; //比较的右边
        int number = 0;
        for (int i = 1; i < nums.length; i++) {
            right = nums[i];
            if (left > right) {//当前数大于后一位
                number++;
                if (number > 1) {
                    return false;
                }
                //维护一个 可以的最小左边
                if (i == 1 || right >= nums[i - 2]) {
                    left = right;
                }
            } else {
                left = right;
            }
        }
        return true;
    }
}