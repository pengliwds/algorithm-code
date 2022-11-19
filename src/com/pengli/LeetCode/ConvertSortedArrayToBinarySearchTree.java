package com.pengli.LeetCode;

import com.pengli.Node;

/**
 * @Author pengli
 * @Date 2022/7/8
 * @Version 1.0
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
    }

    public static Node sortedArrayToBST(int[] nums) {

        Node root = dfs(nums, 0, nums.length - 1);
        return root;

    }

    public static Node dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        Node root = new Node(nums[middle]);
        root.left = dfs(nums, start, middle - 1);
        root.right = dfs(nums, middle + 1, end);
        return root;

    }
}
