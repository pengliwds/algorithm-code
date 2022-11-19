package com.pengli;

/**
 * @Author pengli
 * @Date 2022/7/8
 * @Version 1.0
 */
public class Node {

    int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
