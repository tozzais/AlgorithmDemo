package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 1128. 等价多米诺骨牌对的数量
 */
public class LeeCode0126UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{1,2},{1,2},{1,2},{1,4}};
        System.out.println(numEquivDominoPairs(a));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {

            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;

    }

}