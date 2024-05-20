package com.prometheous.coding.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumII {

   public static List<List<Integer>> ret = new ArrayList<>();

   public static void main(String[] args) {

      int[] a = { 10, 1, 2, 7, 6, 1, 5 };
      combinationSum2(a, 8);
      ret.forEach(list -> {
         list.forEach(e -> System.out.print(e + " "));
         System.out.println();
      });
      //        removeDup(res);
   }

   public static List<List<Integer>> combinationSum2(int[] A, int target) {

      Arrays.sort(A);
      dfs(A, target, 0, new ArrayList<>());
      return ret;
   }

   private static void dfs(int[] A, int target, int start, List<Integer> l) {

      if (target < 0)
         return;
      if (target == 0) {
         ret.add(new ArrayList<>(l));
         return;
      }
      for (int i = start; i < A.length; ++i) {
         if (i > start && A[i] == A[i - 1])
            continue;
         int n = A[i];
         l.add(n);
         dfs(A, target - n, i + 1, l);
         l.remove(l.size() - 1);
      }
   }

}
