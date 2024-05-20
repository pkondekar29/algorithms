package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class FindDuplicateNumberInRangeN {

   public static void main(String[] args) {

      int[] nums = new int[] { 3, 1, 3, 4, 2 };
      PrinterUtils.print(findDuplicateNumberInRangeN(nums));
   }

   public static int findDuplicateNumberInRangeN(int[] nums) {

      int slow = nums[0], fast = nums[nums[0]];
      while (slow != fast) {
         slow = nums[slow];
         fast = nums[nums[fast]];
      }
      slow = 0;
      while (slow != fast) {
         slow = nums[slow];
         fast = nums[fast];
      }
      return slow;
   }

   public static int findDuplicateNumberInRangeWrong(int[] nums) {

      int num;
      for (int i = 0; i < nums.length; i++) {
         num = Math.abs(nums[i]);
         nums[num - 1] = -nums[num - 1];
      }
      int[] p = new int[2];
      int k = 0;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] > 0) {
            p[k] = nums[i];
            k++;
         }
      }
      int count1 = 0;
      for (int i = 0; i < nums.length; i++) {
         if (Math.abs(nums[i]) == p[0])
            count1++;
      }
      return count1 > 1 ? p[0] : p[1];
   }

}
