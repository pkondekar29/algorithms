package com.prometheous.coding.string;

import java.util.Arrays;
import java.util.HashSet;

public class MinWindowSubString {

   public static void main(String[] args) {

      System.out.println(minWindow("ADOBECODEBANC", "ABC"));
   }

   public static String minWindow(String s, String t) {

      HashSet<Character> set = new HashSet<>();
      for (int i = 0; i < t.length(); i++) {
         set.add(t.charAt(i));
      }
      String minStr = "";
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < s.length(); i++) {
         for (int j = i; j < s.length(); j++) {

            String subStr = s.substring(i, j);
            boolean present = Arrays.asList(subStr.toCharArray()).containsAll(set);

            if (present && subStr.length() < min) {
               min = subStr.length();
               minStr = subStr;
            }
         }
      }
      return minStr;
   }

}
