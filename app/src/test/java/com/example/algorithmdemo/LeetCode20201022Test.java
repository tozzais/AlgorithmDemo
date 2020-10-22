package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 763.字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class LeetCode20201022Test {
    @Test
    public void test() {
        List<Integer> list = partitionLabels1("ababcbacadefegdehijhklij");
        System.out.println(Arrays.toString(list.toArray()));

    }


    /**
     * abc
     * abcc
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i<S.length()){
            //第一个字符
            int j = i+1;
            String s = S.substring(i,j);
            if (i== S.length()-1){
                //最后一项 直接加入
                list.add(s.length());
                break;
            }
            int lastEqualIndex = j;//最后找到相同的位置
            boolean iscontain = false;//是否找到相同的
            while (j<S.length()){
                //遍历后续字符
                char c1 = S.charAt(j);
                String s1 = String.valueOf(new char[] {c1});
                if (s.contains(s1)){
                    //
                    iscontain = true;
                    lastEqualIndex = j;
                    //+1 是说明包含之前的一项
                    s = S.substring(i,j+1);
                }
                if (j==S.length()-1){
                    //最后一项了
                    list.add(s.length());
                    if (iscontain){
                        //有相同的 位置在考后
                        i = lastEqualIndex+1;
                    }else {
                        //没有相同
                        i = lastEqualIndex;
                    }

                }
                j++;
            }
        }
        return list;
    }


    /**
     * 官方解释贪心算法 + 双指针
     * @param S
     * @return
     */
    public List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public boolean isContain(char[] c1,char c2){
        boolean isContain = false;
        for (char c:c1){
            if (c == c2){
                isContain = true;
            }
        }
        return isContain;
    }

}