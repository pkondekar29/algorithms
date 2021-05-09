package com.prometheous.coding.graph;

import com.prometheous.coding.model.Node;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.Arrays;
import java.util.HashSet;

public class DetectCycle {

    public static void main(String[] args) {
        Node p1 = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        Node p5 = new Node(5);
        Node p6 = new Node(6);
        p1.neighbors = Arrays.asList(p2,p3);
        p2.neighbors = Arrays.asList(p1,p4,p6);
        p3.neighbors = Arrays.asList(p1,p4);
        p4.neighbors = Arrays.asList(p2,p3,p5);
        p5.neighbors = Arrays.asList(p4,p6);
        p6.neighbors = Arrays.asList(p5,p2);

        PrinterUtils.print(p1);

        PrinterUtils.print(new DetectCycle().cycleExists(p1));
    }

    /**
     * Not that efficient if we don't know number of vertices.
     * @param node
     * @return
     */
    public boolean cycleExists(Node node){
        HashSet<Node> visited = new HashSet<>();
        return dfs(node, visited);
    }

    private boolean dfs(Node node, HashSet<Node> visited) {
        if(node == null) return false;
        if(visited.contains(node)) return true;

        visited.add(node);
        for(Node neighbor : node.neighbors) {
            if(dfs(neighbor, visited)) return true;
        }
        visited.remove(node);
        return false;
    }
}