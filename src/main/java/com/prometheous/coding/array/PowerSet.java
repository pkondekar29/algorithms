package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        PrinterUtils.print(findSubsets(nums));
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, limit = (int) Math.pow(2, nums.length);
        while(i < limit) {
            LinkedList<Integer> currPermutation = new LinkedList<>();
            int curr = i;
            int k = nums.length - 1;
            while(curr > 0) {
                if(curr % 2 == 1) {
                    currPermutation.addFirst(nums[k]);
                }
                k--;
                curr = curr / 2;
            }
            res.add(currPermutation);
            i++;
        }
        return res;
    }
}
