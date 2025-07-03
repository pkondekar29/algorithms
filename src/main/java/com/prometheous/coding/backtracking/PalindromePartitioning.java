package com.prometheous.coding.backtracking;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<List<String>>> memo = new HashMap<>();
        solve(s, res, memo);
        return res;
    }

    private List<List<String>> solve(String s, List<List<String>> res, Map<String, List<List<String>>> memo) {
        if(memo.containsKey(s)) return memo.get(s);
        if(s.length() == 1) return List.of(List.of(s));

        List<List<String>> responses = new ArrayList<>();
        for(int i = 1; i < s.length(); i++) {
            List<String> splitRes = new ArrayList<>();
            String left = s.substring(0, i);
            String right = s.substring(i);
            if(isPalindrome(left) && isPalindrome(right)) {
                splitRes.add(left);
                splitRes.add(right);
            }
            solve(left, res, memo);
            solve(right, res, memo);
        }

        return null;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        PrinterUtils.print(new PalindromePartitioning().partition("aab"));
    }
}
