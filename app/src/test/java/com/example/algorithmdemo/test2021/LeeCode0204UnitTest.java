package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


/**
 424. 替换后的最长重复字符
 */
public class LeeCode0204UnitTest {
    @Test
    public void test() {
        System.out.println(findMaxAverage1(new int[]{-1},1));
    }

    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        double sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            queue.add(num);
            sum += num;
            if (queue.size() == k){
                max =max == 0?sum:Math.max(max,sum);
                Integer poll = queue.poll();
                sum -= poll;
            }
        }
        return max/k;

    }

    public double findMaxAverage1(int[] nums, int k) {
        double max = 0;
        int left = 0;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (i>= k-1){
                max =max == 0?sum:Math.max(max,sum);
                sum -= nums[left];
                left++;
            }
        }
        return max/k;

    }
}