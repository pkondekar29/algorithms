package com.prometheous.coding.design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class TimeMap {
    private Map<String, ConcurrentNavigableMap<Integer, String>> map;

    public TimeMap() {
        map = new ConcurrentHashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ConcurrentSkipListMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        ConcurrentNavigableMap<Integer, String> timeValueMap = map.get(key);
        Map.Entry<Integer, String> timestampPrev = timeValueMap.floorEntry(timestamp);
        return timestampPrev == null ? "" : timeValueMap.firstEntry().getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */