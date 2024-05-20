package com.prometheous.coding.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubStringConcatenation {

   static List<Integer> findSubstring(String s, String[] words) {

      List<Integer> l = new ArrayList<>();

      int wc = words.length, wl = words[0].length(), n = s.length();
      boolean[] matched = new boolean[wc];
      for (int i = 0; i <= n - (wc * wl); i++) {
         Arrays.fill(matched, false);
         for (int j = i; j < i + (wc * wl); j = j + wl) {
            String subStr = s.substring(j, j + wl);
            for (int k = 0; k < wc; k++) {
               if (!matched[k] && words[k].equals(subStr)) {
                  matched[k] = true;
                  break;
               }
            }
         }

         boolean allMatched = true;
         for (int k = 0; k < wc; k++) {
            allMatched = allMatched & matched[k];
         }
         if (allMatched) {
            l.add(i);
         }
      }

      return l;
   }

   static List<Integer> findSubstring2(String s, String[] words) {

      List<Integer> l = new ArrayList<>();
      int wc = words.length, wl = words[0].length(), n = s.length();
      HashMap<String, Integer> map = new HashMap<>();

      for (String str : words) {
         map.put(str, map.getOrDefault(str, 0) + 1);
      }

      for (int i = 0; i <= n - (wc * wl); i++) {
         HashMap<String, Integer> tempMap = new HashMap<>(map);
         for (int j = i; j < i + (wc * wl); j = j + wl) {
            String subStr = s.substring(j, j + wl);
            tempMap.computeIfPresent(subStr, (k, v) -> v - 1);
         }
         Long nm = tempMap.entrySet().stream().filter(e -> e.getValue() > 0).collect(Collectors.counting());
         if (nm == 0) {
            l.add(i);
         }
      }

      return l;
   }

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      int n = sc.nextInt();
      String[] words = new String[n];
      for (int i = 0; i < n; i++) {
         words[i] = sc.next();
      }
      sc.close();
      List<Integer> l = findSubstring2(s, words);
      for (Integer i : l) {
         System.out.print(i + "");
      }
   }

}