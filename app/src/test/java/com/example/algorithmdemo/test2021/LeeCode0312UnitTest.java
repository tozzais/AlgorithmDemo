package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 验证二叉树的前序序列化
 */
public class LeeCode0312UnitTest {
    @Test
    public void test() {
        System.out.println(isValidSerialization("9,#,1,#,#"));
    }

    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }









}