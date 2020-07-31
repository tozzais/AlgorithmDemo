package com.example.algorithmdemo;

import org.junit.Test;

import java.util.Arrays;

/**
 * 希尔排序 是对插入排序的改进
 * 思想及代码实现：https://www.runoob.com/w3cnote/selection-sort.html
 *
 */
public class HillSortUnitTest {
    @Test
    public void test() {
        /*
        平均时间复杂度:  是O(N^2)
         */
        int[] array = new int[]{9,7,15,3,79,58,48,65,1,59,99,23};
        System.out.println("排序前");
        print(array);

        int[] array1 = sort(array);


        System.out.println("排序后");
        print(array);

    }

    public int[] sort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }



        return arr;
    }




    public void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1)
            System.out.println(array[i]);
            else
            System.out.print(array[i]+",");
        }
    }

    public int findMagicIndex(int[] nums) {
        int index = -1;
        for(int i = 0;i<nums.length;i++){
            if( i == nums[i]){
                index = i;
                break;
            }
        }
        return index;

    }
}