package com.prometheous.coding.graph;

import java.util.Arrays;

public class CountNumberOfPairs {

    public int[] countOfPairs(int n, int x, int y) {
        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
            if(i < n) {
                graph[i][i + 1] = 1;
            }
            if(i > 1) {
                graph[i][i - 1] = 1;
            }
        }
        graph[x][y] = graph[y][x] = 1;
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        int[] res = new int[n];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] != Integer.MAX_VALUE && graph[i][j] > 0 && i != j) {
                    res[graph[i][j] - 1]++;
                }
            }
        }
        return res;
    }

    public int[] countOfPairsEff(int n, int x, int y) {
        int[] res = new int[n];
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                int min = Math.min(Math.abs(i - j), Math.min(
                        Math.abs(i - x) + 1 + Math.abs(y - j),
                        Math.abs(i - y) + 1 + Math.abs(x - j)));
                res[min - 1] += 2;
            }
        }
        return res;
    }
}
