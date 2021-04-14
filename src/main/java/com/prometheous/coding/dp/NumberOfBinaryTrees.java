package com.prometheous.coding.dp;

public class NumberOfBinaryTrees {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(findNumberOfBinaryTrees(n));
    }

    private static int findNumberOfBinaryTrees(int n) {
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;

        // Idea is to find number of trees for each number as root.
        // Also, with each number as root, we can find the left & right subtrees by partitioning numbers which can be memoized
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {       // Partition the remaining numbers 1 by 1
                a[i] += a[i - j] * a[j - 1];        // We are adding the number of trees for each partition.
            }
        }
        return a[n];
    }

}
