package com.example.algorithmdemo;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 435. 无重叠区间
 */
public class LeetCode20201231Test {

    @Test
    public void test() {

        int[][] num = new int[][]{{1,6},{3,4},{5,9}};
        System.out.println(eraseOverlapIntervals(num));

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int n = intervals.length;
        //一共多少不重合的集合
        int num = 1;
        //当前最大值
        int max = intervals[1][0];
        for (int i = 1; i < n; i++) {
            if (intervals[i][1]>=max){
                max = intervals[i][0];
                num++;
            }
        }
        return n - num;


    }


}