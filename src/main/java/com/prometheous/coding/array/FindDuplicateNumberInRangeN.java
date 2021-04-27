package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class FindDuplicateNumberInRangeN {

    public static void main(String[] args) {
        int[] nums = new int[] {};
        PrinterUtils.print(findDuplicateNumberInRangeN(nums));
    }

    // TODO => Correct it
    public static int findDuplicateNumberInRangeN(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0) {
                nums[num] = - nums[num];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return Math.abs(nums[nums[i]]);
            }
        }
        return 0;
    }

}
