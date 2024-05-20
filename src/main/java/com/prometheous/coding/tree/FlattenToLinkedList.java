package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

import java.util.LinkedList;

public class FlattenToLinkedList {

   public static void main(String[] args) {

      TreeNode root = new TreeNode(10,
            new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
            new TreeNode(-3, null, new TreeNode(11)));

      flatten(root);
      flattenEff(root);
      flattenEffConcise(root);
      while (root != null) {
         System.out.print(root.val + ", ");
         root = root.right;
      }
   }

   public static void flattenEffConcise2(TreeNode root) {

   }

   public static void flattenEffConcise(TreeNode root) {

      solve(root, null);
   }

   private static TreeNode solve(TreeNode root, TreeNode last) {

      if (root == null)
         return last;
      root.right = solve(root.left, solve(root.right, last));
      root.left = null;
      return root;
   }

   public static void flattenEff(TreeNode root) {

      if (root == null)
         return;
      flattenAll(root);
   }

   private static TreeNode flattenAll(TreeNode root) {

      if (root.left == null && root.right == null)
         return root;    // return leaf node
      TreeNode temp = root.right;
      if (root.left != null) {
         // Flatten left sub tree
         root.right = flattenAll(root.left);
         root.left = null;
         if (temp != null) {
            // Traverse flattened Tree Node
            TreeNode cursor = root.right;
            while (cursor.right != null) {
               cursor = cursor.right;
            }
            // Assign it to prev right
            cursor.right = temp;
         }
      }
      // Flatten the prev right
      if (temp != null) {
         flattenAll(temp);
      }
      return root;
   }

   public static void flatten(TreeNode root) {

      LinkedList<TreeNode> preOrderList = new LinkedList<>();
      preOrderTraverse(root, preOrderList);

      TreeNode prev = null;
      for (TreeNode node : preOrderList) {
         if (prev != null) {
            prev.right = node;
            prev.left = null;
         }
         prev = node;
      }
   }

   private static void preOrderTraverse(TreeNode root, LinkedList<TreeNode> node) {

      if (root == null)
         return;

      node.addLast(root);
      preOrderTraverse(root.left, node);
      preOrderTraverse(root.right, node);
   }

}
