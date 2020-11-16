package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试 数字
 *
 */
public class LeetCodeMathTest {

    @Test
    public void test() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        System.out.println(Integer.parseInt(stringBuffer.charAt(0)+""));
        System.out.println(stringBuffer.codePointAt(0));
        System.out.println(bitwiseComplement(5));

    }
    /**
     * @return
     */
    public int bitwiseComplement(int N) {
        if (N == 0)return 1;
        StringBuffer stringBuffer = new StringBuffer();
        while (N / 2 != 0){
            stringBuffer.append(N%2==0?1:0);
            N = N/2;
        }
        stringBuffer.reverse();
        int number = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            int c = Integer.parseInt(stringBuffer.charAt(i)+"");
            number += Math.pow(2,stringBuffer.length()-i-1)*c;
        }
        return number;

    }

    @Test
    public void test1() {
        int[] ints = { 2, 3,3};
        System.out.println(minMoves(ints));
        int a = 3;
        int b = 4;
        int c = 5;
        int d = a+=b-c;
        System.out.println(d);

    }
    /**
     * 453. 最小移动次数使数组元素相等
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
//        int i = 0;
//        Arrays.sort(nums);
//        while (nums[0] != nums[nums.length-1]){
//            for (int j = 0; j < nums.length - 1; j++) {
//                nums[j]++;
//            }
//            Arrays.sort(nums);
//            i++;
//        }
//        return i;

        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = (moves + nums[i]) - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;





    }
    //是否全部相等
    public List isEqual(int[] nums){
        List list = new ArrayList();
        boolean isEqual = true;
        int num = nums[0];
        int max = nums[0];//最大

        list.add(false);
        list.add(0);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num){
                isEqual =  false;
                if (nums[i]>max){
                    max = nums[i];
                    list.set(1,i);
                }
            }
        }
        list.set(0,isEqual);
        return list;
    }






}