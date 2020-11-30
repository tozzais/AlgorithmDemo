package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 767. 重构字符串
 */
public class LeetCode20201130Test {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        System.out.println(reorganizeString("vvvlo"));

        // 默认情况，TreeMap按key升序排序
//        Map<String, Integer> map = new TreeMap<String, Integer>();
//        map.put("acb1", 5);
//        map.put("bac1", 3);
//        map.put("bca1", 20);
//        map.put("cab1", 80);
//        map.put("cba1", 1);
//        map.put("abc1", 10);
//        map.put("abc2", 12);
//// 升序比较器
//        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1,
//                               Map.Entry<String, Integer> o2) {
//// TODO Auto-generated method stub
//                return o2.getValue()-o1.getValue();
//            }
//        };
//// map转换成list进行排序
//        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
//// 排序
//        Collections.sort(list,valueComparator);
//// 默认情况下，TreeMap对key进行升序排序
//        System.out.println("------------map按照value升序排序--------------------");
//        for (Map.Entry<String, Integer> entry : list) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }



    }

    /**
     * 767. 重构字符串  放入map 遍历 解不出来
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();


        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int c1 = c;
            Integer orDefault = map.getOrDefault(c1, 0);
            if (orDefault+1>(S.length()+1)/2){
                //长度大于一半 肯定无法排序 S.length()+1 为了计算奇数大于一半可以的情况
                return "";
            }
            map.put(c1,orDefault+1);
        }
        // 降序序比较器
        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,valueComparator);


        StringBuffer stringBuffer = new StringBuffer();
        while (stringBuffer.length() != S.length()){

            for (Map.Entry<Integer, Integer> entry : list) {

                int a = entry.getKey();
                char c = (char)a;
                int number = entry.getValue();
                if (number>0){
                    //有数量 添加 并且减一
                    stringBuffer.append(c);
                    map.put(entry.getKey(),number-1);
                }
            }


        }
        return stringBuffer.toString();

    }

    @Test
    public void reorganizeString1() {
        String S = "aab";
        StringBuffer stringBuffer  = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            String insert = insert(stringBuffer, c);
            if ("".equals(insert)) {
                System.out.println("返回null");
                return;
            }
            stringBuffer = new StringBuffer(insert);
        }
        System.out.println(stringBuffer.toString());
    }

    /**
     * 动态插入 不行。aab 插入到aa 就失败了
     * @param stringBuffer
     * @param c
     * @return
     */
    private String insert(StringBuffer stringBuffer,char c){
        if (stringBuffer.length() == 0)
            return c+"";
        for (int i = 0; i < stringBuffer.length(); i++) {
            char c1 = stringBuffer.charAt(i);
            if (c1 == c) continue;//相等则继续
            if (i == 0 ){
                // 第0位 加入最前面
                stringBuffer.insert(i,c);
                return stringBuffer.toString();
            }else if ( stringBuffer.charAt(i-1) != c){
                //1 到 n-2 位 。和当前值不等 并且和前一位不等 插入到当前值前面
                stringBuffer.insert(i,c);
                return stringBuffer.toString();
            }else if (i == stringBuffer.length()-1 ){
                //最后一项 不等于
                stringBuffer.insert(i+1,c);
                return stringBuffer.toString();
            }
        }
        return "";
    }

}