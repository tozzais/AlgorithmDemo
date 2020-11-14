package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1122. 数组的相对排序
 */
public class LeetCode20201114Test {

    @Test
    public void test(){
        int[] a = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] b = new int[]{2,1,4,3,9,6};
        int[] c = relativeSortArray1(a,b);
        for (Integer i :
                c) {
            System.out.println(i+"");
        }

    }

    /**
     * 第一种接 一次算出arr2数据 在对剩下的数据进行排序
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] A = new int[arr1.length];
        int size = 0;
        //arr2中没有的数据
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int i1 = arr1[i];
            boolean isHave = false;
            for (int j = 0; j < arr2.length; j++) {
                if (i1 == arr2[j]){
                    isHave = true;
                    break;
                }
            }
            if (!isHave) list.add(i1);
        }
        for (int i = 0; i < arr2.length; i++) {
            int i1 = arr2[i];
            int number = getNumber(arr1, i1);
            for (int j = 0; j < number; j++) {
                A[size] = i1;
                size++;
            }
        }
        Collections.sort(list);
        for (int i = size; i < arr1.length; i++) {
            A[i] = list.get(i-size);
        }
        return A;
    }

    private int getNumber(int[] arr1,int number){
        int a = 0;
        for (int i = 0; i <arr1.length; i++) {
            if (number == arr1[i]){
                a++;
            }
        }
        return a;
    }


    /**
     * 遍历arr2 递减arr1.最后排序ar1 在相加
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] A = new int[arr1.length];
        int position = 0;

        for (int i = 0; i < arr2.length; i++) {
            int i1 = arr2[i];
            for (int j = 0; j < arr1.length; j++) {
                int i2 = arr1[j];
                if (i1 == i2){
                    A[position] = i2;
                    position++;
                    arr1 = remove(arr1,j);
                    j--;
                }
            }
        }
        Arrays.sort(arr1);
        for (int i = position; i < A.length; i++) {
            A[i] = arr1[i-position];
        }
        return A;
    }
    private int[] remove(int[] arr1,int position){
        int[] ints = new int[arr1.length - 1];
        for (int i = 0; i < arr1.length-1; i++) {
            if (i>=position){
                ints[i] = arr1[i+1];
            }else {
                ints[i] = arr1[i];
            }
        }
        return ints;
    }

        public int[] relativeSortArray2(int[] arr1, int[] arr2) {
            int upper = 0;
            for (int x : arr1) {
                upper = Math.max(upper, x);
            }
            int[] frequency = new int[upper + 1];
            for (int x : arr1) {
                ++frequency[x];
            }
            int[] ans = new int[arr1.length];
            int index = 0;
            for (int x : arr2) {
                for (int i = 0; i < frequency[x]; ++i) {
                    ans[index++] = x;
                }
                frequency[x] = 0;
            }
            for (int x = 0; x <= upper; ++x) {
                for (int i = 0; i < frequency[x]; ++i) {
                    ans[index++] = x;
                }
            }
            return ans;
        }





}