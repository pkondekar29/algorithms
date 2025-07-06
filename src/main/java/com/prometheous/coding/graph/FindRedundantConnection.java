package com.prometheous.coding.graph;

public class FindRedundantConnection {

    int[] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        for(int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            if(!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int x) {
        if(x == parent[x]) return x;
        else return find(parent[x]);
    }

    private boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if(rootU == rootV) return false;
        if(rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if(rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootU] = rootV;
            rank[rootV]++;
        }
        return true;
    }
}
