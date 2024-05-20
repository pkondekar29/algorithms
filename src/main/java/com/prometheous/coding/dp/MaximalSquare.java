package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class MaximalSquare {

   public static void main(String[] args) {

      char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
            { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };

      PrinterUtils.print(new MaximalSquare().maximalSquare(matrix));
   }

   public int maximalSquare(char[][] matrix) {

      int m = matrix.length, n = matrix[0].length, maxSquareLength = 0;
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
            if (matrix[i - 1][j - 1] == '1') {
               // minimum of what we can have considering top, left, top-left chars + 1
               dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
               maxSquareLength = Math.max(dp[i][j], maxSquareLength);
            }
         }
      }
      return maxSquareLength * maxSquareLength;
   }

}
