package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 406. 根据身高重建队列( copy答案)
 * 备注：
 *
 */
public class LeetCode20201116Test {

    @Test
    public void test(){
       int[][] a = new int[][]{};
       //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        //


    }
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);

    }







}