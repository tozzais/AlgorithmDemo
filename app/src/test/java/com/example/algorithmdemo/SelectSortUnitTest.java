package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 选择排序
 * 思想及代码实现：https://www.runoob.com/w3cnote/selection-sort.html
 *
 */
public class SelectSortUnitTest {
    @Test
    public void test() {
        /*
        平均时间复杂度:  是O(N^2)
         */
        int[] array = new int[]{9,7,15,3,79,58,48,65,1,59,99,23};
        System.out.println("排序前");
        print(array);

        // i < array.length - 1 是因为最后比较的时候最后两项。
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1 ; j < array.length; j++) {
                if (array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }


        System.out.println("排序后");
        print(array);

    }




    public void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1)
            System.out.println(array[i]);
            else
            System.out.print(array[i]+",");
        }
    }
}