package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *349. 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class LeetCode20201102Test {
    @Test
    public void test() {
        int[] a = new int[]{1,2,3,3,6,7,8};
        int[] b = new int[]{1,2,3,3,6,7,8};
        int[] c = intersection(a,b);
        for (int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }


    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int i1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                int i2 = nums2[j];
                if (i1 == i2){
                    set.add(i1);
                    break;
                }
            }
        }
        int[] a = new int[set.size()];
        int i = 0;
        for (Integer integer:set){
            a[i] = integer;
            i++;
        }
        return a;
    }



}