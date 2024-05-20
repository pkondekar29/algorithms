package com.prometheous.coding.graph;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class DFS {

   Queue<Integer> queue = new ArrayDeque<>();

   public void dfs(List<List<Integer>> adjList) {

      int n = adjList.size();
      boolean[] vis = new boolean[n];
      for (int i = 0; i < n; i++) {
         dfsUtil(adjList, vis, 0);
      }
      PrinterUtils.print(queue);
   }

   private void dfsUtil(List<List<Integer>> adjList, boolean[] vis, int at) {

      vis[at] = true;
      queue.offer(at);
      for (Integer to : adjList.get(at)) {
         if (!vis[at]) {
            dfsUtil(adjList, vis, to);
         }
      }
   }

}
