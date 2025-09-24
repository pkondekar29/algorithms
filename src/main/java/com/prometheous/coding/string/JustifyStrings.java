package com.prometheous.coding.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JustifyStrings {

   public static void main(String[] args) {
      justifyEff(new String[] {"What","must","be","acknowle","shall","be"}, 16).forEach(System.out::println);
   }

   public static List<String> justifyEff(String[] words, int maxWidth) {
      List<String> res = new ArrayList<>();
      List<String> cur = new ArrayList<>();
      int numOfLetters = 0;

      for (String word : words) {
         if (word.length() + cur.size() + numOfLetters > maxWidth) {
            for (int i = 0; i < maxWidth - numOfLetters; i++) {
               cur.set(i % (cur.size() - 1 > 0 ? cur.size() - 1 : 1),
                       cur.get(i % (cur.size() - 1 > 0 ? cur.size() - 1 : 1)) + " ");
            }
            StringBuilder sb = new StringBuilder();
            for (String s : cur) sb.append(s);
            res.add(sb.toString());
            cur.clear();
            numOfLetters = 0;
         }
         cur.add(word);
         numOfLetters += word.length();
      }

      StringBuilder lastLine = new StringBuilder();
      for (int i = 0; i < cur.size(); i++) {
         lastLine.append(cur.get(i));
         if (i != cur.size() - 1) lastLine.append(" ");
      }
      while (lastLine.length() < maxWidth) lastLine.append(" ");
      res.add(lastLine.toString());

      return res;
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
