package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 */
public class LeetCode20201201Test {



    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[]{-1,-1};
        if (nums == null || nums.length == 0) return a;
        int start = 0,end = nums.length-1;
        //第一次找到target的位置
        int position = getPosition(nums, start, end, target);
        if (position != -1){
            a[0] = position;
            a[1] = position;
            //找得到 得到最前面的位置
            int start1 = getPosition(nums, start, position-1, target);
            while (start1 != -1){
                a[0] = start1;
                //子序列找到了
                if (nums[start1] == target){
                    //等于 往前
                    start1 = getPosition(nums, start, start1-1, target);
                }else {
                    //小于 往后
                    start1 = getPosition(nums, start1+1, position, target);
                }
            }
            //找得到 得到最后面的位置
            int end1 = getPosition(nums, position+1, end, target);
            while (end1 != -1){
                a[1] = end1;
                //子序列找到了
                if (nums[end1] == target){
                    //等于 往前
                    end1 = getPosition(nums, end1+1, end, target);
                }else {
                    //大于往前
                    end1 = getPosition(nums, position, end1-1, target);
                }
            }
        }
        return a;
    }
    /**
     *
     * 找到数组中从start到end 范围内target的位置 没有 @return -1
     * @param nums 数组
     * @param start
     * @param end
     * @param target 目标
     * @return
     */
    private int getPosition(int[] nums,int start,int end,int target){
        int position = (end + start)/2;
        boolean isHave = false;
        while (start<=end){
            int num = nums[position];
            if (num>target){
                end = position-1;
                position = (end+start)/2;
            }else if (num<target){
                start = position+1;
                position = (start+end)/2;
            }else {
                isHave = true;
                break;
            }
        }
        return isHave?position:-1;
    }
    @Test
    public void test() {
//        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
//        for (int i = 0; i < 12; i++) {
//            System.out.println(getPosition(a,0,6,i));
//        }

//        int[] b = new int[]{5,7,7,8,8,10};
        int[] c = new int[]{1};
//        for (int i = 0; i < 12; i++) {
//            System.out.println(getPosition(a,0,9,i));
//        }
        int[] ints = searchRange(c, 1);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }




}