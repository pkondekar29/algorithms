package com.prometheous.coding.graph;

import java.util.*;

public class CheapestRouteWithKStops {


    /**
     * There are n spots in a garden connected by some number of paths.
     * You are given an array "paths" where paths[i] = [fromi, toi, pricei] indicates that there is a path from spot fromi to spot toi with cost pricei.
     * You are also given three integers "start", "end", and k, return the cheapest price from "start" to "end" with at most k stops.
     * If there is no such route, return -1.
     * Constraints:
     * 1 <= n <= 100
     * 0 <= paths.length <= (n * (n - 1) / 2)
     * paths[i].length == 3
     * 0 <= from_i, to_i < n
     * from_i != to_i
     * 1 <= price_i <= 10^4
     * There will not be any multiple paths between two spots.
     * 0 <= start,end,k < n
     * start != end
     *
     *
     * Input: n = 4, paths = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], start = 0, end = 3, k = 1
     *
     */
    public static void main(String[] args) {
        int[][] paths = new int[][] {{0,1,100}, {1,2,100},{2,0,100}, {1,3,600}, {2,3,200}};
        int start = 0, end = 3, k = 1;

        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] path : paths) {
            adjList.putIfAbsent(path[0], new ArrayList<>());
            adjList.get(path[0]).add(new int[] {path[1], path[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[] {start, 0, k + 1});

        while(!minHeap.isEmpty()) {

            int[] curr = minHeap.poll();
            int price = curr[1];

            int nextNode = curr[0];
            int stops = curr[2];

            if(nextNode == end) {
                System.out.println(price);
                return;
            }

            if(stops > 0) {
                for(int[] neighbor : adjList.get(nextNode)) {
                    int to = neighbor[0];
                    int nextPrice = price + neighbor[1];
                    minHeap.offer(new int[]{to, nextPrice, stops - 1});
                }
            }
        }

        System.out.println(-1);
    }
}
