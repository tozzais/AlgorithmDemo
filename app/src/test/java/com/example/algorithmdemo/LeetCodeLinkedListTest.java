package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 链表
 *
 * https://leetcode-cn.com/tag/linked-list/
 */
public class LeetCodeLinkedListTest {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    @Test
    public void test() {
        int[][]  a = new int[][]{{},{},{},{}};

    }

    /**
     * 面试题 02.02. 返回倒数第 k 个节点
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get(list.size()-k).val;
    }


}