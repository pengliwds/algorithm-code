package com.pengli.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author li.peng
 * @date 2020/12/3
 */
public class QuickSort {

    public static void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        // 获取排好序的分区点
        int pivot = getPivot(a, start, end);

        sort(a, start, pivot - 1);
        sort(a, pivot + 1, end);
    }

    public static int getPivot(int[] a, int start, int end) {
        int length = end - start + 1;

        int pivot = a[end];
        int i = start, j = start;
        // i下标用来遍历数组， j用来标记比pivot大的第一个下标，
        // 这样，遍历到最后只要pivot和a[j]互换，就可以实现左边的都比a[j]小，右边的都比a[j]大（升序排序情况下，降序排序正好相反）
        for (; i < start + length; i++) {
            // 升序排序
            if (a[i] < pivot) {
                swap(a, i, j);
                j++;
            }
        }
        swap(a, end, j);
        return j;
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
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
