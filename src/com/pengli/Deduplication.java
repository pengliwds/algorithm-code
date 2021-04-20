package com.pengli;

public class Deduplication {

    public static void main(String[] args) {
        System.out.println(removeDuplicate(new int[]{1,2,2,3,3,4,4,5,5}));
    }

    private static int removeDuplicate(int[] ints) {
        int i = 0;
        for (int j = 0; j < ints.length; j++) {
            if(ints[i] != ints[j]){
                i++;
                ints[i] = ints[j];
            }
        }

        return i+1;
    }


}
