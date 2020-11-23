package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试 贪心算法
 *
 * https://leetcode-cn.com/tag/array/
 */
public class LeetCodeGreedyTest {
    @Test
    public void test() {
        int[] a = new int[]{2,3,3};
    }
    /**
     * 1403. 非递增顺序的最小子序列
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        Arrays.sort(nums);
        int subSum = 0;
        for (int i = nums.length-1; i >=0 ; i--) {
            int num = nums[i];
            subSum += num;
            list.add(num);
            if (subSum>sum/2){
                break;
            }
        }
        return list;
    }


}