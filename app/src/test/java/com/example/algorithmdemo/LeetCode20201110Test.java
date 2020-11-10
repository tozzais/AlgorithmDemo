package com.example.algorithmdemo;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 31. 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * 字典序参考
 * https://blog.csdn.net/qq_33594380/article/details/82377923
 * 解法：
 * （1）从右向左找到第一个左临小于右临的位置，左临的位置标记为i
 *
 * （2）从右向左找到第一个大于a[i] 的数值，位置为j
 *
 * （3）交换a[i] 与a[j] 的值
 *
 * （4）将i 右边的部分排成正序
 */
public class LeetCode20201110Test {
    @Test
    public void test() {
        int[] a = new int[]{1,5,8,4,7,6,5,3,1};
        nextPermutation(a);
    }
    //    16:11开始
    public void nextPermutation(int[] nums) {

        int i = nums.length-1;
        int j = nums.length-1;

        for (; i >0 ; i--) {
            if (nums[i-1]<nums[i]){
                break;
            }
        }
        if (i == 0){
            Arrays.sort(nums);
            print(nums);
        }else {
            i --;
            for (; j >= i ; j--) {
                if (nums[j]>nums[i]){
                    break;
                }
            }
            swap(nums,i,j);
            sort(nums,i+1);
            print(nums);
        }
    }
    private void swap(int[] nums,int i,int j){
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
    private void sort(int[] nums,int start){
        for (int i = start; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
    }

    private void print(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i == nums.length-1){
                System.out.print(num);
            }else {
                System.out.print(num+",");
            }
        }

    }


}