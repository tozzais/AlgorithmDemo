package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.Stack;

/**
 *463. 岛屿的周长
 *
 * https://leetcode-cn.com/problems/island-perimeter/
 */
public class LeetCode20201030Test {
    @Test
    public void test() {
        int[][]  a = new int[][]{{},{},{},{}};

    }
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];

            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt == 1){
                    //左 边界或者前一个不为1
                    if (j == 0 || ints[j-1]!= 1){
                        sum ++;
                    }
                    //上  边界或者上一个不为1
                    if (i == 0 || grid[i-1][j] != 1){
                        sum ++;
                    }
                    //右 边界或者后一个不为1
                    if (j == ints.length-1 || ints[j+1]!= 1){
                        sum ++;
                    }
                    //下 边界或者下一个不为1
                    if (i == grid.length-1 || grid[i+1][j] != 1){
                        sum ++;
                    }

                }
            }
        }
        return sum;

    }

    //构建这个 是 相同下边 做加法之后 得到格子的前后左右
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }



}