package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1208. 尽可能使字符串相等
 */
public class LeeCode0206UnitTest {
    @Test
    public void test() {
        System.out.println(maxScore(new int[]{1,2,3,4,5},3));
    }


    public int maxScore(int[] cardPoints, int k) {

        int sum = 0;
        int length = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[length-i-1];
            sum -= cardPoints[k-i-1];
            max = Math.max(max,sum);
        }
        return max;




    }
}