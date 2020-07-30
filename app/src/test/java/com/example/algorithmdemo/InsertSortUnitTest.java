package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 插入排序：
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 *
 * 思想及代码实现：https://www.runoob.com/w3cnote/selection-sort.html
 *
 */
public class InsertSortUnitTest {
    @Test
    public void test() {
        /*
        平均时间复杂度:  是O(N^2)
         */
        int[] array = new int[]{9,7,15,3,79,58,48,65,1,59,99,23};
        System.out.println("插入排序前");
        print(array);

        for (int i = 1; i < array.length ; i++) {
            int temp = array[i];
            int j = i;
            for ( ; j > 0 && temp < array[j - 1]; j--) {
                    array[j] = array[j-1];
            }
            if (j != i){
                array[j] = temp;
            }
        }


        System.out.println("插入排序后");
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