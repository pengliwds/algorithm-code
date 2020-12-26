package com.pengli.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author li.peng
 * @date 2020/11/27
 */
public class MergeSort {

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
        // 先一分二，二分四的转换为小规模两两排序
        fork(a, 0, length - 1);

    }

    /**
     * 递归方法
     *
     * @param a     数据源
     * @param start
     * @param end
     */
    private static void fork(int[] a, int start, int end) {

        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;

        fork(a, start, middle);
        fork(a, middle + 1, end);

        // 将分开的一个一个合并起来
        merge(a, start, end, middle);
    }

    /**
     * 递归到start==end 后return出来，然后将"两个return出来的数组"合并
     *
     * @param a      数据源
     * @param start
     * @param end
     * @param middle 这里上面计算过了，这里就不算了，传过来
     */
    private static void merge(int[] a, int start, int end, int middle) {
        int mergeArrayLength = end - start + 1;
        int[] b = new int[mergeArrayLength];
        int fork1i = start;
        int fork2i = middle + 1;
        for (int i = 0; i < mergeArrayLength; i++) {
            // 如果一个数组加到末尾了，后面的就一直加另外一个数组的数据
            if (fork1i == middle + 1) {
                b[i] = a[fork2i];
                fork2i++;
                continue;
            }
            if (fork2i == end + 1) {
                b[i] = a[fork1i];
                fork1i++;
                continue;
            }
            // 升序，谁小加谁，下标后移
            if (a[fork1i] < a[fork2i]) {
                b[i] = a[fork1i];
                fork1i++;
            } else {
                b[i] = a[fork2i];
                fork2i++;
            }
        }
        // 将b复制到a中
        int j = 0;
        for (int i = start; i <= end; i++) {
            a[i] = b[j++];
        }

    }

    public static void main(String[] args) {
        int[] a = {9, 3, 4, 6, 5, 1, 0};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
