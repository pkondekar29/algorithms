package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class CoinChangeII {

    public static void main(String[] args) {
        PrinterUtils.print(new CoinChangeII().numberOfWaysToGetAmount(new int[] {1,2,5}, 5));
    }

    public int numberOfWaysToGetAmount(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // For each count amount
        for(int coinAmount : coins) {
            // How to build the current amount using current coin amount
            for(int i = 1; i <= amount; i++) {
                // If the coin amount is less than the amount, we can take this coin amount in consideration
                if(coinAmount <= i) {
                    // Add the ways to make whatever is left taking this coin amount in consideration
                    dp[i] += dp[i - coinAmount];
                }
            }
        }
        return dp[amount];
    }

}
