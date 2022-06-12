package com.pengli.search;

import java.util.LinkedList;

/**
 * 邻接法表示图
 * 这里 0-v 既表示节点下标也表示节点对应的值
 * 如果想分开，LinkedList<Integer>[] 泛型Integer改为定义的Node即可
 *
 * @Author pengli
 * @Date 2022/6/12
 * @Version 1.0
 */
public class Graph {

    // 顶点个数
    private int v;

    private LinkedList<Integer>[] adj;

    public int getV() {
        return v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }


    public Graph(int v) {

        this.v = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {

            adj[i] = new LinkedList<>();
        }

    }

    public void add(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);

    }
}
