package com.prometheous.coding.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        int a[] = {2,3,1,1,4};
        System.out.println(canJump(a));
    }

    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;

        for(int i = 0; i < nums.length; i++) {
            if(dp[i] == true) {
                for(int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                    dp[j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static boolean canJumpEff(int[] nums) {
        int maxIndex = nums.length-1;
        int maxJump  = nums[0];
        for(int i = 0; i <= maxJump; i++){
            maxJump=Math.max(maxJump,i+nums[i]);
            if(maxJump>=maxIndex) return true;
        }
        return false;
    }

    public static boolean canJumpRec(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        Arrays.fill(canJump, false);
        canJump[0] = true;
        jump(nums, 0, canJump);
        return canJump[nums.length - 1];
    }

    private static void jump(int[] nums, int i, boolean[] canJump) {
        if(i > nums.length) return;
        if(i == nums.length) {
            canJump[i - 1] = true;      // We can jump to last position
            return;
        }

        for(int k = i + 1; k <= i + nums[i] && k < nums.length - 1; k++) {
            jump(nums, k + 1, canJump);
            canJump[k + 1] = true;
        }
    }

}
