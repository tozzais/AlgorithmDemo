package com.example.algorithmdemo.test2021;

import org.junit.Test;


/**
 * 665. 非递减数列
 */
public class LeeCode0222UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(a));
    }


    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < width + height - 1; i++) {
            boolean is = i < height;
            int m = is ? height - i - 1 : 0;
            int n = is ? 0 : i - height + 1;
            int matrix1 = matrix[m][n];
            m++;
            n++;
            while (m < height && n < width) {
                int matrix2 = matrix[m][n];
                if (matrix1 != matrix2){
                    return false;
                }
                m++;
                n++;
            }
        }
        return true;
    }
}