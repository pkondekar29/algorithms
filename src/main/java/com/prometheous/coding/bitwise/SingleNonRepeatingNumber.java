package com.prometheous.coding.bitwise;

public class SingleNonRepeatingNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
}
