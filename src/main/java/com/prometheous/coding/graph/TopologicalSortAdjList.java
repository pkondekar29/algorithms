package com.prometheous.coding.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortAdjList {

//    L ← Empty list that will contain the sorted elements
//    S ← Set of all nodes with no incoming edges
//    while S is non-empty do
//        remove a node n from S
//        add n to tail of L
//        for each node m with an edge e from n to m do
//            remove edge e from the graph
//            if m has no other incoming edges then
//                insert m into S
//    if graph has edges then
//        return error (graph has at least one cycle)
//    else
//        return L (a topologically sorted order)

    /**
     *  Kahn's algorithm for Top sort
     *
     *  L ← Empty list that will contain the sorted elements
     *     S ← Set of all nodes with no incoming edges
     *     while S is non-empty do
     *         remove a node n from S
     *         add n to tail of L
     *         for each node m with an edge e from n to m do
     *             remove edge e from the graph
     *             if m has no other incoming edges then
     *                 insert m into S
     *     if graph has edges then
     *         return error (graph has at least one cycle)
     *     else
     *         return L (a topologically sorted order)
     *
     * @param adjList
     * @return
     */
    public List<Integer> findTopSortOrder(List<List<Integer>> adjList) {
        // Incoming edge count
        int[] incomingEdges = new int[adjList.size()];
        int edgeCount = 0;
        // Find the incoming edges
        for(int i = 0; i < adjList.size(); i++) {
            for(Integer to : adjList.get(i)){
                incomingEdges[to]++;
                edgeCount++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // If the incoming edge is 0, then we can start from that vertex
        for(int i = 0; i < incomingEdges.length; i++) {
            if(incomingEdges[i] == 0)
                queue.offer(i);
        }
        LinkedList<Integer> ordering = new LinkedList<>();
        // While there are vertices which can be visited, i.e, all the incoming edges(previous edge are traversed)
        while(!queue.isEmpty()) {
            int nextVertex = queue.poll();
            ordering.addLast(nextVertex);
            for(Integer to : adjList.get(nextVertex)) {
                edgeCount--;
                incomingEdges[to]--;
                if(incomingEdges[to] == 0)  // If there are no incoming edges for the vertex, it can be traversed
                    queue.offer(to);
            }
        }
        if(edgeCount != 0)
            throw new Error("Cycle exists in the graph");

        return ordering;
    }

}
