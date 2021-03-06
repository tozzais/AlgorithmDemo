package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 1018. 可被 5 整除的二进制前缀
 */
public class LeeCode0117UnitTest {
    @Test
    public void test() {
        double money = 12000;
        System.out.println("第1年余额=:"+money);
        for (int i = 2; i <= 30 ; i++) {
            money = money*1.045+12000;
            System.out.println("第"+i+"年余额="+money);
        }
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