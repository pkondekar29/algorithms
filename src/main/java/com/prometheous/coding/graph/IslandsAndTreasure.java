package com.prometheous.coding.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandsAndTreasure {

   public static void main(String[] args) {
      islandsAndTreasure(new int[][] {{Integer.MAX_VALUE,1,0},{0,1,1}});
   }

   static int[] X = new int[]{1,-1,0,0};
   static int[] Y = new int[]{0,0,1,-1};
   public static void islandsAndTreasure(int[][] grid) {
      Queue<int[]> queue = new ArrayDeque<>();
      int rows = grid.length, cols = grid[0].length;
      for(int i = 0; i < rows; i++) {
         for(int j = 0; j < cols; j++) {
            if(grid[i][j] == 0) {
               queue.add(new int[]{i,j});
            }
         }
      }

      int steps = 1, size;
      Queue<int[]> nQueue = new ArrayDeque<>();
      while(!queue.isEmpty()) {
         size = queue.size();
         for(int i = 0; i < size; i++) {
            int[] point = queue.remove();
            for(int k = 0; k < 4; k++) {
               int x = point[0] + X[k], y = point[1] + Y[k];
               if(x >= 0 && x < rows && y >= 0 && y < cols) {
                  if(grid[x][y] == Integer.MAX_VALUE) {
                     grid[x][y] = steps;
                     nQueue.add(new int[]{x,y});
                  }
               }
            }
         }
         steps++;
         queue = nQueue;
      }
   }

}
