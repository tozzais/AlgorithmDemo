package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class LeetCode20201206Test {

    @Test
    public void test() {



    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (lists.size() == 0){
                list.add(1);
            }else {
                //得到上一行的数据
                List<Integer> list1 = lists.get(i - 1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i){
                        //第一行或者最后一行
                        list.add(1);
                    }else {
                        list.add(list1.get(j)+list1.get(j-1));
                    }
                }
            }
            lists.add(list);
        }
        return lists;

    }


}