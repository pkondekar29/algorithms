package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class MaxDistance {

    public static void main(String[] args) {
        PrinterUtils.print(maxIndexDistance(new int[] {1, 10}));
    }

    public static int maxIndexDistance(int[] nums) {
        int maxDiff;
        int i, j;
        int n = nums.length;

        int[] RMax = new int[n];
        int[] LMin = new int[n];

        LMin[0] = nums[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(nums[i], LMin[i - 1]);

        RMax[n - 1] = nums[n - 1];
        for (j = n - 2; j >= 0; j--)
            RMax[j] = Math.max(nums[j], RMax[j + 1]);

        i = 0; j = 0;
        maxDiff = -1;
        while (i < n && j < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }
            else
                i++;
        }
        return maxDiff;
    }

}
