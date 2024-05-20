package com.prometheous.coding.string;

public class LongestCommonSubstring {

   public static void main(String[] args) {

      String s1 = "ababcc";
      String s2 = "babcasd";

      System.out.println(findLongestCommonSubstring(s1, s2));
   }

   private static int findLongestCommonSubstring(String s1, String s2) {

      int[][] dp = new int[s1.length() + 1][s2.length() + 1];
      for (int i = 0; i <= s1.length(); i++) {
         dp[i][0] = 0;
      }
      for (int j = 0; j <= s2.length(); j++) {
         dp[0][j] = 0;
      }
      int max = 0, maxSubStringEndingIndex = 0;
      for (int i = 1; i <= s1.length(); i++) {
         for (int j = 1; j <= s2.length(); j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1] + 1;
               if (dp[i][j] > max) {
                  max = dp[i][j];
                  maxSubStringEndingIndex = i;
               }
            } else {
               dp[i][j] = 0;
            }
         }
      }
      System.out.println(s1.substring(maxSubStringEndingIndex - max, maxSubStringEndingIndex));
      return max;
   }

}
