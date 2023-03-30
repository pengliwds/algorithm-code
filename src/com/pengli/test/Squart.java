package com.pengli.test;

public class Squart {

    public static void main(String[] args) {
        System.out.println(binarySearch(24));

        int a = (int) newTon(24, 24);
        System.out.println(a);
    }

    private static int binarySearch(int i) {
        int index = -1, l = 0, r = i;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid * mid < i) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return index;

    }


    private static double newTon(double res, int x) {
        double mid = (res + x / res) / 2;

        if (mid == res) {
            return mid;
        } else {
            return newTon(mid, x);
        }
    }

}
