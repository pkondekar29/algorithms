package com.prometheous.coding.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumOfKCount {

   public static void main(String[] args) {

      System.out.println(sum(new int[] { 10, 2, -2, -20, 10 }, -10));
   }

   public static int sum(int[] arr, int k) {

      Map<Integer, Integer> suffixSumMap = new HashMap<>();
      int count = 0;
      int currSum = 0;
      for (int num : arr) {
         currSum += num;     // Current currSum
         if (currSum == k)       // If currSum matches
            count++;

         count += suffixSumMap.getOrDefault(currSum - k, 0); // If there was any suffix found before, add it
         suffixSumMap.put(currSum, suffixSumMap.getOrDefault(currSum, 0) + 1); // Init the current currSum
      }
      return count;
   }
}