package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 830. 较大分组的位置
 */
public class LeeCode0107UnitTest {
    @Test
    public void test() {
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }



    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }


}