package com.prometheous.coding.design.driver;

import com.prometheous.coding.design.LRUCache;
import com.prometheous.coding.utils.PrinterUtils;

public class LRUCacheDriver {

   public static void main(String[] args) {

      LRUCache cache = new LRUCache(2);
      cache.put(1, 1);
      PrinterUtils.print(cache.get(1));
      PrinterUtils.print(cache.get(2));
      cache.put(3, 3);
      cache.put(2, 2);
      PrinterUtils.print(cache.get(2));
      PrinterUtils.print(cache.get(1));
      PrinterUtils.print(cache.get(3));
      cache.put(4, 4);
      PrinterUtils.print(cache.get(4));
   }

}
