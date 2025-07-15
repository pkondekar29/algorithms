package com.prometheous.coding.graph;

import java.util.*;

public class PossibleBipartite {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0) return true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : dislikes) {
            adjList.putIfAbsent(edge[0], new ArrayList<>());
            adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] colors = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            if(colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;
            while(!queue.isEmpty()) {
                int at = queue.poll();
                int c = colors[at];
                if(adjList.containsKey(at)) {
                    for(int to : adjList.get(at)) {
                        if(colors[to] != 0 && colors[to] == colors[at]) {
                            return false;
                        }
                        if(colors[to] == 0) {
                            colors[to] = c == 1 ? 2 : 1;
                            queue.offer(to);
                        }
                    }
                }
            }
        }
        return true;
    }
}
