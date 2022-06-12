package com.pengli.search;

import java.util.LinkedList;

/**
 * 深度优先算法
 *
 * @Author pengli
 * @Date 2022/6/12
 * @Version 1.0
 */
public class DepthFirstSearch {

    static boolean hasFound = false;


    public static void depthFirstSearch(Graph graph, int start, int search) {

        int v = graph.getV();

        LinkedList<Integer>[] linkedList = graph.getAdj();

        int[] pre = new int[v];

        int[] hasRead = new int[v];

        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }

        recursiveDfs(start, search, pre, hasRead, linkedList);

        print(pre, start, search);
    }


    public static void recursiveDfs(int start, int search, int[] pre, int[] hasRead, LinkedList<Integer>[] linkedList) {
        if (hasFound) {
            return;
        }

        hasRead[start] = 1;

        if (start == search) {
            hasFound = true;
            return;
        }

        LinkedList<Integer> list = linkedList[start];

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            if (hasRead[num] != 1) {
                hasRead[num] = 1;

                pre[num] = start;

                recursiveDfs(num, search, pre, hasRead, linkedList);
            }

        }


    }

    public static void print(int[] pre, int start, int search) {

        if (pre[search] != -1 && start != search) {

            print(pre, start, pre[search]);
        }

        System.out.print(search + "-->");

    }


    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.add(0, 1);
        graph.add(0, 3);
        graph.add(1, 2);
        graph.add(1, 4);
        graph.add(2, 5);
        graph.add(3, 4);
        graph.add(4, 5);
        graph.add(4, 6);
        graph.add(5, 7);
        graph.add(6, 7);

        depthFirstSearch(graph, 0, 0);
    }
}
