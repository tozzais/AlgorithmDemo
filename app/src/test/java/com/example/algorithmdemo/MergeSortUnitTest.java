package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 归并排序
 */
public class MergeSortUnitTest {
    @Test
    public void test() {
        String num1 = "1234";
        String num2 = "1234234234234234";
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuffer ans = new StringBuffer();
        int add = 0;

        while (i >= 0 || j >= 0 || add != 0) {

            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;

            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;

        }
        ans.reverse();


    }


}