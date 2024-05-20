package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

public class ValidateBST {

   public static void main(String[] args) {

      TreeNode root = null;
      System.out.println(isValid(root));
   }

   public static boolean isValid(TreeNode root) {

      return isValid(root, null, null);
   }

   private static boolean isValid(TreeNode root, TreeNode min, TreeNode max) {

      if (root == null)
         return true;
      if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val))
         return false;
      return // While going to the left, current node should be max
            isValid(root.left, min, root)
                  // While going to the right, current node should be min
                  && isValid(root.right, root, max);
   }

}