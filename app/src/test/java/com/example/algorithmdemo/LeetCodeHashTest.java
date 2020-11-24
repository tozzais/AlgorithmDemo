package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试 哈希表
 *
 */
public class LeetCodeHashTest {

    @Test
    public void test() {
        int[] ints = {2, 2, 1,3,3,4,5,5,4};
        System.out.println(singleNumber(ints));


    }

    /**
     * 136. 只出现一次的数字 (官方解答 用位运算更快)
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer integer = map.get(num);
            if (integer == null){
                map.put(num,1);
            }else {
                map.remove(num);
            }
        }
        return map.keySet().iterator().next();

    }







}