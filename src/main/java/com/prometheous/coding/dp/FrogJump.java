package com.prometheous.coding.dp;

import java.util.Arrays;
import java.util.HashMap;

public class FrogJump {

    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross(new int[] {0,2}));
    }

    private int[] dx = new int[] {1,0,-1};

    public boolean canCross(int[] stones) {
        if(stones[1] - stones[0] != 1) return false;

        HashMap<Integer, Integer> set = new HashMap<>();
        for(int i = 0; i < stones.length; i++) {
            set.put(stones[i], i);
        }
        int[][] dp = new int[stones.length][stones.length];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(stones, 1, 1, set, dp);
    }

    private boolean dfs(int[] stones, int idx, int k, HashMap<Integer, Integer> set, int[][] dp) {
        if(idx >= stones.length) return false;
        if(idx == stones.length - 1) return true;
        if(dp[idx][k] != -1) return dp[idx][k] == 1;

        boolean canReach = false;
        for(int i = 0; i < 3 && !canReach; i++) {
            int nk = k + dx[i];
            int nextJump = stones[idx] + nk;
            if(set.getOrDefault(nextJump, -1) > idx) {
                canReach = dfs(stones, set.get(nextJump), nk, set, dp);
            }
        }
        dp[idx][k] = canReach ? 1 : 0;
        return canReach;
    }
}
