package com.prometheous.coding.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean colored = false;
        for(int i = 0; i < m && !colored; i++) {
            for(int j = 0; j < n && !colored; j++) {
                if(grid[i][j] == 1) {
                    color(grid, i, j, q);
                    colored = true;
                }
            }
        }

        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] at = q.poll();
                if(grid[at[0]][at[1]] == 1) return steps;

                for(int k = 0; k < 4; k++) {
                    int nx = at[0] + dx[k], ny = at[1] + dy[k];
                    if(nx < 0 || ny < 0
                            || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == 2) {
                        continue;
                    }
                    if(grid[nx][ny] == 1) {
                        return steps;
                    }
                    grid[nx][ny] = 2;
                    q.offer(new int[] {nx, ny});
                }
            }

            steps++;
        }
        return -1;
    }

    private void color(int[][] grid, int i, int j, Queue<int[]> q) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) return;

        grid[i][j] = 2;
        q.offer(new int[] {i, j});
        for(int k = 0; k < 4; k++) {
            color(grid, i + dx[k], j + dy[k], q);
        }
    }
}
