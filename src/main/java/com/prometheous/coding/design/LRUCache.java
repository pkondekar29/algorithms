package com.prometheous.coding.design;

import java.util.HashMap;

public class LRUCache {

   class Node {
      int key;
      int value;
      Node prev;
      Node next;

      Node() {

      }
   }

   final Node first = new Node(), last = new Node();
   final HashMap<Integer, Node> cache;
   final int capacity;

   public LRUCache(int capacity) {

      cache = new HashMap<>(capacity);
      this.capacity = capacity;
      first.next = last;
      last.prev = first;
   }

   public int get(int key) {

      if (cache.size() == 0 || !cache.containsKey(key))
         return -1;

      Node node = cache.get(key);
      remove(node);
      addFront(node);

      return node.value;
   }

   public void put(int key, int value) {

      Node node;
      if (cache.containsKey(key)) {
         node = cache.get(key);
         remove(node);       // Remove node from LL
         node.value = value; // Update the node
      } else {
         if (cache.size() == capacity) {
            cache.remove(last.prev.key);    // Remove the last node from cache
            remove(last.prev);              // Remove last node from LL
         }
         node = new Node();
         node.key = key;
         node.value = value;

         cache.put(key, node);
      }
      addFront(node);     // Finally add in front
   }

   private void addFront(Node node) {

      Node firstNode = first.next;
      first.next = node;
      node.prev = first;
      node.next = firstNode;
      firstNode.prev = node;
   }

   private void remove(Node node) {

      Node nextNode = node.next;
      Node prevNode = node.prev;

      nextNode.prev = prevNode;
      prevNode.next = nextNode;
   }

}