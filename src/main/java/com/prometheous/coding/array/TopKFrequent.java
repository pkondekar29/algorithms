package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        PrinterUtils.print(topKFrequent(nums, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int[] res = new int[k];
        int prev = Integer.MIN_VALUE;
        int i = 0;
        while(i < k && !pq.isEmpty()) {
            int curr = pq.poll();
            if(curr != prev) {
                res[i] = curr;
                i++;
            }
            prev = curr;
        }
        return res;
    }


}
