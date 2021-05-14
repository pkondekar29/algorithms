package com.prometheous.coding.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeToBuild {

    public static void main(String[] args) {
        System.out.print(findLongestPalindromeCanBuild("abccccdd"));
    }

    /**
     * We can also keep a HashSet to check for pairs characters. And in 1 loops we can solve it.
     *
     * @param s
     * @return
     */
    private static int findLongestPalindromeCanBuild(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        boolean allEven = true;
        int sum = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer count = characterIntegerEntry.getValue();
            if (count % 2 == 1) allEven = false;
            sum += 2 * (count / 2);
        }
        if(allEven) return sum;
        else return sum + 1;
    }

}
