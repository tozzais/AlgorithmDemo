package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Arrays;


/**
 1128. 等价多米诺骨牌对的数量
 */
public class LeeCode0128UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{1,2},{1,2},{1,2},{1,4}};
    }


    public int pivotIndex(int[] nums) {
        if(nums.length==0 || nums==null){
            return -1;
        }
        int left = 0,right = 0;

        //将索引得位置初始化(从0开始)
        for(int num:nums){
            right+=num;
        }

        right-=nums[0];

        if(right == left){
            return 0;
        }

        for(int i=1;i<nums.length;i++){
            right -=nums[i];
            left +=nums[i-1];

            if(right == left){
                return i;
            }
        }

        return -1;
    }


}