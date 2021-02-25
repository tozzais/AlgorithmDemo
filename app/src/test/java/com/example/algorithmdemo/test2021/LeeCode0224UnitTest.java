package com.example.algorithmdemo.test2021;

import org.junit.Test;


/**
 * 832. 翻转图像
 */
public class LeeCode0224UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int[][] ints = flipAndInvertImage(a);
        for (int[] b : ints) {
            for (int c : b) {
                System.out.print(c+",");
            }
            System.out.println();
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length;
        int[][] B = new int[length][];
        for (int i = 0; i < length; i++) {
            B[i] = revert(A[i]);
        }
        return B;

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