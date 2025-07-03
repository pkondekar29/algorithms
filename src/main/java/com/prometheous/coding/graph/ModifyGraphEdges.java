package com.prometheous.coding.graph;

import java.util.*;

public class ModifyGraphEdges {

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            adjList[from].add(new int[] {to, i});
            adjList[to].add(new int[] {from, i});
        }
        int[][] distances = new int[n][2];
        Arrays.fill(distances[source], 0);
        for(int i = 0; i < n; i++) {
            if(i != source) {
                distances[i][0] = distances[i][1] = Integer.MAX_VALUE;
            }
        }

        runDijkstra(adjList, edges, distances, source, 0, destination, 0);
        int diff = target - distances[destination][0];
        if(diff < 0) return new int[][]{};
        runDijkstra(adjList, edges, distances, source, diff, destination, 1);
        if (distances[destination][1] < target) return new int[][]{};

        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1;
        }
        return edges;
    }

    private void runDijkstra(List<int[]>[] adjList, int[][] edges, int[][] distances, int src, int diff, int dest, int run) {
        int n = adjList.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {src, 0});
        distances[src][run] = 0;

        while(!pq.isEmpty()) {
            int[] atEdge = pq.poll();
            int at = atEdge[0], cost = atEdge[1];

            if(distances[at][run] < cost) continue;
            for(int[] edge : adjList[at]) {
                int to = edge[0], weight = edges[edge[1]][2];
                if(weight == -1) weight = 1;

                if(run == 1 && edges[edge[1]][2] == -1) {
                    int newWeight = diff + distances[to][0] - distances[at][1];
                    if(newWeight > weight) {
                        edges[edge[1]][2] = weight = newWeight;
                    }
                }

                if(distances[at][run] + weight < distances[to][run]) {
                    distances[to][run] = distances[at][run] + weight;
                    pq.offer(new int[] {to, distances[to][run]});
                }
            }
        }
    }
}
