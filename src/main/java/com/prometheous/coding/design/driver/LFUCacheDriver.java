package com.prometheous.coding.design.driver;

import com.prometheous.coding.design.LFUCache;
import com.prometheous.coding.utils.PrinterUtils;

public class LFUCacheDriver {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        PrinterUtils.print(cache.get(1));
//        cache.put(3,3);
//        PrinterUtils.print(cache.get(2));
//        PrinterUtils.print(cache.get(3));
//        cache.put(4,4);
//        PrinterUtils.print(cache.get(1));
//        PrinterUtils.print(cache.get(3));
//        PrinterUtils.print(cache.get(4));

        cache.put(3,1);
        cache.put(2,1);
        cache.put(2,2);
        cache.put(4,4);
        PrinterUtils.print(cache.get(2));
    }

}
