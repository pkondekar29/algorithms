package com.prometheous.coding.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BurstBaloon {

    public static void main(String[] args) {
        System.out.println(new BurstBaloon().maxCoins(new int[] {3,1,5,8}));
    }

    public int maxCoins(int[] nums) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        return burst(list, memo);
    }

    private int burst(List<Integer> nums, Map<List<Integer>, Integer> memo) {
        if(memo.containsKey(nums)) return memo.get(nums);

        int res = -1;
        for(int i = 0; i < nums.size(); i++) {

            int bursted = nums.get(i);
            if(i - 1 >= 0) bursted *= nums.get(i - 1);
            if(i + 1 < nums.size()) bursted *= nums.get(i + 1);

            List<Integer> after = new ArrayList<>();
            for(int k = 0; k < nums.size(); k++) {
                if(k != i) after.add(nums.get(k));
            }

            int afterMax = burst(after, memo);
            res = Math.max(res, bursted + afterMax);
            memo.put(after, afterMax);
        }

        return res;
    }
}
