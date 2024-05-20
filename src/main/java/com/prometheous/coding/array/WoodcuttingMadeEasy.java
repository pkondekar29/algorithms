package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.Collections;

public class WoodcuttingMadeEasy {

   public int solve(ArrayList<Integer> trees, int target) {

      int low = 0, high = Collections.max(trees), mid;
      while (low <= high) {
         mid = low + (high - low) / 2;
         int collectedTimber = collect(trees, mid);
         if (collectedTimber == target)
            return mid;
         else if (collectedTimber < target)
            high = mid - 1;
         else
            low = mid + 1;
      }
      return low;
   }

   private int collect(ArrayList<Integer> trees, int mid) {

      int collected = 0;
      for (int h : trees) {
         if (h > mid) {
            collected += (h - mid);
         }
      }
      return collected;
   }

}
