package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.HashSet;

public class LowestCommonAncestor {

   public static void main(String[] args) {

      TreeNode root = new TreeNode(1, new TreeNode(-1, null, null), new TreeNode(2, new TreeNode(3, null, null), null));
      PrinterUtils.print(new LowestCommonAncestor().lca(root, 2, -1));
      PrinterUtils.print(new LowestCommonAncestor().lcaEff(root, 2, -1));
   }

   TreeNode r = null;

   public int find(TreeNode root, int p, int q) {

      if (root == null) {
         return 0;
      }
      int i = 0, j = find(root.left, p, q), k = find(root.right, p, q);
      if (root.val == p) {
         i++;
      }
      if (root.val == q) {
         i++;
      }
      if (i + j + k >= 2 && r == null) {
         r = root;
      }
      return i + j + k;
   }

   public int lcaEff(TreeNode root, int p, int q) {

      find(root, p, q);
      if (r == null) {
         return -1;
      }
      return r.val;
   }

   private int lca(TreeNode root, int a, int b) {

      if (root == null || (root.left == null && root.right == null))
         return -1;
      HashSet<Integer> set = new HashSet<>();
      Integer common = traverse(root.left, a, b, set);
      return common == null ? -1 : common;
   }

   private Integer traverse(TreeNode root, int a, int b, HashSet<Integer> set) {

      if (root == null)
         return null;
      Integer foundLeft = traverse(root.left, a, b, set);
      if (foundLeft != null)
         return foundLeft;

      set.add(root.val);

      Integer foundRight = traverse(root.right, a, b, set);
      if (foundRight != null)
         return foundRight;

      if (set.contains(a) && set.contains(b)) {
         return root.val;
      } else {
         return null;
      }
   }

}
