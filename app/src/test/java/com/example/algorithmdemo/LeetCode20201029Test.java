package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 129. 求根到叶子节点数字之和
 *
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class LeetCode20201029Test {
    @Test
    public void test() {

    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Stack<TreeNode> nodeQueue = new Stack<>();
        Stack<Integer> numQueue = new Stack<>();
        nodeQueue.push(root);
        numQueue.push(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.pop();
            int num = numQueue.pop();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.push(left);
                    numQueue.push(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.push(right);
                    numQueue.push(num * 10 + right.val);
                }
            }
        }
        return sum;
    }


    /**
     * 深度优先算法
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}