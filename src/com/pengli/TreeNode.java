package com.pengli;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {


    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, null, null);
        Node node4 = new Node(4, node3, null);
        Node node5 = new Node(5, node2, node1);
        Node node6 = new Node(6, node5, node4);
        Node node7 = new Node(7, null, null);
        Node node8 = new Node(8, node6, node7);


        deepSearch(node8);
        breadthFirstSearch(node8);
    }


    public static void deepSearch(Node node) {

        if (node == null) {
            return;
        }
        deepSearch(node.left);
        deepSearch(node.right);
        System.out.println(node.data);
    }


    public static void breadthFirstSearch(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {

            Node node1 = queue.poll();
            System.out.println(node1.data);
            if (node1.left != null) {
                queue.offer(node1.left);
            }
            if (node1.right != null) {
                queue.offer(node1.right);
            }

        }

    }


    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
