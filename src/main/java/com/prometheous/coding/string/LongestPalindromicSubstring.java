package com.prometheous.coding.string;

import com.prometheous.coding.utils.PrinterUtils;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findLongestPalindromicSubstring("babac"));
    }

    public static String findLongestPalindromicSubstring(String str) {
        int max = 1, n = str.length();
        int start = 0, end = 0;
        for(int i = 0; i < n; i++) {
            int p = i, q = i;
            while(p >= 0 && q < n && str.charAt(p) == str.charAt(q)) {
                p--;
                q++;
            }
            if(i - p + 1 + q - 1 - i > max) {
                max = i - p + q - i;
                start = p + 1; end = q;
            }
            p = i; q = i + 1;
            while(p >= 0 && q < n && str.charAt(p) == str.charAt(q)) {
                p--;
                q++;
            }
            if(i - p + 1 + q - 1 - i > max) {
                max = i - p + q - i;
                start = p + 1; end = q;
            }
        }
        return str.substring(start, end);
    }
}
