package com.prometheous.coding.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithNonRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() < 2) return 1;

        int left = 0, n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("absabsabs"));
    }
}
