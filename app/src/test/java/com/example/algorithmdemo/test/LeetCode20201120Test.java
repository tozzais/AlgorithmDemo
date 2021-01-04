package com.example.algorithmdemo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 147. 对链表进行插入排序
 *
 */
public class LeetCode20201120Test {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    @Test
    public void test(){
    }

    /**
     * 147. 对链表进行插入排序
     * @return
     */
    public ListNode insertionSortList1(ListNode head) {
        if (head == null) return null;
        List<ListNode> listNodes = new ArrayList<>();
        ListNode  listNode = head;
        while (listNode != null){
            listNodes.add(listNode);
            listNode = head.next;
        }
        for (int i = 0; i < listNodes.size()-1; i++) {
            for (int j = i+1; j < listNodes.size(); j++) {
                ListNode listNode1 = listNodes.get(i);
                ListNode listNode2 = listNodes.get(j);
                if (listNode1.val>listNode2.val){
                    ListNode listNode3 = listNode1;
                    listNode1 = listNode2;
                    listNode2 = listNode3;
                }
            }
        }
        ListNode listNode1 = null;
        for (int i = 0; i < listNodes.size(); i++) {
          if (listNode1 == null){
              listNode1 = listNodes.get(i);
          }else {
              ListNode next = listNode1.next;
              while (next != null){
                  next = next.next;
              }
              next = listNodes.get(i);
          }
        }
        return listNode1;

    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;//重构链表
        ListNode lastNote = head,curr = head.next;
        while (curr != null){
            if (lastNote.val<curr.val){
                lastNote = lastNote.next;
            }else {
                //需要插入的前一个点
                ListNode pre = listNode;
                while (pre.next.val<curr.val){
                    pre = pre.next;
                }
                //去除需要排序的点
                lastNote.next = curr.next;//已经排序好的 连接 需要排序的下一个
                //插入到排序位置，只确定了插入点的next
                curr.next = pre.next;
                //插入点连接 需要插入的下一个位置
                pre.next = curr;
            }
            curr = lastNote.next;
        }
        return listNode.next;


    }








}