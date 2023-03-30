package com.pengli.test;

import java.util.*;

public class Zigzag {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(60);
        TreeNode treeNode7 = new TreeNode(70);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        ArrayList<ArrayList<Integer>> zig =  zigzagLevelOrder(treeNode);

        System.out.println(zig);
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> zigzagList = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        boolean forword = false;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            Stack<TreeNode> stackOut = stack1.isEmpty() ? stack2 : stack1;
            Stack<TreeNode> stackIn = stack1.isEmpty() ? stack1 : stack2;

            ArrayList<Integer> num = new ArrayList<>();

            while (!stackOut.isEmpty()) {
                TreeNode node = stackOut.pop();
                num.add(node.val);
                if (forword) {
                    if (node.right != null) {
                        stackIn.push(node.right);
                    }
                    if (node.left != null) {
                        stackIn.push(node.left);
                    }
                } else {
                    if (node.left != null) {
                        stackIn.push(node.left);
                    }
                    if (node.right != null) {
                        stackIn.push(node.right);
                    }
                }
            }

            forword = !forword;
            zigzagList.add(num);
        }
        return zigzagList;
    }


    static class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
