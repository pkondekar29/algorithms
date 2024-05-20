package com.prometheous.coding.array;

public class SearchInRotatedSortedArrWithDups {

   public static void main(String[] args) {

      int[] arr = new int[] { 4, 5, 6, 6, 6, 7, 8, 8, 9, 3 };
      System.out.println(solve(arr, 7));
   }

   private static boolean solve(int[] nums, int target) {

      int low = 0, high = nums.length - 1, mid;
      while (low <= high) {
         mid = (low + high) / 2;
         if (nums[mid] == target) {
            return true;
         }
         //If we know for sure right side is sorted or left side is unsorted
         if (nums[mid] < nums[high] || nums[mid] < nums[low]) {
            if (target > nums[mid] && target <= nums[high]) {
               low = mid + 1;
            } else {
               high = mid - 1;
            }
            //If we know for sure left side is sorted or right side is unsorted
         } else if (nums[mid] > nums[low] || nums[mid] > nums[high]) {
            if (target < nums[mid] && target >= nums[low]) {
               high = mid - 1;
            } else {
               low = mid + 1;
            }
            //If we get here, that means nums[low] == nums[mid] == nums[high], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use high-- but left++ works too
         } else {
            high--;
         }
      }
      return false;
   }

}
