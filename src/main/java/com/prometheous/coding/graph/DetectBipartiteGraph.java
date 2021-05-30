package com.prometheous.coding.graph;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DetectBipartiteGraph {

    public static void main(String[] args) {
        PrinterUtils.print(new DetectBipartiteGraph().isBipartiteBFS(new int[][] {{1,3},{0,2},{1,3},{0,2}}));
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(colors[i] != 0) continue;    // It is colored

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            colors[i] = 1;

            while (!queue.isEmpty()) {
                Integer at = queue.poll();
                for (int to : graph[at]) {
                    if (colors[to] == 0) {
                        colors[to] = -colors[at];
                        queue.offer(to);
                    } else if (colors[to] == colors[at])
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i = 0; i < n; i++) {
            if(colors[i] == 0 && !dfs(graph, i, 1, colors))
                return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int at, int color, int[] colors) {
        if(colors[at] != 0)
            return colors[at] == color;

        colors[at] = color;
        for(int to : graph[at]) {
            if(!dfs(graph, to, -color, colors))
                return false;
        }
        return true;
    }

}
