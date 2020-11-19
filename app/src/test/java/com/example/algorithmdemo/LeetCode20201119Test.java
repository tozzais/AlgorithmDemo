package com.example.algorithmdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 283. 移动零
 * 备注：
 *
 */
public class LeetCode20201119Test {

    @Test
    public void test(){
        int[] a = new int[]{0,1,0,3,12};
        moveZeroes(a);
    }

    /**
     *
     * @return
     */
    public void moveZeroes(int[] nums) {
        int[] clone = nums.clone();
        int zeroNumber = 0;
        for (int i = 0; i < clone.length; i++) {
            int i1 = clone[i];
            if (i1 == 0){
                zeroNumber++;
            }else {
                nums[i-zeroNumber] = i1;
            }
        }
        for (int i = 0; i < zeroNumber; i++) {
            nums[nums.length-zeroNumber+i] = 0;
        }



    }






}