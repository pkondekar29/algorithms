package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

public class PathNumbersSum {

   static int res = 0;

   public static int sumNumbers(TreeNode root) {

      helper(root, 0);
      return res;
   }

   private static void helper(TreeNode root, int pathSum) {

      if (root == null)
         return;

      int currSum = pathSum * 10 + root.val;
      if (root.left == null && root.right == null) {
         res = res + currSum;
         return;
      }
      helper(root.left, currSum);
      helper(root.right, currSum);
   }

}
