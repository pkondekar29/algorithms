package com.prometheous.coding.string;

import com.prometheous.coding.utils.PrinterUtils;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findPalindromicSubString("abaabcasge"));
        System.out.println(findLongestPalindromicSubstring("babac"));
    }

    private static String findPalindromicSubString(String str) {
        int max = 1, d = -1;
        for(int i = 0; i < str.length(); i++) {
            int l = i, j = 1;
            while(l+j < str.length() && l-j >= 0 && str.charAt(l+j) == str.charAt(l-j)) {
                j++;
            }
            if(2*j - 1 > max) {
                max = 2*j - 1;
                d = i;
            }

            int k = i + 1;
            j = 0;
            l = i;

            while(j < str.length()/2 && l - j >= 0 && k + j < str.length() && str.charAt(l - j) == str.charAt(k + j)) {
                j++;
            }
            if((j*2) > max) {
                max = j*2;
                d = i;
            }
        }
        if(max % 2 == 1) return str.substring(d - (max/2), d + (max/2) + 1);
        else return str.substring(d - (max/2) + 1, d + (max/2) + 1);
    }

    private static String findLongestPalindromicSubstring(String str) {
        int max = 1, n = str.length(), pos = 1;
        for(int i = 0; i < n; i++) {

            int p = i - 1, q = i + 1;
            boolean taken = false;
            while(p >= 0 && q < n && str.charAt(p) == str.charAt(q)) {
                p--;
                q++;
                taken = true;
            }

            if(taken && i - p + q - i > max) {
                max = i - p + q - i;
                pos = i;
            }

            taken = false;
            p = i; q = i + 1;
            while(p >= 0 && q < n && str.charAt(p) == str.charAt(q)) {
                p--;
                q++;
                taken = true;
            }

            if(taken && i - p + q - i > max) {
                max = i - p + q - i;
                pos = i;
            }
        }
        if(max == 1) {
            return str.substring(0, 1);
        }
        if(max % 2 == 1) return str.substring(pos - (max/2), pos + (max/2) + 1);
        else return str.substring(pos - (max/2) + 1, pos + (max/2) + 1);
    }
}
