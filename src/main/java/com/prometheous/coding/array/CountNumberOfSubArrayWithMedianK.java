package com.prometheous.coding.array;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubArrayWithMedianK {

    public int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int windowSum = 0, res = 0;
        boolean found = false;
        for(int num : nums) {
            if(num > k) {
                windowSum++;
            } else if(num < k) {
                windowSum--;
            } else {
                found = true;
            }
            if(found) {
                res += prefixSum.getOrDefault(windowSum, 0)
                        + prefixSum.getOrDefault(windowSum - 1, 0);
            } else {
                prefixSum.put(windowSum, prefixSum.getOrDefault(windowSum, 0) + 1);
            }
        }
        return res;
    }
}
