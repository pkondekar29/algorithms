package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

   public static void main(String[] args) {

      int[] nums = new int[] { 1, 2, 3 };
      PrinterUtils.print(findPermutations(nums));
   }

   public static List<List<Integer>> findPermutations(int[] nums) {

      List<List<Integer>> res = new ArrayList<>();
      List<Integer> currList = new ArrayList<>();
      boolean[] vis = new boolean[nums.length];
      dfs(nums, vis, currList, res);
      return res;
   }

   private static void dfs(int[] nums, boolean[] vis, List<Integer> currList, List<List<Integer>> res) {

      if (currList.size() == nums.length) {
         res.add(new ArrayList<>(currList));
         return;
      }
      for (int i = 0; i < nums.length; i++) {
         if (!vis[i]) {
            currList.add(nums[i]);
            vis[i] = true;
            dfs(nums, vis, currList, res);
            currList.remove(currList.size() - 1);
            vis[i] = false;
         }
      }
   }

}
