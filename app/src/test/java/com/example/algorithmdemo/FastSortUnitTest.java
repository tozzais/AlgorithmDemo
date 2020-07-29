package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 快速排序
 * 思想：https://www.sohu.com/a/246785807_684445
 * 代码实现：https://www.jianshu.com/p/305c83268510
 *
 * 
 */
public class FastSortUnitTest {
    @Test
    public void test() {
        /*
        平均时间复杂度: O(NlogN)  极端情况下的 是O(N^2)
        稳定性：不稳定
         */
        int[] array = new int[]{9,7,15,3,79,58,48,65,1,59,99,23};
        System.out.println("排序前");
        print(array);

        sort(array,0,array.length-1);

        System.out.println("排序后");
        print(array);

    }

    public void sort(int[] array,int low1,int high1){
        int low = low1;
        int high = high1;
         int pivot = array[low];
         while (low<high){
             //先比较右边 找到比基准值小的位置
             while (low < high && array[high]>=pivot){
                 high -- ;
             }
             if (low<high){
                 //找到了 替换 并且左指针 右移
                 int temp = array[high];
                 array[high] = array[low];
                 array[low] = temp;
                 low ++;
             }
             //在比较左边  找到比基准值大的位置
             while (low<high && array[low]<=pivot){
                 low ++;
             }
             if (low < high){
                 //找到了 替换 并且右指针 左移
                 int temp = array[high];
                 array[high] = array[low];
                 array[low] = temp;
                 high -- ;
             }
         }
        if (low > low1){
            sort(array,low1,low-1);
        }
        if (high<high1){
            sort(array,low+1,high1);
        }
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