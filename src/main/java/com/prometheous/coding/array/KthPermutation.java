package com.prometheous.coding.array;

import java.util.ArrayList;

public class KthPermutation {

   private static String findKthPermutation(int n, int k) {

      StringBuilder sb = new StringBuilder();
      ArrayList<Integer> num = new ArrayList<>();
      int fact = 1;
      for (int i = 1; i <= n; i++) {
         fact *= i;
         num.add(i);
      }
      for (int i = 0, l = k - 1; i < n; i++) {
         fact /= (n - i);
         int index = (l / fact);
         sb.append(num.remove(index));
         l -= index * fact;
      }
      return sb.toString();
   }

}
