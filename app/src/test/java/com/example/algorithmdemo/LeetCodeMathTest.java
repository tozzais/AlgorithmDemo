package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 测试 数字
 *
 */
public class LeetCodeMathTest {

    @Test
    public void test() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        System.out.println(Integer.parseInt(stringBuffer.charAt(0)+""));
        System.out.println(stringBuffer.codePointAt(0));



        System.out.println(bitwiseComplement(5));

    }
    /**
     * @return
     */
    public int bitwiseComplement(int N) {
        if (N == 0)return 1;
        StringBuffer stringBuffer = new StringBuffer();
        while (N / 2 != 0){
            stringBuffer.append(N%2==0?1:0);
            N = N/2;
        }
        stringBuffer.reverse();
        int number = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            int c = Integer.parseInt(stringBuffer.charAt(i)+"");
            number += Math.pow(2,stringBuffer.length()-i-1)*c;
        }
        return number;

    }






}