package com.prometheous.coding.graph;

public class NumberOfIslands {

   static int[] dx = new int[] { 1, -1, 0, 0 };
   static int[] dy = new int[] { 0, 0, 1, -1 };

   public static void main(String[] args) {

      System.out.println(
            numIslands(new char[][] { { '1', '0', '1', '1' }, { '1', '0', '0', '0' }, { '0', '1', '1', '0' } }));

      System.out.println(numIslandsSpaceEff(
            new char[][] { { '1', '0', '1', '1' }, { '1', '0', '0', '0' }, { '0', '1', '1', '0' } }));
   }

   public static int numIslandsSpaceEff(char[][] grid) {

      int islands = 0;
      int n = grid.length;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
               dfsFill(i, j, grid);
               islands++;
            }
         }
      }
      return islands;
   }

   private static void dfsFill(int i, int j, char[][] grid) {

      grid[i][j] = '0';
      int nextI, nextJ;
      for (int p = 0; p < 4; p++) {
         nextI = i + dx[p];
         nextJ = j + dy[p];
         if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid.length && grid[nextI][nextJ] == '1') {
            dfsFill(i + dx[p], j + dy[p], grid);
         }
      }
   }

   public static int numIslands(char[][] grid) {

      int islands = 0;
      int n = grid.length;
      boolean[][] vis = new boolean[n][n];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1' && !vis[i][j]) {
               dfs(i, j, grid, vis);
               islands++;
            }
         }
      }
      return islands;
   }

   private static void dfs(int i, int j, char[][] grid, boolean[][] vis) {

      vis[i][j] = true;
      int nextI, nextJ;
      for (int p = 0; p < 4; p++) {
         nextI = i + dx[p];
         nextJ = j + dy[p];
         if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid.length && grid[nextI][nextJ] == '1'
               && !vis[nextI][nextJ]) {
            dfs(i + dx[p], j + dy[p], grid, vis);
         }
      }
   }

}
