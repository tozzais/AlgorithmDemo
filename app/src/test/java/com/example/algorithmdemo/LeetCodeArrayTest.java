package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 测试数组
 *
 * https://leetcode-cn.com/tag/array/
 */
public class LeetCodeArrayTest {
    @Test
    public void test() {
        int[][]  a = new int[][]{{},{},{},{}};

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


}