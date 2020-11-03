package com.example.algorithmdemo;

import org.junit.Test;

import java.util.HashSet;

/**
 * 941. 有效的山脉数组
 *
 * https://leetcode-cn.com/problems/valid-mountain-array/
 */
public class LeetCode20201103Test {
    @Test
    public void test() {
        int[] a = new int[]{0,3,2,1};



    }
    public boolean validMountainArray(int[] A) {
        if (A.length == 0 || A.length ==1){
            return false;
        }
        int max = A[0];
        boolean isRise = true; //是否是上升区间
        boolean isRight = true; //是否正确
        for (int i = 1; i < A.length; i++) {
            int next = A[i];
            if (isRise && next>max){
                max = next;
            }else if (i>1 && next<max){
                //必须要有上升期 所有才有i>1的条件
                max = next;
                isRise = false;
            }else {
                isRight = false;
                break;
            }
        }
        return isRight && !isRise;
    }



}