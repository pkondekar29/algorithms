package com.prometheous.coding.graph;

import java.util.*;

public class ShortestPathWithObstacles {

    int[] dx = new int[] {0,0,1,-1};
    int[] dy = new int[] {1,-1,0,0};

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };
        System.out.println(new ShortestPathWithObstacles().shortestPath(grid, 2));
        System.out.println(new ShortestPathWithObstacles().shortestPathBFS(grid, 2));

    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0,0,0,k});
        dist[0][0] = 0;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int x = node[0], y = node[1], steps = node[2], rem = node[3];
            if(x == m - 1 && y == n - 1) return steps;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                int cost = steps + 1;
                if(cost < dist[nx][ny]) {
                    if(grid[nx][ny] == 1) {
                        if(rem > 0) {
                            pq.offer(new int[] {nx, ny, cost, rem-1});
                            dist[nx][ny] = cost;
                        } else {
                            continue;
                        }
                    } else {
                        pq.offer(new int[] {nx, ny, cost, rem});
                    }
                }
            }
        }
        return dist[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dist[m - 1][n - 1];
    }

    public int shortestPathBFS(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if(k >= m + n - 2) {
            return m + n - 2;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0,0,0});
        Set<String> seen = new HashSet<>();
        seen.add(0 + "," + 0 + "," + k);
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == m - 1 && curr[1] == n - 1) {
                return curr[3];
            }
            for(int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i], ny = curr[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                int nextK = curr[2] - grid[nx][ny];
                if(nextK >= 0 && !seen.contains(nx + "," + ny + "," + nextK)) {
                    q.offer(new int[] {nx, ny, nextK, curr[3] + 1});
                    seen.add(nx + "," + ny + "," + nextK);
                }
            }
        }
        return -1;
    }
}
