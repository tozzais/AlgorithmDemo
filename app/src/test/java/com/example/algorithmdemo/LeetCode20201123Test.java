package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 452. 用最少数量的箭引爆气球
 *
 */
public class LeetCode20201123Test {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }


  }

  @Test
  public void test(){

      int[][] points =new int[][]{{10,16},{2,8},{1,6},{7,12}};
      System.out.println(findMinArrowShots(points));
  }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;


    }







}