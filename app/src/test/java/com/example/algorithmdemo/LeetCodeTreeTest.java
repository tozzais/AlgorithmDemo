package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 测试 树
 *
 * https://leetcode-cn.com/tag/tree/
 */
public class LeetCodeTreeTest {

    public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    @Test
    public void test() {
        int[][]  a = new int[][]{{},{},{},{}};

    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }if (root.left == null && root.right == null){
            return true;
        }else if (root.left == null){
            return CalculationDeep(root.right)<=1;
        }else if (root.right == null){
            return CalculationDeep(root.left)<=1;
        }else {
            return (Math.abs(CalculationDeep(root.left)-CalculationDeep(root.right))<=1)
                    && isBalanced(root.left) && isBalanced(root.right);
        }

    }

    private int CalculationDeep(TreeNode root){
        if (root.left == null && root.right == null){
            return 1;
        }else if (root.left == null){
            return CalculationDeep(root.right)+1;
        }else if (root.right == null){
            return CalculationDeep(root.left)+1;
        }else {
            return Math.max(CalculationDeep(root.left),CalculationDeep(root.right))+1;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    @Test
    public void test1() {
        int[][]  a = new int[][]{{},{},{},{}};

    }

    /**
     * 589. N叉树的前序遍历
     * @param root
     * @return
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null)
            return list;
        list.add(root.val);
        for (Node node:root.children){
            preorder(node);
        }
        return list;


    }


}