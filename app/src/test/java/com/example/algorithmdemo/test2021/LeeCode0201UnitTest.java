package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * 最小体力消耗路径
 */
public class LeeCode0201UnitTest {
    @Test
    public void test() {
        System.out.println(fairCandySwap(new int[]{1,1},new int[]{2,2})[0]);
        System.out.println(fairCandySwap(new int[]{1,1},new int[]{2,2})[1]);
    }

    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}