package com.prometheous.coding.graph;

import com.prometheous.coding.model.Node;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {

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

        Node replica = new CloneGraph().cloneGraph(p1);

        PrinterUtils.printLine();
        PrinterUtils.print(replica);
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    public Node dfs(Node current, HashMap<Integer, Node> cloned) {
        if(current == null) return null;
        if(cloned.containsKey(current.val))
            return cloned.get(current.val);

        Node replica = new Node(current.val);
        cloned.put(replica.val, replica);
        for (Node neighbor : current.neighbors) {
            replica.neighbors.add(dfs(neighbor, cloned));
        }
        return replica;
    }

}
