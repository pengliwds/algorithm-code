package com.pengli.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author pengli
 * @Date 2022/7/9
 * @Version 1.0
 */
public class RevertList {

    public static void main(String[] args) {

        RevertList revertList = new RevertList();
        revertList.test();

    }

    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        print(node1);

        ListNode newNode = reverseBetweenTwo(node1, 1, 5);
        System.out.println();

        print(newNode);
    }

    public void print(ListNode node) {
        System.out.print("{");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(",");
            }
            node = node.next;
        }
        System.out.print("}");
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {

        Deque<ListNode> stack = new LinkedList<>();

        ListNode begin = head;

        int middle = left + (right - left) / 2;


        int i = 1;
        while (begin != null) {

            if (i >= left && i <= middle) {
                stack.push(begin);
                if (i == middle && ((right - left) % 2 == 0)) {
                    stack.pop();
                }
            } else if (i <= right && i > middle) {
                ListNode revert = stack.pop();
                int temp = begin.val;
                begin.val = revert.val;
                revert.val = temp;
            }

            i++;
            begin = begin.next;

        }


        return head;
    }


    public ListNode reverseBetweenTwo(ListNode head, int left, int right) {


        int i = 1;

        ListNode beginNode = head;

        ListNode newNode = null;

        ListNode leftPoint = null;

        ListNode endPoint = new ListNode();

        while (head != null) {

            if (left > 1 && (i == left - 1)) {
                leftPoint = head;
            }

            if (i >= left && i <= right) {

                ListNode node = head.next;
                if (i == left) {
                    head.next = endPoint.next;
                } else {
                    head.next = newNode;
                }

                newNode = head;
                head = node;

                if (i == right && head != null) {
                    endPoint.next = head.next;
                }
            } else {
                head = head.next;
            }

            i++;
        }
        if (leftPoint != null) {
            leftPoint.next = newNode;
        }


        return beginNode;

    }


    public ListNode ReverseList(ListNode head) {

        ListNode newNode = null;
        while (head != null) {
            ListNode node = head.next;

            head.next = newNode;
            newNode = head;

            head = node;
        }

        return newNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
