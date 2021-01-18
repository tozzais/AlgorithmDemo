package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 1018. 可被 5 整除的二进制前缀
 6235
 */
public class LeeCode0118UnitTest {
    @Test
    public void test() {
        int[][] a = new int[][]{{0,1},{1,3},{-4,-7},{5,11}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]);
        }
    }



    public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
            Map<String, String> emailToName = new HashMap<String, String>();
            int emailsCount = 0;
            for (List<String> account : accounts) {
                String name = account.get(0);
                int size = account.size();
                for (int i = 1; i < size; i++) {
                    String email = account.get(i);
                    if (!emailToIndex.containsKey(email)) {
                        emailToIndex.put(email, emailsCount++);
                        emailToName.put(email, name);
                    }
                }
            }
            UnionFind uf = new UnionFind(emailsCount);
            for (List<String> account : accounts) {
                String firstEmail = account.get(1);
                int firstIndex = emailToIndex.get(firstEmail);
                int size = account.size();
                for (int i = 2; i < size; i++) {
                    String nextEmail = account.get(i);
                    int nextIndex = emailToIndex.get(nextEmail);
                    uf.union(firstIndex, nextIndex);
                }
            }
            Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
            for (String email : emailToIndex.keySet()) {
                int index = uf.find(emailToIndex.get(email));
                List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
                account.add(email);
                indexToEmails.put(index, account);
            }
            List<List<String>> merged = new ArrayList<List<String>>();
            for (List<String> emails : indexToEmails.values()) {
                Collections.sort(emails);
                String name = emailToName.get(emails.get(0));
                List<String> account = new ArrayList<String>();
                account.add(name);
                account.addAll(emails);
                merged.add(account);
            }
            return merged;
        }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }


    }


}