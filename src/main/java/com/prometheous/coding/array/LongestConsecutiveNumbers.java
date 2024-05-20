package com.prometheous.coding.array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveNumbers {

   public static void main(String[] args) {
      int[] nums = new int[] {100,4,200,1,3,2};
      Map<Integer, Integer> set = new HashMap<>();
      for(int i = 0; i < nums.length; i++) set.put(i, nums[i]);
      int max = 0, count, pivot;
      for(int num : nums) {
         count = 0;
         pivot = num;
         while(set.containsKey(pivot)) {
            count++;
            pivot++;
            set.remove(pivot);
         }
         pivot = num - 1;
         while(set.containsKey(pivot)) {
            count++;
            pivot--;
            set.remove(pivot);
         }
         max = Math.max(max, count);
      }

   }
}
