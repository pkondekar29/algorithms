package com.prometheous.coding.dp;

public class UniquePathsInGrid {

   public static void main(String[] args) {

      System.out.println(findPaths(3, 2));
      ;
   }

   public static int findPaths(int m, int n) {

      int[][] dp = new int[m + 1][n + 1];
      for (int i = 0; i <= m; i++) {
         dp[i][0] = 0;
      }
      for (int i = 0; i <= n; i++) {
         dp[0][i] = 0;
      }
      dp[1][1] = 1;
      for (int i = 1; i <= m; i++) {
         int j = i == 1 ? 2 : 1;
         for (; j <= n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
         }
      }
      return dp[m][n];
   }

}
