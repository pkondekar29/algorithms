package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.HashMap;

public class SumOfSquares {

   public static void main(String[] args) {

      PrinterUtils.print(findMinimumNumberOfSquaresForSum(13));
      PrinterUtils.print(findMinimumNumberOfSquaresForSumMemo(13));
      PrinterUtils.print(findMinimumNumberOfSquaresForSumDP(13));
   }

   public static int findMinimumNumberOfSquaresForSum(int n) {

      if (n < 0)
         return Integer.MAX_VALUE;
      if (n == 0)
         return 0;
      int min = n;
      for (int i = 1; i * i <= n; i++) {
         min = Math.min(min, findMinimumNumberOfSquaresForSum(n - (i * i)) + 1);
      }
      return min;
   }

   public static int findMinimumNumberOfSquaresForSumMemo(int n) {

      HashMap<Integer, Integer> memo = new HashMap<>();
      return dfsMemo(n, memo);
   }

   private static Integer dfsMemo(int n, HashMap<Integer, Integer> memo) {

      if (n < 0)
         return null;
      if (n == 0)
         return 0;
      if (memo.containsKey(n))
         return memo.get(n);

      int min = n;
      for (int i = 1; i * i <= n; i++) {
         min = Math.min(min, dfsMemo(n - (i * i), memo) + 1);
      }
      memo.put(n, min);
      return min;
   }

   private static Integer findMinimumNumberOfSquaresForSumDP(int n) {

      int[] dp = new int[n + 1];
      for (int i = 0; i < 4; i++)
         dp[i] = i;
      for (int i = 4; i <= n; i++) {
         int min = i;
         for (int j = 1; j * j <= i; j++) {
            int remain = i - j * j;
            if (remain >= 0)
               min = Math.min(min, dp[remain] + 1);
         }
         dp[i] = min;
      }
      PrinterUtils.print(dp);
      return dp[n];
   }

}
