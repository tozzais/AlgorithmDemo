package com.example.algorithmdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试字符串
 *
 * https://leetcode-cn.com/tag/array/
 */
public class LeetCodeStringTest {

    /**
     * 1576. 替换所有的问号
     * @param s
     * @return
     */
    public String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                //前面一个字符  如果当前是第0个的话 字符就为‘ ’
                char ahead = i == 0 ? ' ' : chars[i - 1];
                //后面一个字符  如果当前是最后一个的话 字符就为‘ ’
                char behind  = i == chars.length - 1 ? ' ' : chars[i + 1];
                //从a开始比较  如果等于前面或者后面的话 就+1
                char temp = 'a';
                while (temp == ahead || temp == behind ) {
                    temp++;
                }
                //找到目标字符后 做替换
                chars[i] = temp;
            }
        }
        return new String(chars);



    }
    private char replace(char start,char end){
        for (int i=0;i<=24;i++){
            char i1 = (char) ('a' + i);
            if (i1 != start && i1 != end) return i1;
        }
        return 'a';
    }

    @Test
    public void test() {
        System.out.println(modifyString("j?qg??b"));
        StringBuffer stringBuffer = new StringBuffer("j?qg??b");
        System.out.println(stringBuffer.replace(0,1,"?"));
    }


}