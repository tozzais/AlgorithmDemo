package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class LeetCode20201104Test {
    @Test
    public void test() {
        int[] a = new int[]{0,3,2,1};
        String [] news = new String[1];
        System.out.println(news[0]);


    }

    /**
     * 官方解答 （困难）
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;





    }




}