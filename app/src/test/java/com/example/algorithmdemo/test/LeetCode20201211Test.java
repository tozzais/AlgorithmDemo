package com.example.algorithmdemo.test;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 柠檬水找零
 */
public class LeetCode20201211Test {

    @Test
    public void test() {

        System.out.println(predictPartyVictory("RDD"));

    }

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";


    }
    private boolean isCanWin(List<Character> list){
        Character character = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != character){
                return false;
            }
        }
        return true;
    }

    private String getWin(Character c1){
        if (c1 == 'D'){
            return "Dire";
        }else if (c1 == 'R'){
            return "Radiant";
        }
        return "";
    }

}