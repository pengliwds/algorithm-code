package com.pengli.search;

/**
 * 二分查找
 *
 * @Author pengli
 * @Date 2022/6/12
 * @Version 1.0
 */
public class BinarySearch {

    /**
     * 使用循环实现二分查找
     *
     * @param a
     * @return 等于num 的数组a下标
     */
    public static int binarySearchWhile(int[] a, int num) {

        int end = a.length - 1;
        int begin = 0;


        while (begin <= end) {

            int middle = (end + begin) / 2;

            if (a[middle] > num) {
                end = middle - 1;
            } else if (a[middle] < num) {
                begin = middle + 1;
            } else {
                return middle;
            }
        }


        return -1;
    }

    /**
     * 使用递归实现二分查找
     *
     * @param a     查找数据
     * @param begin 开始的下标
     * @param end   结束的下标
     * @param num   要找的数值
     * @return 找到数组中对应的下标
     */
    public static int binarySearchRecursive(int[] a, int begin, int end, int num) {

        int pivot = -1;

        if (begin > end) {
            return pivot;
        }

        int middle = (begin + end) / 2;

        if (a[middle] > num) {
            pivot = binarySearchRecursive(a, begin, middle - 1, num);
        } else if (a[middle] < num) {
            pivot = binarySearchRecursive(a, middle + 1, end, num);
        } else {
            pivot = middle;
        }

        return pivot;
    }


    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int pivot = binarySearchWhile(a, 60);

        int pivotRecursive = binarySearchRecursive(a, 0, a.length - 1, 66);

        System.out.println(pivot);
        System.out.println(pivotRecursive);
    }


}
