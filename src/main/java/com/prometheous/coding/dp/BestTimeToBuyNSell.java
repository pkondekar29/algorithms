package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class BestTimeToBuyNSell {

   public static void main(String[] args) {

      int[] arr = new int[] { 7, 1, 5, 3, 6, 4 };
      PrinterUtils.print(findMaxProfitI(arr));
      PrinterUtils.print(findMaxProfitII(arr));
   }

   /**
    * Only 1 transaction
    *
    * @param nums
    * @return
    */
   public static int findMaxProfitI(int[] nums) {
      //        Same as MaximumSubArray
      //        int max = 0, min = Integer.MAX_VALUE;
      //        for (int i = 0; i < prices.length; i++) {
      //            if (prices[i] < min) min = prices[i];
      //            else if (prices[i] > min) max = Math.max(prices[i] - min, max);
      //        }
      //        return max;
      /**
       *
       * Kadane's algorithm
       */
      int max = 0, minSoFar = nums[0];
      for (int i = 1; i < nums.length; i++) {
         minSoFar = Math.min(minSoFar, nums[i]);
         max = Math.max(max, nums[i] - minSoFar);
      }
      return max;
   }

   /**
    * Multiple Transactions
    *
    * @param nums
    * @return
    */
   public static int findMaxProfitII(int[] nums) {
      //        int buy = 0, sell, n = nums.length, profit = 0;
      //        while(buy < n) {
      //            while(buy < n - 1 && nums[buy] > nums[buy + 1])
      //                buy++;      // Local Minima
      //
      //            sell = buy;     // We can sell from now on
      //
      //            while(sell < n - 1 && nums[sell] < nums[sell + 1])
      //                sell++;     // Local Maxima
      //
      //            profit += nums[sell] - nums[buy];
      //
      //            buy = sell + 1; // increment to next day
      //        }
      //        return profit;
      int max = 0;
      for (int i = nums.length - 1; i > 0; i--) {
         if (nums[i] > nums[i - 1]) {
            max += nums[i] - nums[i - 1];
         }
      }
      return max;
   }

}
