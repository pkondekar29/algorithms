package com.prometheous.coding.array;

public class RemoveDupsInSortedArry {

    public static void main(String[] args) {
        int[] arr = new int[] {};
        System.out.println(solve(arr));
    }

    public static int solve(int[] a) {
        int i = 0, j = -1;
        while(i < a.length) {
            a[++j] = a[i++];

            while(i < a.length && a[i] == a[i - 1]) i++;
        }
        return j + 1;
    }

}
