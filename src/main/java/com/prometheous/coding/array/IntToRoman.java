package com.prometheous.coding.array;

public class IntToRoman {

   public static void main(String[] args) {

      System.out.println(toRoman(2589));
   }

   public static String toRoman(int num) {

      String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
      int[] ints = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

      StringBuilder sb = new StringBuilder();
      int i = 0;
      while (num > 0) {
         while (num >= ints[i]) {
            num -= ints[i];
            sb.append(romans[i]);
         }
         i++;
      }
      return sb.toString();
   }

}
