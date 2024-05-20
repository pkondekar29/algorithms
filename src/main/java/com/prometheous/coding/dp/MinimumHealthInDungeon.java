package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class MinimumHealthInDungeon {

   public static void main(String[] args) {

      int[][] g = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
      PrinterUtils.print(minHealthInGrid(g));
   }

   public static int minHealthInGrid(int[][] grid) {

      int m = grid.length, n = grid[0].length;
      int[][] dp = new int[m][n];
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0)
               dp[i][j] = -grid[i][j];
            else if (i == 0)
               dp[i][j] = dp[i][j - 1] - grid[i][j];
            else if (j == 0)
               dp[i][j] = dp[i - 1][j] - grid[i][j];
            else
               dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) - grid[i][j];
         }
      }
      PrinterUtils.print(dp);
      return dp[m - 1][n - 1] + 1;
   }

}
