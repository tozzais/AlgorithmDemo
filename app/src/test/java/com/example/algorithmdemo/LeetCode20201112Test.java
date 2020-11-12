package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 922. 按奇偶排序数组 II
 *
 *
 */
public class LeetCode20201112Test {
    @Test
    public void test() {
        int[] a = new int[]{4,2,5,7};
        int[] ints = sortArrayByParityII(a);
        for (int i : ints)
        System.out.print(i+" ");
    }
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i % 2 != A[i] % 2){
                //当前数字和下标不一致 替换
                for (int j = i+1; j < A.length; j++) {
                    if (i % 2 == A[j] % 2){
                        int exchange = A[i];
                        A[i] = A[j];
                        A[j] = exchange;
                        break;
                    }
                }
            }
        }
        return A;
    }

    /**
     * 官方解答1 ：循环两便
     * @param A
     * @return
     */
    public int[] sortArrayByParityII1(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int i = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[i] = x;
                i += 2;
            }
        }
        i = 1;
        for (int x : A) {
            if (x % 2 == 1) {
                ans[i] = x;
                i += 2;
            }
        }
        return ans;

    }

    /**
     * 官方解答 2 ：双指针
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}