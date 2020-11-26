package com.example.algorithmdemo;


import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 164. 最大间距
 *
 */
public class LeetCode20201126Test {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  @Test
  public void test(){
      System.out.println(maximumGap(new int[]{3,6,9,1}));

  }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length<2) return 0;
        Arrays.sort(nums);
        int max = nums[1] - nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            int differ = nums[i+1] - nums[i];
            max = Math.max(max,differ);
        }
        return max;

    }

        public int maximumGap1(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return 0;
            }
            long exp = 1;
            int[] buf = new int[n];
            int maxVal = Arrays.stream(nums).max().getAsInt();

            while (maxVal >= exp) {
                int[] cnt = new int[10];
                for (int i = 0; i < n; i++) {
                    int digit = (nums[i] / (int) exp) % 10;
                    cnt[digit]++;
                }
                for (int i = 1; i < 10; i++) {
                    cnt[i] += cnt[i - 1];
                }
                for (int i = n - 1; i >= 0; i--) {
                    int digit = (nums[i] / (int) exp) % 10;
                    buf[cnt[digit] - 1] = nums[i];
                    cnt[digit]--;
                }
                System.arraycopy(buf, 0, nums, 0, n);
                exp *= 10;
            }

            int ret = 0;
            for (int i = 1; i < n; i++) {
                ret = Math.max(ret, nums[i] - nums[i - 1]);
            }
            return ret;
        }










}