package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class FindRangeInSortedArr {

   public static void main(String[] args) {

      int[] nums = new int[] { 1 };
      PrinterUtils.print(findRange(nums, 1));
   }

   public static int[] findRange(int[] nums, int target) {

      int start = -1, end = -1;
      if (nums.length == 0)
         return new int[] { start, end };
      int low = 0, high = nums.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (mid > 0 && nums[mid] == target && nums[mid - 1] != target) {
            start = mid;
            break;
         } else if (nums[mid] >= target)
            high = mid - 1;
         else
            low = mid + 1;
      }
      if (start == -1 && low >= 0 && low < nums.length && nums[low] == target)
         start = low;
      low = 0;
      high = nums.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (mid < nums.length - 1 && nums[mid] == target && nums[mid + 1] != target) {
            end = mid;
            break;
         } else if (nums[mid] <= target)
            low = mid + 1;
         else
            high = mid - 1;
      }
      if (end == -1 && high >= 0 && high < nums.length && nums[high] == target)
         end = high;
      return new int[] { start, end };
   }

}
