package com.example.algorithmdemo;

import org.junit.Test;

/**
 * 328. 奇偶链表
 *
 *
 */
public class LeetCode20201113Test {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    @Test
    public void test() {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        oddEvenList(listNode1);


    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode note1 = head; //奇数链表
        ListNode note2 = head.next; //偶数的链表
        ListNode note3 = note2; //移动的指针链表

        while (note3 != null && note3.next != null){
            note1.next = note3.next;
            note1 = note1.next;
            note3.next = note1.next;
            note3 = note3.next;

        }
        note1.next = note2;
        return head;
    }

    /**
     * 官方解答
     * @param head
     * @return
     */
    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node2 = head.next;
        ListNode node1 = head, node3 = node2;
        while (node3 != null && node3.next != null) {
            node1.next = node3.next;
            node1 = node1.next;
            node3.next = node1.next;
            node3 = node3.next;
        }
        node1.next = node2;
        return head;
    }


}