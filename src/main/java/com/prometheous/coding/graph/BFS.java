package com.prometheous.coding.graph;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {

   public void bfs(List<List<Integer>> adjList) {

      Queue<Integer> queue = new ArrayDeque<>();
      boolean[] vis = new boolean[adjList.size()];
      queue.offer(0);
      vis[0] = true;

      List<Integer> ordering = new ArrayList<>();
      while (!queue.isEmpty()) {
         int at = queue.poll();
         vis[at] = true;
         ordering.add(at);

         for (Integer to : adjList.get(at)) {
            if (!vis[to]) {
               queue.offer(to);
            }
         }
      }
      PrinterUtils.printList(ordering);
   }

}
