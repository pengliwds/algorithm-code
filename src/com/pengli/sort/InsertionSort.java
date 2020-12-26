package com.pengli.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author li.peng
 * @date 2020/11/20
 */
public class InsertionSort {

    /**
     * 升序排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        if (a == null) {
            return;
        }
        int length = a.length;
        for (int i = 1; i < length; i++) {
            // a[i-1]之前是有序的，如果a[i]不比a[i-1]大，插入到合适的a[0]-a[i-1]的位置中
            if (a[i] < a[i - 1]) {
                int tamp = a[i];
                // 将之前有序的数据全部后移一位
                for (int j = i; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = tamp;
                //  将a[0] 放到合适的a[0]-a[i-1]的位置中
                for (int j = 0; j < i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int tamp2 = a[j + 1];
                        a[j + 1] = a[j];
                        a[j] = tamp2;
                    }
                }
            }

        }
    }

    /**
     * 升序排序
     * 优化的排序算法
     *
     * @param a
     */
    public static void prettySort(int[] a) {
        if (a == null) {
            return;
        }
        int length = a.length;

        for (int i = 1; i < length; i++) {
            // 判断 a[i]之前的有序数组，最后一位是否比a[i]大，如果大，则a[i]需要插入，
            // 从后往前依次和前面有序的数组比较，直到遇到小的，停止，将数据插入到小的后面一位。
            int compareValue = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > compareValue) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = compareValue;
        }
    }


    public static void main(String[] args) {
        int[] a = {9, 3, 4, 6, 5, 1, 0};
        prettySort(a);
        System.out.println(Arrays.toString(a));

    }

}
