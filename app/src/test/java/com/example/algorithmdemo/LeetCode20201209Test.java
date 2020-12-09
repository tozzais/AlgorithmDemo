package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 62. 不同路径
 */
public class LeetCode20201209Test {

    @Test
    public void test() {
        int m = 57;
        int n = 9;
        long l = System.currentTimeMillis();
        System.out.println("第一个答案="+uniquePaths(m,n));
        long l2 = System.currentTimeMillis();
        System.out.println("第一个时间="+(l2-l));
        System.out.println("第二个答案="+uniquePaths1(m,n));
        long l3 = System.currentTimeMillis();
        System.out.println("第二个时间="+(l3-l2));


    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1 ){
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }





}