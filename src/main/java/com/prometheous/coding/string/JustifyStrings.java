package com.prometheous.coding.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JustifyStrings {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      String[] input = new String[n];
      for (int i = 0; i < n; i++)
         input[i] = sc.next();

      int max = sc.nextInt();
      justify(input, max).forEach(System.out::println);
   }

   public static List<String> justify(String[] words, int maxWidth) {

      List<String> justified = new ArrayList<>();

      int i = 0;
      final String SPACE = "_";
      while (i < words.length) {

         int wc = 0, li = 0, starti = i, ll = 0;
         while (words[li].length() + ll + 1 < maxWidth) {
            ll += words[li].length();
            wc++;
            li++;
            i++;
         }
         ll += wc;
         if (li + words[li].length() == maxWidth) {
            i++;
            ll += words[li].length();
            li++;
            wc++;
            StringBuilder sb = new StringBuilder();
            for (int k = starti; k < starti + wc - 1; k++) {
               sb.append(words[k]).append(SPACE);
            }
            sb.append(words[li]);
            justified.add(sb.toString());
         } else {

         }

      }

      return justified;
   }

}
