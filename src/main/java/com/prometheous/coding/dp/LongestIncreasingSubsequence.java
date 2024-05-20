package com.prometheous.coding.dp;

import java.util.Arrays;
import java.util.HashMap;

public class LongestIncreasingSubsequence {

   public static void main(String[] args) {

      System.out.println(findLongestIncreasingSubsequenceLengthMemo(new int[] { 7, 7, 7, 7 }));
      System.out.println(findLongestIncreasingSubsequenceLengthDP(new int[] { 7, 7, 7, 7 }));
   }

   // T = O(n^2), S = O(n)
   public static int findLongestIncreasingSubsequenceLengthMemo(int[] nums) {

      if (nums == null || nums.length == 0)
         return 0;
      int max = 0;
      HashMap<Integer, Integer> memo = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         max = Math.max(DFS(nums, i, -1, memo), max);
      }
      return max;
   }

   private static int DFS(int[] nums, int index, int prevIndex, HashMap<Integer, Integer> memo) {

      if (memo.containsKey(index))
         return memo.get(index);
      if (index == nums.length)
         return 0;
      if (prevIndex != -1 && nums[index] <= nums[prevIndex])
         return 0;

      int currIndexMax = 1;
      for (int i = index; i < nums.length; i++) {
         currIndexMax = Math.max(currIndexMax, DFS(nums, i + 1, index, memo) + 1);
      }
      memo.put(index, currIndexMax);
      return currIndexMax;
   }

   // T = O(n^2), S = O(n)
   public static int findLongestIncreasingSubsequenceLengthDP(int[] nums) {

      if (nums.length <= 1)
         return nums.length;
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);
      for (int i = 1; i < nums.length; i++) {
         for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
               dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
         }
      }
      int max = 0;
      for (int i = 0; i < dp.length; i++) {
         max = Math.max(max, dp[i]);
      }
      return max;
   }

   // T = O(n*log(n)), S = O(n)
   public static int findLongestIncreasingSubsequenceLengthDPEff(int[] nums) {

      int[] tails = new int[nums.length];
      int size = 0;
      for (int x : nums) {
         int i = 0, j = size;
         while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
               i = m + 1;
            else
               j = m;
         }
         tails[i] = x;
         if (i == size)
            ++size;
      }
      return size;
   }
}
