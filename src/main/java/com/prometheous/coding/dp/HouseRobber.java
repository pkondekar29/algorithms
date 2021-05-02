package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,2};
        PrinterUtils.print(robII(nums));
    }

    // The houses are aligned in circle
    public static int robII(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        Integer[] memo1 = new Integer[nums.length];
        Integer[] memo2 = new Integer[nums.length];
        return Math.max(Math.max(dfsLeft(nums, 0, true, memo1), dfsLeft(nums, 1, false, memo1)),
                Math.max(dfsRight(nums, nums.length - 1, true, memo2), dfsRight(nums, nums.length - 2, false, memo2)));
    }

    private static int dfsLeft(int[] nums, int i, boolean startedFrom1stHouse, Integer[] memo) {
        if(i >= nums.length) return 0;
        if(i == nums.length - 1) {
            if(startedFrom1stHouse) return 0;
            else return nums[nums.length - 1];
        }
        if(memo[i] != null) return memo[i];
        int robbed = nums[i] + Math.max(dfsLeft(nums, i + 2, startedFrom1stHouse, memo), dfsLeft(nums, i + 3, startedFrom1stHouse, memo));
        memo[i] = robbed;
        return robbed;
    }

    private static int dfsRight(int[] nums, int i, boolean startedFrom1stHouse, Integer[] memo) {
        if(i < 0) return 0;
        if(i == 0) {
            if(startedFrom1stHouse) return 0;
            else return nums[0];
        }
        if(memo[i] != null) return memo[i];
        int robbed = nums[i] + Math.max(dfsRight(nums, i - 2, startedFrom1stHouse, memo), dfsRight(nums, i - 3, startedFrom1stHouse, memo));
        memo[i] = robbed;
        return robbed;
    }

    // Houses are on a street
    public static int robI(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        Integer[] memo = new Integer[nums.length];
        return Math.max(dfs(nums, 0, memo), dfs(nums, 1, memo));
    }

    private static int dfs(int[] nums, int k, Integer[] memo) {
        if(k >= nums.length) return 0;
        if(memo[k] != null) return memo[k];
        memo[k] = nums[k] + Math.max(dfs(nums, k + 2, memo), dfs(nums, k + 3, memo));
        return memo[k];
    }

}
