package com.prometheous.coding.tree;

import com.prometheous.coding.model.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinDepthNAryTree {

   public static void main(String[] args) {

   }

   private static int minDepth(Node root) {

      if (root == null)
         return 0;

      int level = 1;
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         int n = queue.size();
         while (n-- > 0) {
            Node node = queue.poll();
            if (node.neighbors == null || node.neighbors.size() == 0) {
               return level;
            }

            for (int i = 0; i < node.neighbors.size(); i++) {
               queue.offer(node.neighbors.get(i));
            }
         }
         level++;
      }
      return level;
   }

}
