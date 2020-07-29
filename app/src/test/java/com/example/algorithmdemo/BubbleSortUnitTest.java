package com.example.algorithmdemo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 冒泡排序
 *
 *
 */
public class BubbleSortUnitTest {
    @Test
    public void test() {
        /*
        时间复杂度: O(N^2)
        空间复杂度: O(1)
        稳定性：稳定
        参考图解：https://www.jianshu.com/p/1458abf81adf
        优化方案：https://www.cnblogs.com/jyroy/p/11248691.html
        //优化1：设置一个标志位，没有交换则跳出 （已实现）
        //优化2：记录最后一次交换的位置，不需要排序的就不用排序了（test1方法实现）

         */
        int[] array = new int[]{9,7,15,3,79,58,48,65,1,59,99,23};
        System.out.println("排序前");
        print(array);
        for (int i = 0; i < array.length-1; i++) {
            boolean isChange = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    isChange = true;
                }
            }
            if (!isChange){
                break;
            }
        }
        System.out.println("排序后");
        print(array);

    }

    @Test
    public void test1() {
        /*
        优化2：记录最后一次交换的位置，不需要排序的就不用排序了
         */
        int[] array = new int[]{9,7,15,3,79,58,48,65,1,59,99,23};
        System.out.println("排序前");
        print(array);

        int len = array.length;

        for (int i = 0; i < array.length-1; i++) {
            boolean isChange = false;
            for (int j = 0; j < len ; j++) {
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    isChange = true;
                    len = j;
                }
            }
            if (!isChange){
                break;
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