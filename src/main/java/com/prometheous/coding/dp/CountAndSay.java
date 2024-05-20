package com.prometheous.coding.dp;

public class CountAndSay {

   static String[] dp = new String[30];

   static {
      dp[0] = "1";
   }

   public static void main(String[] args) {

      int n = 5;
      System.out.println(countAndSay(n));
   }

   private static String countAndSay(int n) {

      for (int i = 1; i < n; i++) {
         dp[i] = say(i);
      }
      return dp[n - 1];
   }

   private static String say(int i) {

      if (dp[i] != null)
         return dp[i];

      String str = dp[i - 1];
      char curr = str.charAt(0);
      int currCount = 1;
      int k = 1;
      StringBuilder sb = new StringBuilder();
      while (k < str.length()) {
         if (curr != str.charAt(k)) {
            sb.append(currCount).append(curr);
            curr = str.charAt(k);
            currCount = 1;
         } else {
            currCount++;
         }
         k++;
      }
      sb.append(currCount).append(curr);

      dp[i] = sb.toString();
      return dp[i];
   }

}
