package com.prometheous.coding.design;

import java.util.HashMap;

/**
 *
 *  LFU Cache.
 *
 */
public class LFUCache {

    int cacheBound;

    class CountNode {
        int count;
        CountNode prev, next;
        Node nodeStart, nodeEnd;

        CountNode(int count) {
            this.count = count;
            this.nodeEnd = new Node(-1,-1);
            this.nodeStart = new Node(-1, -1);
            this.nodeStart.next = this.nodeEnd;
            this.nodeEnd.prev = this.nodeStart;
        }
    }

    class Node {
        Node prev, next;
        CountNode countNode;
        int key, val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> lookup;
    CountNode refStart, refEnd;

    public LFUCache(int bound) {
        this.cacheBound = bound;
        lookup = new HashMap<>();
        refStart = new CountNode(-1);
        refEnd = new CountNode(-1);
        refStart.next = refEnd;
        refEnd.prev = refStart;
    }

    public int get(int key) {
        if(lookup.containsKey(key)) {
            Node node = lookup.get(key);

            // Move this node to next count Node
            updateCountNode(node);
            return node.val;
        } else  // Cache miss
            return -1;
    }

    public void put(int key, int value) {
        if(this.cacheBound == 0) return;
        // If already present, update and move to next count Node
        Node node;
        if(lookup.containsKey(key)) {
            node = lookup.get(key);
            node.val = value;
            updateCountNode(node);
        } else {
            // Evict if bound overflow
            if(this.lookup.size() == this.cacheBound) {
                CountNode leastFrequentCountNode = refStart.next;

                Node toEvict = leastFrequentCountNode.nodeEnd.prev;
                toEvict.prev.next = toEvict.next;
                toEvict.next.prev = toEvict.prev;

                toEvict.next = null;
                toEvict.prev = null;
                lookup.remove(toEvict.key);

                // If number of node with least freq is 0, remove
                if(leastFrequentCountNode.nodeStart.next == leastFrequentCountNode.nodeEnd) {
                    deleteCountNode(leastFrequentCountNode);
                }
            }

            // Create new Node
            node = new Node(key, value);
            if(refStart.next.count != 0) {
                addCountNodeAtStart(new CountNode(0));
            }
            CountNode countNode = refStart.next;

            node.next = countNode.nodeStart.next;
            node.prev = countNode.nodeStart;
            node.next.prev = node;
            countNode.nodeStart.next = node;

            node.countNode = countNode;
        }
        // Add to cache
        lookup.put(key, node);
    }

    private void updateCountNode(Node node) {
        CountNode countNode = node.countNode;
        // Remove from this countNode
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // Add to next count Node
        CountNode nextCountNode;
        if(countNode.count != countNode.next.count - 1) {
            nextCountNode = new CountNode(countNode.count + 1);
            nextCountNode.next = countNode.next;
            nextCountNode.prev = countNode;
            countNode.next.prev = nextCountNode;
            countNode.next = nextCountNode;
        } else {
            nextCountNode = countNode.next;
        }

        node.next = nextCountNode.nodeStart.next;
        node.prev = nextCountNode.nodeStart;
        node.next.prev = node;
        nextCountNode.nodeStart.next = node;

        node.countNode = nextCountNode;

        // If freq of current count Node is 0, remove
        if(countNode.nodeStart.next == countNode.nodeEnd) {
            deleteCountNode(countNode);
        }
    }

    private void deleteCountNode(CountNode countNode) {
        countNode.prev.next = countNode.next;
        countNode.next.prev = countNode.prev;

        countNode.next = null;
        countNode.prev = null;
    }

    private void addCountNodeAtStart(CountNode countNode) {
        countNode.next = refStart.next;
        refStart.next.prev = countNode;
        countNode.prev = refStart;
        refStart.next = countNode;
    }

}
