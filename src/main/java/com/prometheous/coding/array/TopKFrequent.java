package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        PrinterUtils.printList(topKFrequent(nums, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> - Integer.compare(e1.getValue(), e2.getValue()));
        minHeap.addAll(countMap.entrySet());

        List<Integer> res = new ArrayList<>();
        while(res.size() < k) {
            res.add(minHeap.poll().getKey());
        }
        return res;
    }
}