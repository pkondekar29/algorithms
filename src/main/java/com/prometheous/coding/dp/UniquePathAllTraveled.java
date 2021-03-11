package com.prometheous.coding.dp;

import java.util.Arrays;

public class UniquePathAllTraveled {

    static int ans = 0;

    public static void main(String[] args) {
        int[][] grid = new int[3][2];
        grid[0][1] = 1;
        grid[2][0] = 2;

        System.out.println(findPaths(grid));
        System.out.println(uniquePaths(grid));
    }

    public static int findPaths(int[][] grid) {
        int p = 0, q = 0, m = grid.length, n = grid[0].length;
        int nz = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    p = i;
                    q = j;
                } else if(grid[i][j] == 0) {
                    nz++;
                } else if(grid[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        findPathsRec(grid, p, q, nz, 0, visited);
        return ans;
    }

    private static void findPathsRec(int[][] grid, int p, int q, int nz, int currSteps, boolean[][] visited) {
        // Obstacle
        if(grid[p][q] == -1) return;
        // If we reach the start and currSteps are equal to No of zeroes, i.e., everything is traversed
        if(grid[p][q] == 1) {
            if(nz == currSteps) {
                ans++;
            }
            return;
        }
        if(grid[p][q] == 0) currSteps++;

        // Visit
        visited[p][q] = true;

        // Up
        if (p >= 1 && !visited[p - 1][q] && grid[p - 1][q] != -1)
            findPathsRec(grid, p - 1, q, nz, currSteps, visited);
        // Left
        if (q >= 1 && !visited[p][q - 1] && grid[p][q - 1] != -1)
            findPathsRec(grid, p, q - 1, nz, currSteps, visited);
        // Down
        if (p < grid.length - 1 && !visited[p + 1][q] && grid[p + 1][q] != -1)
            findPathsRec(grid, p + 1, q, nz, currSteps, visited);
        // Right
        if (q < grid[0].length - 1 && !visited[p][q + 1] && grid[p][q + 1] != -1)
            findPathsRec(grid, p, q + 1, nz, currSteps, visited);

        // Un-visit
        visited[p][q] = false;
    }


    // Function to return the count of the unique paths
    static int uniquePaths(int[][] grid)
    {
        int z_count = 0; // Total 0s present
        int n = grid.length, m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(vis[i], false);
        }
        int x = 0, y = 0;
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < m; ++j)
            {

                // Count non-obstacle blocks
                if (grid[i][j] == 0)
                    z_count++;
                else if (grid[i][j] == 1)
                {

                    // Starting position
                    x = i;
                    y = j;
                }
            }
        }
        dfs(x, y, grid, vis, 0, z_count);
        return ans;
    }

    static void dfs(int i, int j, int[][] grid,
                    boolean[][] vis, int z, int z_count)
    {
        int n = grid.length, m = grid[0].length;

        // Mark the block as visited
        vis[i][j] = true;
        if (grid[i][j] == 0)

            // update the count
            z++;

        // If end block reached
        if (grid[i][j] == 2)
        {

            // If path covered all the non-
            // obstacle blocks
            if (z == z_count)
                ans++;
            vis[i][j] = false;
            return;
        }

        // Up
        if (i >= 1 && !vis[i - 1][j] && grid[i - 1][j] != -1)
            dfs(i - 1, j, grid, vis, z, z_count);

        // Down
        if (i < n - 1 && !vis[i + 1][j] && grid[i + 1][j] != -1)
            dfs(i + 1, j, grid, vis, z, z_count);

        // Left
        if (j >= 1 && !vis[i][j - 1] && grid[i][j - 1] != -1)
            dfs(i, j - 1, grid, vis, z, z_count);

        // Right
        if (j < m - 1 && !vis[i][j + 1] && grid[i][j + 1] != -1)
            dfs(i, j + 1, grid, vis, z, z_count);

        // Unmark the block (unvisited)
        vis[i][j] = false;
    }

}
