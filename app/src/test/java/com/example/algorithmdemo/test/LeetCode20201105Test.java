package com.example.algorithmdemo.test;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 127. 单词接龙
 *
 *https://leetcode-cn.com/problems/word-ladder/
 */
public class LeetCode20201105Test {
    @Test
    public void test() {
        int[] a = new int[]{0,3,2,1};
        String [] news = new String[]{"hot","dot","dog"};
        List<String> list = new ArrayList<>();
        for (String s:news){
            list.add(s);
        }
        System.out.println(ladderLength("hot","dot", list));


    }
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    /**
     * 官方解答
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;

    }
    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }

    /**
     * 自己的解法
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        //存着每次遍历后的下一个数据和对应深度
        Map<String,Integer> map = new HashMap<>();
        map.put(beginWord,1);
        int deep = 1;
        //是否可以添加
        boolean isCanAdd = true;
        while (wordList.size()>0 && isCanAdd){
            isCanAdd = false;
            //下一次边界的 集合
            List<String> map1 = getMap(wordList, map);
            if (map1.size()>0){
                isCanAdd = true;
                for (String s:map1){
                    map.put(s,deep+1);
                    if (s.equals(endWord)){
                        return deep+1;
                    }
                }

            }
            deep++;

            wordList = remove(wordList,map);
            map = getEdge(map,deep);
        }
        return map.get(endWord) == null?0:map.get(endWord);


    }
    //得到边界
    public Map<String,Integer> getEdge( Map<String,Integer> map,int deep){
        Map<String,Integer> map1 = new HashMap<>();
            for (String s1:map.keySet()){
                if (map.get(s1) == deep){
                    map1.put(s1,deep);
                }
            }
            return map1;
    }
    //判断当前字符串是否是边界下一个
    public boolean isContain(String s, Map<String,Integer>  edge){
        //一次遍历
        for (String s1:edge.keySet()){
            int equalNumber = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i)){
                    equalNumber++;
                }
            }
            if (equalNumber == 1){
                return true;
            }
        }
        return false;
    }
    //去除wordlist 里有key的字符串
    public List<String> remove(List<String> wordList, Map<String,Integer> map){
        List<String> list = new ArrayList<>();
        for (String s:wordList){
            boolean isContain = false;
            for (String s1:map.keySet()){
                if (s1.equals(s)){
                    //有的情况
                    isContain = true;
                }
            }
            if (!isContain){
                //遍历完都不包含
                list.add(s);
            }
        }
        return list;
    }

    //得到边界的集合
    public List<String> getMap(List<String> wordList, Map<String,Integer> map){
        List<String> list = new ArrayList<>();
        for (String s:wordList){
            if (isContain(s,map)){
                list.add(s);
            }
        }
        return list;
    }



}