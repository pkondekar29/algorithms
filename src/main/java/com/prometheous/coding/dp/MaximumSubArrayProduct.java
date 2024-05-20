package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class MaximumSubArrayProduct {

   public static void main(String[] args) {

      int[] arr = new int[] { -10, 10, -10, 10 };
      PrinterUtils.print(maxProductSubArrayDP(arr));
      PrinterUtils.print(maxProductSubArrayDPEff(arr));
   }

   private static int maxProductSubArrayDP(int[] nums) {

      if (nums.length == 1)
         return nums[0];

      int max = nums[0];
      int[] minProduct = new int[nums.length];
      int[] maxProduct = new int[nums.length];
      minProduct[0] = nums[0];
      maxProduct[0] = nums[0];

      // We keep track of Max and Min both because there can be negative products which become positive afterwards
      for (int i = 1; i < nums.length; i++) {
         minProduct[i] = Math.min(Math.min(maxProduct[i - 1] * nums[i], nums[i]), minProduct[i - 1] * nums[i]);
         maxProduct[i] = Math.max(Math.max(minProduct[i - 1] * nums[i], nums[i]), maxProduct[i - 1] * nums[i]);

         max = Math.max(Math.max(minProduct[i], maxProduct[i]), max);
      }
      return max;
   }

   private static int maxProductSubArrayDPEff(int[] nums) {

      if (nums.length == 1)
         return nums[0];

      int max = nums[0], maxHere = nums[0], minHere = nums[0];
      int temp;
      for (int i = 1; i < nums.length; i++) {
         temp = maxHere;
         maxHere = Math.max(Math.max(maxHere * nums[i], nums[i]), minHere * nums[i]);
         minHere = Math.min(Math.min(temp * nums[i], nums[i]), minHere * nums[i]);

         max = Math.max(max, maxHere);
      }
      return max;
   }
}
