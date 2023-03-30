package com.pengli.test;

public class Sushu {

    public static int countSushu(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;

    }

    private static boolean isPrime(int x) {

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int eratosthens(int x) {
        int count = 0;

        boolean[] isPrime = new boolean[x];

        for (int i = 2; i < x; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < x; j += i) {
                    isPrime[j] = true;
                }

            }
        }
        return count;
    }


    public static void main(String[] args) {
        int count = Sushu.eratosthens(100);
        int count2 = Sushu.countSushu(100);
        System.out.println(count);
        System.out.println(count2);
    }
}
