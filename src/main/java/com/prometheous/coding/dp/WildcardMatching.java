package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class WildcardMatching {

    public static void main(String[] args) {
        PrinterUtils.print(isMatch("aa", "a"));
    }

    public static boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()][p.length()];
        return dfs(s, p, 0, 0, memo);
    }

    public static boolean isMatchDP(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;    // Empty string matches with empty pattern

        return dp[m][n];
    }

    // T = O(m + n), S = O(m + n)
    private static boolean dfs(String s, String p, int i, int j, Boolean[][] memo) {
        if(i == s.length()) {
            if(j == p.length()) return true;

            if(p.charAt(j) == '*')
                return dfs(s, p, i, j + 1, memo);
            else
                return false;
        }
        if(j == p.length()) return false;
        if(memo[i][j] != null) return memo[i][j];

        boolean isMatch;
        if(p.charAt(j) == '?')
            isMatch = dfs(s, p, i + 1, j + 1, memo);
        else if(p.charAt(j) == '*')
            isMatch = dfs(s, p, i, j + 1, memo)     // ignoring * match. Matching with no char
                    || dfs(s, p, i + 1, j, memo)    // * matching with next char
                    || dfs(s, p, i + 1, j + 1, memo);   // next char match
        else
            isMatch = s.charAt(i) == p.charAt(j) && dfs(s, p, i + 1, j + 1, memo);
        memo[i][j] = isMatch;
        return memo[i][j];
    }

}
