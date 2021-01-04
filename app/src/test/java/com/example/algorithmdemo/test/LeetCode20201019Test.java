package com.example.algorithmdemo.test;

import org.junit.Test;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class LeetCode20201019Test {
    @Test
    public void test() {
        String S = "abc###abc###";
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }
//
    public boolean backspaceCompare(String S, String T) {
        S = remove(S);
        T = remove(T);
        return S.equals(T);
    }
    public String remove(String S) {
        while (S.contains("#")){
            int index = S.indexOf("#");
            if (index>0){
                S = S.substring(0,index-1)+S.substring(index+1);
            }else {
                S = S.substring(index+1);
            }
        }
        return S;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.println(array[i]);
            else
                System.out.print(array[i] + ",");
        }
    }
}