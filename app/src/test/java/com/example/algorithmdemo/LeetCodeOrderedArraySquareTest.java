package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 有序数组的平方
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
 */
public class LeetCodeOrderedArraySquareTest {
    @Test
    public void test() {
        int[] B = new int[]{-3, -2};
        sortedSquares(B);

    }

    /**
     * 自己编写的
     * 可以优化 不用 B 和 C  直接根据i 使用A数组即可
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] B;//负数的集合
        int[] C; //整数的集合
        int[] D = new int[A.length]; //排序后的集合
        int i = 0;  //正负数 交接处
        while (i < A.length && A[i] < 0) { //循环查找i
            i++;
        }
        B = new int[i];
        C = new int[A.length - i];
        for (int j = 0; j < A.length; j++) { //分割A集合
            if (j < i) {
                B[j] = A[j];
            } else {
                C[j - i] = A[j];
            }
        }
        int m1 = i - 1;//数组B的标志位
        int n1 = 0;//数组C的标志位
        int d1 = 0; //最终循环的标志位
        while (m1 >= 0 || n1 < C.length) { //当两个数组任意一个数组有数就添加
            //当负数数组和整数数组都有数的时候
            if (m1 >= 0 && n1 < C.length) {
                if (B[m1] * B[m1] > C[n1] * C[n1]) {
                    //负数平方的最小值 大于 整数平方的最小值
                    D[d1] = C[n1] * C[n1];
                    n1++;
                } else {
                    //负数平方的最小值 小于等于 整数平方的最小值
                    D[d1] = B[m1] * B[m1];
                    m1--;
                }
            } else if (m1 >= 0) {
                //只有负数数组有数
                D[d1] = B[m1] * B[m1];
                m1--;
            } else {
                //只有整数数组有数
                D[d1] = C[n1] * C[n1];
                n1++;
            }
            d1++;
        }
        return D;
    }



    class Solution {
        /**
         * 官方的解法
         *
         * @param A
         * @return
         */
        public int[] sortedSquares(int[] A) {
            int n = A.length;
            int negative = -1;
            for (int i = 0; i < n; ++i) {
                if (A[i] < 0) {
                    negative = i;
                } else {
                    break;
                }
            }
            int[] ans = new int[n];
            int index = 0, i = negative, j = negative + 1;
            while (i >= 0 || j < n) {
                if (i < 0) {
                    ans[index] = A[j] * A[j];
                    ++j;
                } else if (j == n) {
                    ans[index] = A[i] * A[i];
                    --i;
                } else if (A[i] * A[i] < A[j] * A[j]) {
                    ans[index] = A[i] * A[i];
                    --i;
                } else {
                    ans[index] = A[j] * A[j];
                    ++j;
                }
                ++index;
            }
            return ans;
        }
    }


    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.println(array[i]);
            else
                System.out.print(array[i] + ",");
        }
    }
}