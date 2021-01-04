package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode20201022Test
 *
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class LeetCode20201023Test {
    @Test
    public void test() {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1,listNode0);
        ListNode listNode2 = new ListNode(2,listNode1);
        ListNode listNode3 = new ListNode(1,listNode2);
        ListNode listNode4 = new ListNode(0,listNode3);
        System.out.println(isPalindrome(listNode4));

    }


    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode listNode = head;
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i=0,j=list.size()-1;i<j;i++,j--){
            if (!list.get(i).equals(list.get(j))){
                return false;
            }
        }
        return true;

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}