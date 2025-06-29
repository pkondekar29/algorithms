package com.prometheous.coding.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

   class Node {
      public int key;
      public int value;
      public Node prev;
      public Node next;
      public Node(int key, int value) {
         this.key = key;
         this.value = value;
      }
   }

   Map<Integer, Node> map;
   Node first, last;
   int size;

   public LRUCache(int capacity) {
      first = new Node(-1, -1);
      last = new Node(-1, -1);
      first.next = last;
      last.prev = first;
      map = new HashMap<>();
      this.size = capacity;
   }

   public int get(int key) {
      // Get the value from map
      int res = -1;
      if(map.containsKey(key)) {
         Node node = map.get(key);
         // Update the recency of node in LL
         removeNode(node);
         addFront(node);
      }
      return res;
   }

   public void put(int key, int value) {
      // Put the value in map
      Node node = null;
      if(map.containsKey(key)) {
         node = map.get(key);
         node.value = value;
      } else {
         node = new Node(key, value);
         map.put(key, node);
      }
      removeNode(node);
      addFront(node);

      if(map.size() > size) {
         Node leastRecentlyUsed = last.prev;
         if(leastRecentlyUsed != null) {
            removeNode(leastRecentlyUsed);
            map.remove(leastRecentlyUsed.key);
         }
      }
   }

   private void removeNode(Node node) {
      if(node.prev != null) {
         node.prev.next = node.next;
      }
      if(node.next != null) {
         node.next.prev = node.prev;
      }
      node.next = null;
      node.prev = null;
   }

   private void addFront(Node node) {
      Node next = first.next;
      first.next = node;
      node.next = next;
      node.prev = first;
      if(next != null) {
         next.prev = node;
      }
   }

}