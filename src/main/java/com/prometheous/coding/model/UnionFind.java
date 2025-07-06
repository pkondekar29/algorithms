package com.prometheous.coding.model;

public class UnionFind {

    int[] parent;
    int[] rank;
    int count;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.count = n;
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if(rootU != rootV) {
            if(rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if(rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootU] = rootV;
                rank[rootV] += 1;
            }
        }
    }
}
