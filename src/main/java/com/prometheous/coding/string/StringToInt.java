package com.prometheous.coding.string;

import java.util.HashMap;
import java.util.Scanner;

public class StringToInt {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println(StringToInt.stringToInt(sc.next()));
   }

   static HashMap<Character, Integer> map = new HashMap() {{
      put('0', 0);
      put('1', 1);
      put('2', 2);
      put('3', 3);
      put('4', 4);
      put('5', 5);
      put('6', 6);
      put('7', 7);
      put('8', 8);
      put('9', 9);

   }};

   public static int stringToInt(String s) {

      int i = 0;
      // trim
      while (i < s.length() && s.charAt(i) == ' ') {
         i++;
      }
      boolean negative = false;
      if (i < s.length()) {
         if (s.charAt(i) == '-') {
            negative = true;
            i++;
         } else if (s.charAt(i) == '+') {
            i++;
         }
         if (i == s.length()) {
            return 0;
         }
         // +- check
         if (!map.containsKey(s.charAt(i))) {
            return 0;
         }
         long b = 0;
         while (i < s.length() && map.containsKey(s.charAt(i))) {
            b = (b * 10) + map.get(s.charAt(i));
            if (b > Integer.MAX_VALUE) {
               return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
         }
         return negative ? (int) (-b) : (int) b;
      } else {
         return 0;
      }
   }

}
