package com.example.algorithmdemo;


import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 330. 按要求补齐数组
 */
public class LeetCode20201230Test {

    @Test
    public void test() {

        int[] num = new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeight(num));

    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();

    }


}