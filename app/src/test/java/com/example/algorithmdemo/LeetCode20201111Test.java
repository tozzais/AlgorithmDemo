package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 514. 自由之路
 *
 * 一开始思想是计算每种可能路径的步骤（没有解出）
 *
 * https://leetcode-cn.com/problems/next-permutation/
 *
 */
public class LeetCode20201111Test {
    @Test
    public void test() {
        int[] a = new int[]{1,5,8,4,7,6,5,3,1};
        System.out.println(getMethod(4));
    }
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();

    }
    private int getMethod(int key){
        return (int) Math.pow(2,key);
    }

    //得到顺时针的步骤
    private int getClockwiseStep(String ring,char c){
        for (int i = 0; i < ring.length(); i++) {
            char c1 = ring.charAt(i);
            if (c1 == c){
                //加1 是因为要按下
                return i+1;
            }
        }
        return 0;
    }

    //得到逆时针的步骤
    private int getCounterclockwiseStep(String ring,char c){
        if (ring.charAt(0) == c){
            //要按下
            return 1;
        }
        for (int i = ring.length()-1; i >=0 ; i--) {
            char c1 = ring.charAt(i);
            if (c1 == c){
                //加1 是因为要按下
                return ring.length()-i+1;
            }
        }
        return 0;
    }

}