package com.pengli.list;

public class RevertList {

    /**
     * 定义单链表结构
     */
    static class ListNode {

        public int data;

        public ListNode next;

        public ListNode(int data, ListNode listNode) {
            this.data = data;
            this.next = listNode;
        }

        public static void print(ListNode listNode) {
            while (listNode != null) {
                System.out.println(listNode.data);
                listNode = listNode.next;
            }

        }
    }


    /**
     * 迭代单链表反转
     *
     * @param listNode
     * @return
     */
    public static ListNode revert(ListNode listNode) {

        ListNode prev = null, next;
        ListNode curr = listNode;
        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    /**
     * 递归单链表反转
     *
     * @param listNode
     * @return
     */
    public static ListNode recursion(ListNode listNode) {

        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode pre_node = recursion(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;

        return pre_node;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode.print(node1);
//        System.out.println("递归单链表反转");
//        ListNode revertNode = revert(node1);
//        ListNode.print(revertNode);

        System.out.println("迭代单链表反转");
        ListNode revertNode1 = recursion(node1);
        ListNode.print(revertNode1);

    }

}
