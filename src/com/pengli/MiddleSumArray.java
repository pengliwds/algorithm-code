package com.pengli;

import java.util.Arrays;

public class MiddleSumArray {


    public static void main(String[] args) {
        System.out.println(getMiddleSumPoint(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }

    /**
     * 找出数组的中间点，并返回下标，如果没有返回-1
     * 中间点指左边的值之和等于右边值之和
     *
     * @param ints
     * @return
     */
    private static int getMiddleSumPoint(int[] ints) {
        int totol = 0;
        int sum = Arrays.stream(ints).sum();
        for (int i = 0; i < ints.length; i++) {
            totol += ints[i];

            if (totol == sum) {
                return i;
            }
            sum = sum - ints[i];

        }

        return -1;
    }
}
