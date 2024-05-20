package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

   public static void main(String[] args) {

      String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
      groupAnagramsEff(strs).stream().map(list -> list.stream().collect(Collectors.joining(",")))
            .forEach(System.out::println);
   }

   public static List<List<String>> groupAnagramsEff(String[] strs) {

      HashMap<String, List<String>> hash = new HashMap<>();
      for (String str : strs) {
         char[] chars = str.toCharArray();
         Arrays.sort(chars);
         String sortedStr = new String(chars);
         hash.putIfAbsent(sortedStr, new ArrayList<>());
         hash.get(sortedStr).add(str);
      }
      List<List<String>> res = new ArrayList<>(hash.values());
      return res;
   }

   public static List<List<String>> groupAnagramsSlow(String[] strs) {

      int[][] hist = new int[strs.length][27];
      for (int i = 0; i < strs.length; i++) {
         for (int j = 0; j < strs[i].length(); j++) {
            hist[i][strs[i].charAt(j) - 'a']++;
         }
      }
      List<List<String>> res = new ArrayList<>();
      for (int i = 0; i < strs.length; i++) {
         if (hist[i][26] == 1)
            continue;

         List<String> anagramGroup = new ArrayList<>();
         anagramGroup.add(strs[i]);
         for (int j = i + 1; j < strs.length; j++) {
            if (hist[j][26] == 0) {
               if (areAnagrams(strs[i], strs[j], i, j, hist)) {
                  anagramGroup.add(strs[j]);
                  hist[j][26] = 1;
               }
            }
         }
         res.add(anagramGroup);
         hist[i][26] = 1;
      }
      return res;
   }

   private static boolean areAnagrams(String s1, String s2, int i, int j, int[][] hist) {

      if (s1.length() != s2.length())
         return false;
      for (int k = 0; k < s1.length(); k++) {
         if (hist[i][s1.charAt(k) - 'a'] != hist[j][s2.charAt(k) - 'a'])
            return false;
      }
      return true;
   }

}
