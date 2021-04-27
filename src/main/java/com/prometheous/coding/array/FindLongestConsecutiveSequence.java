package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.HashSet;

public class FindLongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,100,111,4,0,-1,345};
        PrinterUtils.print(findLongestConsecutiveSeq(nums));
    }

    public static int findLongestConsecutiveSeq(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int max = 0;
        while (!set.isEmpty()) {
            // Take any number and keep checking for consecutive numbers.
            Integer seed = set.iterator().next();
            int count = 0, left = seed - 1, right = seed;
            // Since remove is also O(1) in HashSet. The solution becomes O(n)
            while (set.remove(left--)) count++;
            while (set.remove(right++)) count++;
            max = Math.max(count, max);
        }
        return max;
    }

}