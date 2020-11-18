package com.example.algorithmdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先排序算法
 *
 * https://leetcode-cn.com/tag/array/
 */
public class LeetCodeBFSTest {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



    @Test
    public void test() {
        StringBuffer stringBuffer = new StringBuffer("j?qg??b");
        System.out.println(stringBuffer.replace(0,1,"?"));
    }

    /**
     * 面试题 04.04. 检查平衡性
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root ==null) return true;
        else return isDeepEqual(root) && isBalanced(root.left) && isBalanced(root.right);

    }
    private boolean isDeepEqual(TreeNode node){
        if (node ==null) return true;
        else return Math.abs(getDeep(node.left)-getDeep(node.right))<=1;
    }
    private int getDeep(TreeNode note){
        if (note == null){
            return 0;
        }
        if (note.left == null && note.right == null){
            return 1;
        }
        return Math.max(getDeep(note.left),getDeep(note.right))+1;
    }

    @Test
    public void test1() {
       List<Integer> list = new ArrayList<>();
    }

    //107. 二叉树的层次遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> stack = new ArrayList<>();
        if (root == null) return stack;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size() > 0){
            List<Integer> list1 = new ArrayList<>();
            for (TreeNode treeNode:nodes){
                list1.add(treeNode.val);
            }
            nodes = getNote(nodes);
            stack.add(stack.size(),list1);
        }
        return stack;
    }

    private List<TreeNode> getNote(List<TreeNode> list){
        List<TreeNode> list1 = new ArrayList<>();
        for (TreeNode treeNode:list){
            if (treeNode != null ){
                if (treeNode.left != null) list1.add(treeNode.left);
                if (treeNode.right != null) list1.add(treeNode.right);
            }
        }
        return list1;
    }

}