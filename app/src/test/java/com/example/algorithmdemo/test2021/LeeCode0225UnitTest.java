package com.example.algorithmdemo.test2021;

import org.junit.Test;


/**
 * 832. 翻转数组
 */
public class LeeCode0225UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{1,1,0},{1,0,1},{0,0,0}};

    }

    /**
     * 空间换时间
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] newArray = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newArray[i][j] = matrix[j][i];
            }
        }
        return newArray;

    }


    private int[] revert(int[] a){
        int length = a.length;
        int[] aNew = new int[length];
        for (int i = length-1; i >=0 ; i--) {
            aNew[length - i - 1] = a[i] == 0?1:0;
        }
        return aNew;
    }
}