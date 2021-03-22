package com.prometheous.coding.string;

public class LongestCommonSubsequence {

    static int[][] dp;
    public static void main(String[] args) {
        String s1 = "adebcfhg";
        String s2 = "defg";
        System.out.println(findLongestCommonSubsequence(s1, s2));
        System.out.println(findLCS(s1, s2, 8, 4));
    }

    private static int findLongestCommonSubsequence(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= s2.length(); j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private static String findLCS(String s1, String s2, int i, int j) {
        if(i == 0 || j == 0)
            return "";
        if(s1.charAt(i - 1) == s2.charAt(j - 1))
            return findLCS(s1, s2, i - 1, j - 1) + s1.charAt(i - 1);

        if(dp[i - 1][j] > dp[i][j - 1]) return findLCS(s1, s2, i - 1, j);
        else return findLCS(s1, s2, i, j - 1);
    }

}
