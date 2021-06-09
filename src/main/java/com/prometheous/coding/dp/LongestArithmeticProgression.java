package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticProgression {

    public static void main(String[] args) {
        PrinterUtils.print(new LongestArithmeticProgression()
                .findLongestArithmeticProgressionSubsequence(new int[]{9, 4, 7, 2, 10}));

        PrinterUtils.print(new LongestArithmeticProgression()
                .findLongestArithmeticProgressionSubsequenceDp(new int[]{9, 4, 7, 2, 10}));
    }

    public int findLongestArithmeticProgressionSubsequenceDp(int[] A) {
        int longest = 0;
        // The DP is for each diff and max length for this AP
        /*
            0th -> diff of 2: length of 2, diff of 3: length of 1
            1st ->
            .
            .
            .
         */
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for(int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
        }
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                int a = A[i], b = A[j];
                int diff = a - b;

                // If there is any AP found for j with diff, then add 1 to existing DP
                int len = dp[j].containsKey(diff) ? dp[j].get(diff) + 1 : 2;
                // Also, add this length for this diff for element i
                if(!dp[i].containsKey(diff)) dp[i].put(diff, len);

                longest = Math.max(longest, len);
            }
        }
        return longest;
    }

    public int findLongestArithmeticProgressionSubsequence(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, dfs(nums, i, -1, nums[j] - nums[i]));
            }
        }
        return max;
    }

    private int dfs(int[] nums, int currI, int prevI, int diff) {
        if(prevI != -1 && nums[currI] - nums[prevI] != diff)
                return 0;

        int max = 1;    // Include the current number in progression
        for(int k = currI + 1; k < nums.length; k++) {
            max = Math.max(dfs(nums, k, currI, diff) + 1, max);
        }
        return max;
    }

}
