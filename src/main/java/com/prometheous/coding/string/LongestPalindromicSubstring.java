package com.prometheous.coding.string;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findPalindromicSubString("abaabcasge"));
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


}
