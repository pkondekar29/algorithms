package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticProgressionWithGivenDifference {

    public static void main(String[] args) {
        PrinterUtils.print(new LongestArithmeticProgressionWithGivenDifference()
                .longestArithmeticProgression(new int[] {1,2,3,4,5,6,7,8}, 2));
    }

    public int longestArithmeticProgression(int[] nums, int diff) {
        Map<Integer, Integer> dp = new HashMap<>();
        int res = 1;
        for (int n : nums) {
            dp.put(n, dp.getOrDefault(n - diff, 0) + 1);
            res = Math.max(res, dp.get(n));
        }
        return res;
    }

}
