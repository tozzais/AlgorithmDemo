package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class LeetCode20201021Test {
    @Test
    public void test() {
        System.out.println(isLongPressedName("alex","aaleex"));
        System.out.println(isLongPressedName("saeed","ssaaedd"));
        System.out.println(isLongPressedName("leelee","lleeelee"));
        System.out.println(isLongPressedName("laiden","laiden"));
        System.out.println(isLongPressedName("vtkgn","vttkgnn"));
        System.out.println(isLongPressedName("pyplrz","ppyypllr"));

    }

    /**
     * 错误版本1  没有考虑 "vtkgn"  "vttkgnn" typed字符串结尾相等的情况
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName1(String name, String typed) {
        if(name.length()>typed.length()){
            return false;
        }
        int i=0; //name下标
        int j=0; //typed下标
        while (i<name.length() && j<typed.length()){
            char c = name.charAt(i);
            char c1 = typed.charAt(j);
            if (c == c1){
                //相等
                i++;
                j++;
            }else if (i == 0){
                //第一位都不相等 直接返回false
                return false;
            }else {
                //i>0 不相等的话 比较 当前typed下一个字符串和上一个是否相等
                //确定是否是重复输入
                char c2 = typed.charAt(j-1);
                if (c2 == c1){
                    //是重复输入
                    j++;
                }else {
                    return false;
                }
            }
        }
        return (i == name.length() && j == typed.length());
    }

    /** 错误解法2
     * "pyplrz"
     * "ppyypllr"
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName2(String name, String typed) {
        if(name.length()>typed.length()){
            return false;
        }
        int i=0; //name下标
        int j=0; //typed下标
        while (i<name.length() || j<typed.length()){
            char t1 = typed.charAt(j);
            if (i == name.length()){
                //说明name字符串全部匹配完成
                if (t1 == typed.charAt(j-1)){
                    j++;
                    continue;
                }
            }
            char c1 = name.charAt(i);
            if (c1 == t1){
                //相等
                i++;
                j++;
            }else if (i == 0){
                //第一位都不相等 直接返回false
                return false;
            }else {
                //i>0 不相等的话 比较 当前typed下一个字符串和上一个是否相等
                //确定是否是重复输入
                char c2 = typed.charAt(j-1);
                if (c2 == t1){
                    //是重复输入
                    j++;
                }else {
                    return false;
                }
            }
        }
        return (i == name.length() && j == typed.length());
    }

    public boolean isLongPressedName(String name, String typed) {
        if(name.length()>typed.length()){
            return false;
        }
        int i=0; //name下标
        int j=0; //typed下标
        while (i<name.length() && j<typed.length()){
            char t1 = typed.charAt(j);

            char c1 = name.charAt(i);
            if (c1 == t1){
                //相等
                i++;
                j++;
            }else if (i == 0){
                //第一位都不相等 直接返回false
                return false;
            }else {
                //i>0 不相等的话 比较 当前typed下一个字符串和上一个是否相等
                //确定是否是重复输入
                char c2 = typed.charAt(j-1);
                if (c2 == t1){
                    //是重复输入
                    j++;
                }else {
                    return false;
                }
            }
        }
        while (i == name.length() && j<typed.length()){
            if (typed.charAt(j) == typed.charAt(j-1)){
                j++;
            }else {
                return false;
            }
        }
        return (i == name.length() && j == typed.length());
    }

}