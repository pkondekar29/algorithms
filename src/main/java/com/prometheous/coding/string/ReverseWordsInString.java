package com.prometheous.coding.string;

public class ReverseWordsInString {

   public static void main(String[] args) {

      System.out.println(reverse("a good   example"));
   }

   private static String reverse(String s) {

      final String SPACE = " ";
      String BLANK = "";
      String[] words = s.trim().split(SPACE);
      StringBuilder sb = new StringBuilder();
      for (int i = words.length - 1; i > 0; i--) {
         if (!words[i].equals(BLANK))
            sb.append(words[i]).append(SPACE);
      }
      if (!words[0].equals(BLANK))
         sb.append(words[0]);
      return sb.toString();
   }
}
