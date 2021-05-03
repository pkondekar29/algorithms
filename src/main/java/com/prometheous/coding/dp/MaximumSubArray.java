package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        PrinterUtils.print(maxSubArray(arr));
        PrinterUtils.print(maxSubArraySpaceOptimised(arr));
    }

    public static int maxSubArraySpaceOptimised(int[] nums) {
        int max = nums[0], maxHere = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxHere = nums[i] + Math.max(maxHere, 0);
            max = Math.max(maxHere, max);
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
