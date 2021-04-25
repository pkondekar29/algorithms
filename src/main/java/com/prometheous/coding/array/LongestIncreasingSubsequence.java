package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
//        PrinterUtils.print(findLIS(new int[]{10,9,2,5,3,7,101,18}));
        PrinterUtils.print(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    private static int findLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        return 0;
    }

    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

}
