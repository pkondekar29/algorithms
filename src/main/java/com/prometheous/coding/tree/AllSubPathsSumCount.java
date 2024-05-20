package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

import java.util.HashMap;

public class AllSubPathsSumCount {

   private static int count = 0;

   public static void main(String[] args) {

      TreeNode root = new TreeNode(10,
            new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
            new TreeNode(-3, null, new TreeNode(11)));
      int targetSum = 8;
      System.out.println(totalPathSum(root, targetSum));
      System.out.println(findCountOfAllPaths(root, targetSum));
      System.out.println(findCountOfAllPathsEff(root, targetSum));
   }

   /**
    * @param root
    * @param targetSum
    * @return
    */
   private static int findCountOfAllPathsEff(TreeNode root, int targetSum) {

      HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
      int currSum = 0;
      return traverse(root, targetSum, currSum, prefixSumMap);
   }

   private static int traverse(TreeNode root, int targetSum, int currSum, HashMap<Integer, Integer> prefixSumMap) {

      if (root == null)
         return 0;

      currSum += root.val;
      int count = prefixSumMap.getOrDefault(currSum - targetSum, 0);
      prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

      count += traverse(root.left, targetSum, currSum, prefixSumMap) + traverse(root.right, targetSum, currSum,
            prefixSumMap);

      prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);
      return count;
   }

   /**
    * @param root
    * @param targetSum
    * @return
    */
   public static int findCountOfAllPaths(TreeNode root, int targetSum) {

      if (root == null)
         return 0;

      return findCountOfAllPaths(root.left, targetSum) + findCountOfAllPaths(root.right, targetSum)
            + findCountOfAllPathsFrom(root, targetSum);
   }

   private static int findCountOfAllPathsFrom(TreeNode root, int targetSum) {

      if (root == null)
         return 0;

      return (root.val == targetSum ? 1 : 0) + findCountOfAllPathsFrom(root.left, targetSum - root.val)
            + findCountOfAllPathsFrom(root.right, targetSum - root.val);
   }

   /**
    * @param root
    * @param targetSum
    * @return
    */
   public static int totalPathSum(TreeNode root, int targetSum) {

      traverse(root, targetSum);
      return count;
   }

   private static void traverse(TreeNode root, int targetSum) {

      if (root == null)
         return;

      traverse(root.left, targetSum);
      traverse(root.right, targetSum);

      checkTargetSum(root, targetSum);
   }

   private static void checkTargetSum(TreeNode root, int targetSum) {

      if (targetSum - root.val == 0) {
         count++;
      }

      if (root.left != null)
         checkTargetSum(root.left, targetSum - root.val);
      if (root.right != null)
         checkTargetSum(root.right, targetSum - root.val);
   }

}
