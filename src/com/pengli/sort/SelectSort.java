package com.pengli.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author li.peng
 * @date 2020/11/26
 */
public class SelectSort {

    /**
     * 从小到大排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        if (a == null) {
            return;
        }
        int length = a.length;
        for (int i = 0; i < length; i++) {
            // 从中找出最小的
            int min = a[i];
            int minSubScript = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    // 获取最小值对应的下标
                    minSubScript = j;
                }
            }
            // swap
            int tamp = a[i];
            a[i] = min;
            a[minSubScript] = tamp;
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 4, 6, 5, 1, 0};
        sort(a);
        System.out.println(Arrays.toString(a));

    }

}
