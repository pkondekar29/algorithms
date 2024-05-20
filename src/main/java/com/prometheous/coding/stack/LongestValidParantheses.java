package com.prometheous.coding.stack;

import java.util.Stack;

public class LongestValidParantheses {

   private static Stack<Character> st = new Stack<>();

   public static void main(String[] args) {

      String str = "(())(()()(())))(";
      System.out.println(LongestValidParantheses.findLongestValidParanthesStackEff(str));
   }

   public static int longestValidParenthesesDP(String str) {

      int max = 0;
      int[] dp = new int[str.length()];
      for (int i = 1; i < dp.length; i++) {
         if (str.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && str.charAt(i - dp[i - 1] - 1) == '(') {

            dp[i] = dp[i - 1] + 2;
            dp[i] += i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0;

            max = Math.max(max, dp[i]);
         }
      }
      return max;
   }

   public static int findLongestValidParanthesStackEff(String s) {

      Stack<Character> stack = new Stack<>();
      int maxLength = 0, currMax = 0;
      int n = s.length();
      for (int i = 0; i < n; i++) {
         if (s.charAt(i) == '(')
            stack.push('(');
         else {
            if (!stack.isEmpty()) {
               currMax += 2;
               maxLength = Math.max(maxLength, currMax);
               stack.pop();
            } else {
               stack.clear();
               currMax = 0;
            }
         }
      }
      return maxLength;
   }

   public static int findLongestValidParanthesEff(String s) {

      int left = 0, right = 0;
      int maxlength = 0;
      int n = s.length();
      for (int i = 0; i < n; i++) {
         if (s.charAt(i) == '(')
            left++;
         else
            right++;

         if (left == right)
            maxlength = Math.max(maxlength, 2 * right);
         else if (right > left)
            left = right = 0;
      }
      return maxlength;
   }

   public static int findLongestValidParanthes(String str) {

      int max = 0;
      for (int i = 0; i < str.length(); i++) {
         for (int j = i + 1; j < str.length(); j++) {
            if (isValidParantheses(str, i, j)) {
               max = Math.max(j - i + 1, max);
            }
         }
      }
      return max;
   }

   private static boolean isValidParantheses(String str, int i, int j) {

      st.clear();
      for (int k = i; k <= j; k++) {
         if (str.charAt(k) == '(') {
            st.push('(');
         } else {
            if (st.isEmpty() || st.pop() != '(') {
               return false;
            }
         }
      }
      return st.isEmpty();
   }

}
