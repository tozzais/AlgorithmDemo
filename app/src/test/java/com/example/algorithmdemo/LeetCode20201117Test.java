package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 1030. 距离顺序排列矩阵单元格
 * 备注：
 *
 */
public class LeetCode20201117Test {

    @Test
    public void test(){
        int[][] a = allCellsDistOrder(1,2,0,0);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 解法错误 要包括  原点
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] array = new int[R*C][2];
        int[] ints = {r0, c0};
        array[0] = ints;
        int position = 0;//0 x加 1 y加 2 xy加
        for (int i = 1; i < R*C  ; i++) {
            if (position %3 == 0){
                r0++;
            }else if (position %3 == 1){
                c0++;
            }else if (position %3 == 2){
                r0++;
                c0++;
            }
            int[] a = {r0, c0};
            array[i] = a;
            position++;
        }

        return array;



    }

    /**
     * R行C列
     * R = 2, C = 3, r0 = 1, c0 = 2
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder1(int R, int C,final int r0,final int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
            }
        });
        return ret;



    }







}