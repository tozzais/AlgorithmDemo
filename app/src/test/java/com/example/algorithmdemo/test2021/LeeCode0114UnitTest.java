package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 1018. 可被 5 整除的二进制前缀
 */
public class LeeCode0114UnitTest {
    @Test
    public void test() {
        int[] a = new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0};
        prefixesDivBy5(a);

    }



    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = ((sum << 1)+A[i])%5;
            list.add(sum==0);
        }
        return list;

    }



}