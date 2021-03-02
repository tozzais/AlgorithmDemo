package com.example.algorithmdemo.test2021;

import org.junit.Test;


/**
 * 832. 翻转数组
 */
public class NumMatrix {
    @Test
    public void test() {
        int[][] a = new int[][]{};
        NumMatrix numMatrix = new NumMatrix(a);
        System.out.println(numMatrix.sumRegion(2,1,4,3));


    }


        int[][] sums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m > 0) {
                int n = matrix[0].length;
                sums = new int[m][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        sums[i][j + 1] = sums[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += sums[i][col2 + 1] - sums[i][col1];
            }
            return sum;
        }


}