package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 *
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class LeetCode20201028Test {
    @Test
    public void test() {
        int[] array = new int[]{1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(array));
    }

    /**
     * 官方解答
     * @param
     * @return
     */
    public boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }

    /**
     * 提示
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        //数字的集合
        List<Integer> list1 = new ArrayList<>();
        //数字次数的集合
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int num1 = arr[i];
            int position = isContain(list1, num1);
            if (position == -1){
                //如果不包含
                list1.add(num1);
                list2.add(1);
            }else {
                //包含的话 把对应的数量加1
                Integer integer = list2.get(position);
                list2.set(position,integer+1);
            }
        }
        //是否重复
        boolean unique = true;
        for (int i = 0; i < list2.size()-1; i++) {
            Integer num1 = list2.get(i);
            for (int j = i+1; j < list2.size(); j++) {
                Integer num2 = list2.get(j);
                if (num1.equals(num2)){
                    unique = false;
                    break;
                }
            }
            if (!unique){
                break;
            }
        }
        return unique;
    }

    //集合是否包含某个数
    public int isContain(List<Integer> list,int i){
        int isContain = -1;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == i){
                isContain = j;
                break;
            }
        }
        return isContain;
    }


}