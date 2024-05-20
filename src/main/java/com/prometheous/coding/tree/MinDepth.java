package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinDepth {

   public static void main(String[] args) {

      TreeNode root = new TreeNode(10,
            new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
            new TreeNode(-3, null, new TreeNode(11)));
      PrinterUtils.print(minDepth(root));
   }

   /**
    * In min Depth, BFS is better than DFS.
    *
    * @param root
    * @return
    */
   public static int minDepth(TreeNode root) {

      if (root == null)
         return 0;
      Queue<TreeNode> queue = new ArrayDeque<>();
      int level = 1;
      queue.offer(root);
      while (!queue.isEmpty()) {
         int n = queue.size();
         while (n-- > 0) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null)
               return level;

            if (node.left != null)
               queue.offer(node.left);
            if (node.right != null)
               queue.offer(node.right);
         }
         level++;
      }
      return level;
   }

}
