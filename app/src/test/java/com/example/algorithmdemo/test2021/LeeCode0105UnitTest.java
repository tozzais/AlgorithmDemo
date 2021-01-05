package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 830. 较大分组的位置
 */
public class LeeCode0105UnitTest {
    @Test
    public void test() {
        largeGroupPositions("abbxxxxzzy");

    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        int i = 0;
        int j = 0;
        int length = s.length();
        while (j<length){
            char charAt = s.charAt(i);
            char charAt1 = s.charAt(j);
            if (charAt == charAt1){
                if (j-i>=2 && (j == length-1 || s.charAt(j+1) != charAt)){
                    lists.add(Arrays.asList(i,j));
                    j++;
                    i=j;
                }else {
                    j++;
                }
            }else {
                i=j;
            }
        }
        return  lists;
    }



}