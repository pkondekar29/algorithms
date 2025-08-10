package com.prometheous.coding.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap {

   private LinkedHashMap<Integer, Integer> cache;
   private final int CAPACITY;

   public LRUCacheUsingLinkedHashMap(int capacity) {

      this.CAPACITY = capacity;
      cache = new LinkedHashMap<>(capacity, 0.75f, true) {

         @Override
         protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > CAPACITY;
         }

      };
   }

   public int get(int key) {

      return cache.getOrDefault(key, -1);
   }

   public void put(int key, int value) {

      cache.put(key, value);
   }
}
