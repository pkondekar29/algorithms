package com.prometheous.coding.dp;

public class TargetSumPlusMinus {

    private static int ways;
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int t = 3;
        System.out.print(findWays(nums, t));
    }

    public static int findWays(int[] nums, int t) {
        int currSum = 0;
        DFS(nums, 0, currSum, t);
        return ways;
    }

    private static void DFS(int[] nums, int h, int currSum, int t) {
        if(h == nums.length) {
            if(currSum == t) {
                ways++;
            }
            return;
        }
        DFS(nums, h + 1, currSum + nums[h], t);
        DFS(nums, h + 1, currSum - nums[h], t);
    }


}
