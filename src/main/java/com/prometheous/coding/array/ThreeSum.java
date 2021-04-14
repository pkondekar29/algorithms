package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {
        find3Sums(new int[]{1,2,3,0})
            .stream()
            .map(list -> list.stream().map(Object::toString).collect(Collectors.joining(", ")))
            .forEach(System.out::println);
    }

    private static List<List<Integer>> find3Sums(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int sum = - nums[i];
            int low = i + 1, high = nums.length - 1;

            while(low < high) {
                if(nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[low], nums[high], -sum));
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    low++;
                    while(low < high && nums[high] == nums[high - 1]) high--;
                    high--;
                }
                else if(nums[low] + nums[high] < sum) {
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    low++;
                } else {
                    while(low < high && nums[high] == nums[high - 1]) high--;
                    high--;
                }
            }
        }
        return res;
    }

}
