package com.prometheous.coding.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;
   public TreeNode next;

   public TreeNode() {

   }

   public TreeNode(int val) {

      this.val = val;
   }

   public TreeNode(int val, TreeNode left, TreeNode right) {

      this.val = val;
      this.left = left;
      this.right = right;
   }

   public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {

      this.val = val;
      this.left = left;
      this.right = right;
      this.next = next;
   }

}
