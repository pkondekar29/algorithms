package com.prometheous.coding.dp;

import java.util.HashMap;

public class DecodeWays {

    public static void main(String[] args) {
        String str = "12519";
        System.out.println(findWaysToDecodeString(str));
        System.out.println(findWaysToDecodeStringMemo(str));
        System.out.println(findWaysToDecodeStringDP(str));
        System.out.println(findWaysToDecodeStringDPConstantSpace(str));
    }

    public static int findWaysToDecodeString(String str) {
        return str.length() == 0 ? 0 : findWaysToDecodeString(str, 0);
    }

    private static int findWaysToDecodeString(String str, int k) {
        int n = str.length();
        if(k == n) return 1;
        if(str.charAt(k) == '0') return 0;
        // 1-digit code
        int count = findWaysToDecodeString(str, k + 1);
        // 2-digit code
        if(k < n - 1 && (str.charAt(k) == '1' || str.charAt(k) == '2' && str.charAt(k + 1) < '7'))
            count += findWaysToDecodeString(str, k + 2);
        return count;
    }

    public static int findWaysToDecodeStringMemo(String str) {
        return str.length() == 0 ? 0 : findWaysToDecodeStringMemo(str, 0, new HashMap<Integer, Integer>());
    }

    private static int findWaysToDecodeStringMemo(String str, int k, HashMap<Integer, Integer> memo) {
        int n = str.length();
        if(k == n) return 1;
        if(str.charAt(k) == '0') return 0;
        if(memo.containsKey(k)) return memo.get(k);
        // 1-digit code
        int count = findWaysToDecodeStringMemo(str, k + 1, memo);
        // 2-digit code
        if(k < n - 1 && (str.charAt(k) == '1' || str.charAt(k) == '2' && str.charAt(k + 1) < '7'))
            count += findWaysToDecodeStringMemo(str, k + 2, memo);
        memo.put(k, count);
        return count;
    }

    public static int findWaysToDecodeStringDP(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--)
            if(str.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (str.charAt(i) == '1' || str.charAt(i) == '2' && str.charAt(i + 1) < '7'))
                    dp[i] += dp[i + 2];
            }
        return dp[0];
    }

    public static int findWaysToDecodeStringDPConstantSpace(String str) {
        int n = str.length();
        int dp1 = 1, dp2 = 0, dp = 0;
        for(int i = n - 1; i >= 0; i--) {
            dp = str.charAt(i) != '0' ? dp1 : 0;
            if (i < n - 1 && (str.charAt(i) == '1' || str.charAt(i) == '2' && str.charAt(i + 1) < '7')) {
                dp += dp2;
            }
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }

}
