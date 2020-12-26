package com.pengli.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author li.peng
 * @date 2020/11/19
 */
public class BubbleSort {

    /**
     * 升序排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        if (a == null) {
            return;
        }
        int lenth = a.length;
        for (int i = 0; i < lenth; i++) {
            boolean noSwapFlag = true;
            for (int j = 1; j < lenth - i; j++) {
                if (a[j-1] > a[j]) {
                    swap(a, j-1, j);
                    noSwapFlag = false;
                }
            }
            if (noSwapFlag) {
                break;
            }
        }
    }

    /**
     * 将数组a中下标为i和j的对换
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a, int i, int j) {

        int tamp = a[j];
        a[j] = a[i];
        a[i] = tamp;

    }

    public static void main(String[] args) {
        int[] a = {9, 3, 4, 6, 5, 1, 0};
        sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println((4+5)/2);
    }

}
