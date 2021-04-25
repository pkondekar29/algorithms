package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.HashMap;

public class CoinChange {

    static int minCoins = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = new int[]{474,83,404,3};
        PrinterUtils.print(coinChange(nums, 11));
        PrinterUtils.print(coinChangeDp(nums, 264));
    }

    public static int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private static void dfs(int[] coins, int amount, int height) {
        if(amount < 0) return;
        if(amount == 0) {
            minCoins = Math.min(minCoins, height);
        }
        for(int i = 0; i < coins.length; i++) {
            dfs(coins, amount - coins[i], height + 1);
        }
    }

    public static int coinChangeMemo(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        Integer min = dfs(coins, amount, 0, memo);
        return min == null ? -1 : min;
    }

    private static Integer dfs(int[] coins, int amount, int height, HashMap<Integer, Integer> memo) {
        if(amount < 0) return null;
        if(amount == 0) {
            return 1;
        }
        if(memo.containsKey(amount)) return memo.get(amount);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            Integer curr = dfs(coins, amount - coins[i], height + 1, memo);
            min = Math.min(min, curr);
        }

        memo.put(amount, min);
        return amount;
    }

    public static int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int target = 1; target <= amount; target++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(target - coin >= 0 && dp[target - coin] != -1)
                    min = Math.min(dp[target - coin], min);
            }
            // Set dp[target] to -1 if target (current amount) can not be reach by  coins array
            dp[target] = min == Integer.MAX_VALUE ? -1 : 1 + min;
        }
        return dp[amount];
    }
}
