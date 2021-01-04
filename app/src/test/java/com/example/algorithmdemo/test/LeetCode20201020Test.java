package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class LeetCode20201020Test {
    @Test
    public void test() {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        reorderList(listNode1);

    }
    public void reorderList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null){
            listNodes.add(head);
            head = head.next;
        }
        int i = 0,j = listNodes.size()-1;
        while (i<j){
            listNodes.get(i).next = listNodes.get(j);
            i++;
            if (i == j) {
                break;
            }
            listNodes.get(j).next = listNodes.get(i);
            j--;

        }
        listNodes.get(i).next = null;


    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}