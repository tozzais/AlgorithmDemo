package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 738. 单调递增的数字
 */
public class LeetCode20201215Test {

    @Test
    public void test() {
        char c = "123".charAt(1);

        System.out.println(monotoneIncreasingDigits(677440));


    }


    /**
     * 738. 单调递增的数字
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        String s = N+"";
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        boolean isTerm = false;//是否可以终止
        for (int i = 0; i < chars.length; i++) {
            if (isTerm){
                //之前已经有数字减1了
                stringBuffer.append(9);
                continue;
            }
            //获得第i个字符
            char aChar = chars[i];
            //是否全部大于
            boolean isAllMore = true;
            for (int j = i+1; j < chars.length; j++) {
                //如果当j为小于i位。并且 j-1不可以借位
                if (chars[j]<aChar ){
                    boolean isExcuse = false;
                    //判断是否可以借位
                    for (int k = i+1; k <= j-1; k++) {
                        if (chars[k]>aChar){
                            isExcuse = true;
                            break;
                        }
                    }
                    if (!isExcuse){
                        isTerm = true;
                        isAllMore = false;
                        stringBuffer.append(Integer.parseInt(aChar+"")-1);
                        break;
                    }

                }
            }
            if (isAllMore){
                stringBuffer.append(Integer.parseInt(aChar+""));
            }
        }
        return Integer.parseInt(stringBuffer.toString());




    }



}