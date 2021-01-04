package com.example.algorithmdemo.test;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 659. 分割数组为连续子序列
 */
public class LeetCode20201204Test {

    @Test
    public void test() {

        isPossible(new int[]{1,2,3,3,4,4,5,5});


    }

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
            }
            if (map.containsKey(x - 1)) {
                //获取并删除队列首元素：remove()和poll()
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                //插入元素：add(E e)和offer(E e)
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            // peek()/element() 获取元素但不删除队列首元素
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;

    }


}