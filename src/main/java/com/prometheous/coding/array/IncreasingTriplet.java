package com.prometheous.coding.array;

public class IncreasingTriplet {

   public static void main(String[] args) {

      int[] arr = new int[] { 4, 5, 6, 7, 9, 10, 12 };
      System.out.println(increasingTriplet(arr));
   }

   public static boolean increasingTriplet(int[] nums) {

      return dfs(nums, 0, 1);
   }

   private static boolean dfs(int[] nums, int index, int count) {

      if (count == 3)
         return true;
      if (index == nums.length)
         return false;

      boolean found = false;
      for (int i = index + 1; i < nums.length && !found; i++) {
         if (nums[i] > nums[index]) {
            found = dfs(nums, i, count + 1);
         }
      }
      return found;
   }

}
