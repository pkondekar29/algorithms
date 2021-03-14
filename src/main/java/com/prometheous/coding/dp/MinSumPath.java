package com.prometheous.coding.dp;

import java.util.Arrays;

public class MinSumPath {
    static Integer minSum;
    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4,5,6}};
//        MinSumPath.findMinSum(grid);
//        System.out.println(minSum);
//
        System.out.println(MinSumPath.findMinEff(grid));
    }

    public static int findMinEff(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void findMinSum(int[][] grid) {
        int i = 0, j = 0;
        minSum = Integer.MAX_VALUE;
        int currSum = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int k = 0; k < visited.length; k++) {
            Arrays.fill(visited[k], false);
        }
        DFS(grid, i, j, currSum, visited);
    }

    private static void DFS(int[][] grid, int i, int j, int currSum, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(i == grid.length - 1 && j == grid[0].length - 1)
            if(currSum + grid[i][j] < minSum) minSum = currSum + grid[i][j];
        if(visited[i][j]) return;

        visited[i][j] = true;

        DFS(grid, i + 1, j, currSum + grid[i][j], visited);
        DFS(grid, i, j + 1, currSum + grid[i][j], visited);

        visited[i][j] = false;
    }

}
