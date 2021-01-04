package com.example.algorithmdemo.test;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 二叉树的锯齿形层序遍历
 */
public class LeetCode20201222Test {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        zigzagLevelOrder(treeNode);


    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root ==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //是否从左往右
        boolean isOrder = true;
        while (!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                if (isOrder){
                    list1.add(peek.val);
                }else {
                    list1.add(0,peek.val);
                }
                if (peek.left != null){
                    queue.offer(peek.left);
                }
                if (peek.right != null){
                    queue.offer(peek.right);
                }
            }
            isOrder = !isOrder;
            list.add(list1);
        }
        return list;
    }


}