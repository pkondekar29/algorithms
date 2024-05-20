package com.prometheous.coding.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAndAtlanticPlane {
   static int[] X = new int[] {1,-1,0,0};
   static int[] Y = new int[] {0,0,1,-1};
   public static void main(String[] args) {
      pacificAtlantic(new int[][]{
            {1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}
      });
   }

   public static List<List<Integer>> pacificAtlantic(int[][] heights) {
      int m = heights.length, n = heights[0].length;
      int[][] pac = new int[m][n], at = new int[m][n];
      Queue<int[]> pqueue = new ArrayDeque<>();
      Queue<int[]> aqueue = new ArrayDeque<>();
      for(int i = 0; i < n; i++) {
         pac[0][i] = 1;
         at[m - 1][i] = 1;
         pqueue.offer(new int[]{0, i});
         aqueue.offer(new int[]{m - 1, i});
      }
      for(int i = 0; i < m; i++) {
         pac[i][0] = 1;
         at[i][n - 1] = 1;
         pqueue.offer(new int[]{i, 0});
         aqueue.offer(new int[]{i, n - 1});
      }

      bfs(pqueue, pac, heights, m, n);
      bfs(aqueue, at, heights, m, n);
      List<List<Integer>> result = new ArrayList<>();
      for(int i = 0; i < m; i++) {
         for(int j = 0; j < n; j++) {
            if(pac[i][j] == 1 && at[i][j] == 1) {
               result.add(List.of(i, j));
            }
         }
      }
      return result;
   }

   static void bfs(Queue<int[]> queue, int[][] visited, int[][] heights, int m, int n) {
      while(!queue.isEmpty()) {
         int[] point = queue.remove();
         for(int i = 0; i < 4; i++) {
            int x = point[0] + X[i], y = point[1] + Y[i];
            if(x >= 0 && x < m && y >= 0 && y < n) {
               if(visited[x][y] == 0 && heights[point[0]][point[1]] <= heights[x][y]) {
                  visited[x][y] = 1;
                  queue.add(new int[] {x, y});
               }
            }
         }
      }
   }
}
