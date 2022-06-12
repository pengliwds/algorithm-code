package com.pengli.huawei;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PressurizedBottle {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> num = new ArrayList<>();
        while (scanner.hasNextLine()) {
            int in = scanner.nextInt();
            if (in == 0) {
                break;
            }
            num.add(in);
        }
        scanner.close();
        // 计算num数组 中分别能够喝到多少瓶汽水
        num.forEach(integer -> {
            System.out.println(calculate(integer));
        });

    }

    private static int calculate(int num) {
        if (num <= 1) {
            return 0;
        }
        int zhengshu = num / 3;
        int yushu = Math.floorMod(num, 3);

        if (yushu != 0 && zhengshu + yushu == 2) {
            yushu++;
        }
        return zhengshu + calculate(zhengshu + yushu);
    }


}
