package com.prometheous.coding.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeLargerIsland {

    public static void main(String[] args) {

    }

    int[] dx = new int[] {0,0,1,-1};
    int[] dy = new int[] {1,-1,0,0};

    public int largestIslandDFS(int[][] grid) {
        Map<Integer, Integer> islandArea = new HashMap<>();
        int islandId = 2;
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = paintAndArea(grid, islandId, i, j);
                    islandArea.put(islandId, area);
                    islandId++;
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {

                    for(int k = 0; k < 4; k++) {
                    }

                }
            }
        }
        return 0;
    }

    public int paintAndArea(int[][] grid, int id, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;

        grid[i][j] = id;
        return 1 + paintAndArea(grid, id, i + 1, j) + paintAndArea(grid, id, i, j + 1)
                + paintAndArea(grid, id, i - 1, j) + paintAndArea(grid, id, i, j - 1);
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        UnionFind uf = new UnionFind(m * n);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                int id = i * n + j;
                if(i + 1 < m && grid[i + 1][j] == 1) {
                    uf.union(id, (i + 1) * n + j);
                }
                if(j + 1 < n && grid[i][j + 1] == 1) {
                    uf.union(id, i * n + j + 1);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    max = Math.max(uf.findSize(i*n + j), max);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> neighbours = new HashSet<>();
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                            continue;
                        }
                        if(grid[nx][ny] == 1) {
                            neighbours.add(uf.find(nx * n + ny));
                        }
                    }
                    int maxPossible = 1;
                    for(Integer id : neighbours) {
                        maxPossible += uf.findSize(id);
                    }
                    max = Math.max(max, maxPossible);
                }
            }
        }
        return max;
    }

    public class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if(rootU != rootV) {
                if(this.size[rootU] > this.size[rootV]) {
                    this.parent[rootV] = rootU;
                    this.size[rootU] += this.size[rootV];
                } else {
                    this.parent[rootU] = rootU;
                    this.size[rootV] += this.size[rootU];
                }
            }
        }

        public int find(int u) {
            if(this.parent[u] == u) return u;
            else return find(parent[u]);
        }

        public int findSize(int u) {
            return this.size[find(u)];
        }
    }
}
