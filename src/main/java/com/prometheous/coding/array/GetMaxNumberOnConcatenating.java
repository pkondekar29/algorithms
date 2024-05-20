package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Arrays;
import java.util.Comparator;

public class GetMaxNumberOnConcatenating {
   public static void main(String[] args) {

      int[] a = new int[] { 54, 546, 548, 60 };
      PrinterUtils.print(findLargestNumber(a));
   }

   private static final String ZERO = "0";
   private static final Character ZERO_C = '0';

   public static String findLargestNumber(int[] nums) {

      StringBuilder sb = new StringBuilder();
      String[] strs = new String[nums.length];
      Comparator<String> stringComparator = (str1, str2) -> {
         String s1 = str1 + str2;
         String s2 = str2 + str1;
         return (s1.compareTo(s2) > 0) ? -1 : 1;
      };
      for (int i = 0; i < nums.length; i++) {
         strs[i] = String.valueOf(nums[i]);
      }
      Arrays.sort(strs, stringComparator);
      if (strs[0].charAt(0) == ZERO_C) {
         return ZERO;
      }
      for (String str : strs) {
         sb.append(str);
      }
      return sb.toString();
   }
}
