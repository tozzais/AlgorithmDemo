package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 338. 比特位计数
 */
public class LeeCode0304UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println( maxEnvelopes(a));
    }
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;

    }

    /*
    0  ->  0
    1  ->  1            1
    2  ->  10           1
    3  ->  11           2
    4  ->  100          1
    5  ->  101          2
    6  ->  110          2
    7  ->  111          3
    8  ->  1000         1
    9  ->  1001         2
    10  ->  1010        2
    11  ->  1011        3
    12  ->  1100        2
    13  ->  1101        3
    14  ->  1110        4
    15  ->  1111        4
    16  ->  10000       1
     */
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;

    }

    private int getOne(int num) {
        int count = 0;
        while (num > 0) {
            int i = num % 2;
            if (i == 1) count++;
            num = num / 2;
        }
        return count;
    }

}