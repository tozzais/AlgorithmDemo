package com.example.algorithmdemo;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试数组
 *
 * https://leetcode-cn.com/tag/array/
 */
public class LeetCodeArrayTest {
    @Test
    public void test() {
        int[] a = new int[]{2,3,3};
        System.out.println(majorityElement(a));
    }
    /**
     * 旋转矩阵
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        int[][] b = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                b[j][i] = A[i][j];
            }
        }
        return b;


    }
    /**
     * 面试题 17.10. 主要元素 （ 2020-11-04）
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer integer = map.get(num);
            if (integer != null) map.put(num, integer + 1);
            else map.put(num, 1);
        }
        int main = -1;
        for (int i:map.keySet()){
            Integer integer = map.get(i);
            if (integer >nums.length/2){
                main = i;
                break;
            }
        }
        return main;

    }
    public int majorityElement1(int[] nums) {
        //判空
        if (nums.length == 0) {
            return -1;
        }

        //投票环节 众数major和一个频数count
        int major = 0;
        int vote = 0;
        //[1,2,5,9,5,9,5,5,5]
        for (int num : nums) {
            if (vote == 0) {
                major = num;
                vote++;
            } else {
                if (num == major) {
                    vote++;
                } else {
                    vote--;
                }
            }
        }
        //验证环节
        if (vote == 0) {
            return -1;
        }
        int identify = 0;
        for (int num : nums) {
            if (num == major) {
                identify++;
                if (identify > nums.length / 2) {
                    return major;
                }
            }
        }
        return -1;
    }
    /**
     * 1588. 所有奇数长度子数组的和
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i = i+2) {
            sum+= subSum(arr,i);
        }
        return sum;
    }
    public int subSum(int[] arr,int sub){
        int sum = 0;
        for (int i = 0; i < arr.length-sub+1; i++) {
            for (int j = i; j < i+sub; j++) {
                sum+= arr[j];
            }
        }
        return sum;
    }
    @Test
    public void test1() {
        int[] a = new int[]{1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(a));

    }
    /**
     * 628. 三个数的最大乘积
     */
    @Test
    public void maximumProduct() {
        int[] nums = new int[]{1,4,2,5,3};
        Arrays.sort(nums);
        int a = Math.max(nums[0] * nums[1] * nums[nums.length - 1]
                , nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);

    }

    /**
     * 219. 存在重复元素 II
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j <Math.min(nums.length,i+k+1) ; j++) {
                if (nums[i] == nums[j] && Math.abs(j-i)<=k) return true;
            }
        }
        return false;

    }


    @Test
    public void test2() {
        int[] a = new int[]{1,2,3,67};
        System.out.println(summaryRanges(a));
    }

    /**
     * 228. 汇总区间
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i, j = 0; j < nums.length; ++j){
            i = j;
            // try to extend the range [nums[i], nums[j]]
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                ++j;
            // put the range into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
        }
        return summary;
    }

}