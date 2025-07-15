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

    // T = O(N3), S = O(N2)
    public int burstBaloonEff(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for(int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        int[][] memo = new int[n + 2][n + 2];
        return burst(memo, arr, 0, n + 1);
    }

    private int burst(int[][] memo, int[] arr, int left, int right) {
        if(left + 1 == right) return 0;
        if(memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for(int i = left + 1; i < right; ++i) {
            ans = Math.max(ans,
                    (arr[left] * arr[i] * arr[right]) + burst(memo, arr, left, i) + burst(memo, arr, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}
