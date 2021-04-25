package com.prometheous.coding.string;

public class IsPalindrome {

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

}
