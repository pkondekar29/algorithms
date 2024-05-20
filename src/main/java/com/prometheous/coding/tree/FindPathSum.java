package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

public class FindPathSum {

   public static void main(String[] args) {

      TreeNode node = new TreeNode(1, new TreeNode(2), null);
      System.out.println(hasPathSum(node, 1));
   }

   public static boolean hasPathSum(TreeNode root, int targetSum) {

      if (root == null)
         return false;

      if (root.left == null && root.right == null)
         return targetSum == root.val;

      return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
   }

   public static boolean hasPathSum1(TreeNode root, int targetSum) {

      if (root == null)
         return false;

      return findPathSum(root, targetSum);
   }

   private static boolean findPathSum(TreeNode root, int targetSum) {

      if (root.left == null && root.right == null) {
         if (targetSum == root.val)
            return true;
         else
            return false;
      }

      boolean l = false, r = false;
      if (root.left != null)
         l = findPathSum(root.left, targetSum - root.val);

      if (root.right != null)
         r = findPathSum(root.right, targetSum - root.val);

      return l || r;
   }

}