package com.pengli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * a b c d
 *
 * @Author pengli
 * @Date 2022/6/14
 * @Version 1.0
 */
public class PermutationCombination {


    /**
     * 全排列
     *
     * @param input
     * @param output
     * @param choose
     * @param cur
     */
    public static void permutation(List<String> input, List<String> output, int choose, int cur) {
        if (cur == choose) {
            System.out.println(output);
        } else {
            for (int i = 0; i < input.size(); i++) {
                if (!output.contains(input.get(i))) {
                    output.add(input.get(i));
                    permutation(input, output, choose, cur + 1);
                    output.remove(input.get(i));
                }
            }
        }

    }

    /**
     * 组合
     *
     * @param input
     * @param output
     * @param choose
     * @param cur
     * @param get
     */
    public static void combination(List<String> input, List<String> output, int choose, int cur, int get) {
        if (cur == choose) {
            System.out.println(output);
        } else {
            for (int i = get; i < input.size(); i++) {
                if (!output.contains(input.get(i))) {
                    output.add(input.get(i));
                    combination(input, output, choose, cur + 1, i + 1);
                    output.remove(input.get(i));
                }

            }

        }
    }


    public static void main(String[] args) {

        List<String> input = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<String> output = new ArrayList<>();

        permutation(input, output, 4, 0);
        System.out.println("======================");
        combination(input, output, 2, 0, 0);


    }
}
