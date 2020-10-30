package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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


}