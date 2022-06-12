package com.pengli.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先算法
 *
 * @Author pengli
 * @Date 2022/6/12
 * @Version 1.0
 */
public class BreadthFirstSearch {


    /**
     * 从图Graph 中 以start为起点，查找 search
     *
     * @param graph
     * @param start
     * @param search
     */
    public static void breadthFirstSearch(Graph graph, int start, int search) {

        Queue<Integer> queue = new LinkedList<>();

        int v = graph.getV();
        LinkedList<Integer>[] adj = graph.getAdj();

        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        int[] hasRead = new int[v];

        queue.offer(start);

        while (queue.size() != 0) {

            int num = queue.peek();

            LinkedList<Integer> linkedList = adj[queue.poll()];

            for (int i = 0; i < linkedList.size(); i++) {

                int index = linkedList.get(i);

                if (hasRead[index] != 1) {
                    queue.offer(index);

                    pre[index] = num;

                    hasRead[index] = 1;

                    if (index == search) {

                        print(pre, start, search);
                        return;
                    }
                }

            }


        }


    }

    public static void print(int[] pre, int start, int end) {

        if (pre[end] != -1 && start != end) {
            print(pre, start, pre[end]);
        }
        System.out.println(end + " ");

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

        breadthFirstSearch(graph, 0, 6);
    }


}


