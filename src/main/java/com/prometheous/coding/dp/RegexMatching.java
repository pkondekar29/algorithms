package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

public class RegexMatching {

    private static final Character DOT = '.';
    private static final Character STAR = '*';

    public static void main(String[] args) {
        PrinterUtils.print(isMatch("ssippi", "s*p*."));
    }

    public static boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }

    public static boolean isMatchRec(String s, String p) {
        return isMatch(0,s,0,p);
    }

    private static boolean isMatch(int i, String s, int j, String p) {
        int sn = s.length(), pn = p.length();
        if(j==pn) { // since * in p can match 0 of previous char, so empty string(i==sn) may match p
            return i==sn;
        }
        char pj = p.charAt(j);
        if(j+1<pn && p.charAt(j+1)=='*') { //match *, needs to look at the next char to repeate current char
            if(isMatch(i,s,j+2,p)) {
                return true;
            }
            if(i<sn && (pj == '.'|| pj==s.charAt(i))) {
                if(isMatch(i+1,s,j,p)) {
                    return true;
                }
            }
        } else if(i<sn && (s.charAt(i) == pj ||    //match char
                pj=='.')) {              //match dot
            return isMatch(i+1, s, j+1, p);
        }
        return false;
    }

    public static boolean isMatchDP(String s, String p) {
        int sn = s.length(), pn = p.length();
        boolean[][] dp = new boolean[sn + 1][pn + 1];
        dp[sn][pn] = true;
        for (int i = sn; i >= 0; i--)
            for (int j = pn - 1; j >= 0; j--)
                if (j + 1 < pn && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                    if (i < sn && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
                        dp[i][j] |= dp[i + 1][j];
                } else if (i < sn && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
                    dp[i][j] = dp[i + 1][j + 1];
        return dp[0][0];
    }

    private static boolean dfs(String s, String p, int si, int pi) {
        if(si == s.length()) {
            if(pi == p.length()) {
                return true;
            } else if(pi < p.length() - 1 && p.charAt(pi) == DOT && p.charAt(pi + 1) == STAR) {
                return dfs(s, p, si, pi + 2);
            } else {
                return false;
            }
        }
        if(pi == p.length()) return false;
        if(!matches(s, p, si, pi)) return false;

        boolean matches = false;
        boolean isNextCharStar = isNextCharStar(p, pi);
        if(isNextCharStar) {

        } else {
            matches = dfs(s, p, si + 1, pi + 1);
        }
        return matches;
    }

    private static boolean isNextCharStar(String p, int pi) {
        if(pi < p.length() - 1 && p.charAt(pi + 1) == STAR) {
            return true;
        }
        return false;
    }

    private static boolean matches(String s, String p, int si, int pi) {
        if(p.charAt(pi) == s.charAt(si) || p.charAt(pi) == DOT) {
            return true;
        }
        return false;
    }

}