package com.prometheous.coding.string;

public class InterleavingString {

    public static void main(String[] args) {
        System.out.println(isInterLeaveMemo("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterLeave(String s1, String s2, String s3) {
        if(s1.equals("") && s2.equals(s3)) return true;
        if(s2.equals("") && s1.equals(s3)) return true;
        if(s1.length() + s2.length() != s3.length()) return false;
        return check(s1, s2, s3, 0, 0, 0);
    }

    private static boolean check(String s1, String s2, String s3, int i, int j, int k) {
        boolean possible = false;
        if(i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k))
            possible = check(s1, s2, s3, i + 1, j, k + 1);
        if(!possible && j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k))
            possible = check(s1, s2, s3, i, j + 1, k + 1);

        if(i > s1.length() - 1 && j > s2.length() - 1 && k > s3.length() - 1)
            possible = true;
        return possible;
    }

    public static boolean isInterLeaveMemo(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] invalid = new boolean[s1.length() + 1][s2.length() + 1];
        return checkMemo(s1, s2, s3, 0, 0, 0, invalid);
    }

    private static boolean checkMemo(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == s3.length()) return true;
        boolean possible = (i < s1.length() && s1.charAt(i) == s3.charAt(k) && checkMemo(s1, s2, s3, i + 1, j, k + 1, invalid)) ||
                (j < s2.length() && s2.charAt(j) == s3.charAt(k) && checkMemo(s1, s2, s3, i, j + 1, k + 1, invalid));
        if(!possible)
            invalid[i][j] = true;
        return possible;
    }

    public static boolean isInterLeaveDP(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        return dp[s1.length() - 1][s2.length() - 1];
    }

}
