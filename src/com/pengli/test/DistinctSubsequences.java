package com.pengli.test;

/**
 * @Author pengli
 * @Date 2022/7/10
 * @Version 1.0
 */
public class DistinctSubsequences {


    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int result = distinctSubsequences.numDistinct(s, t);
        System.out.println(result);
    }

    public int numDistinct(String s, String t) {

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int lengths = chars.length;
        int lengtht = chart.length;

        if (lengths < lengtht) {
            return 0;
        }

        int[][] dp = new int[lengths + 1][lengtht + 1];

        for (int i = 0; i <= lengths; i++) {
            dp[i][lengtht] = 1;

        }

        for (int i = lengths - 1; i >= 0; i--) {

            char schar = chars[i];
            for (int j = lengtht - 1; j >= 0; j--) {

                char tchar = chart[j];
                if (schar == tchar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }


            }

        }

        return dp[0][0];

    }


}
