package com.prometheous.coding.graph;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (
                int bus = 0;
                bus < routes.length; bus++) {
            for (int station : routes[bus]) {
                map.putIfAbsent(station, new ArrayList<>());
                map.get(station).add(bus);
            }
        }

        Set<Integer> visitedBus = new HashSet<>();
        Set<Integer> visitedStations = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int buses = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            buses++;

            for (int i = 0; i < size; i++) {
                int at = q.poll();
                for (int bus : map.getOrDefault(at, new ArrayList<>())) {
                    if (!visitedBus.add(bus)) continue;
                    for (int station : routes[bus]) {
                        if (station == target) return buses;
                        if (visitedStations.add(station)) q.offer(station);
                    }
                }
            }
        }
        return -1;
    }
}
