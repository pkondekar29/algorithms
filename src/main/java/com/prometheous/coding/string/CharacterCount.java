package com.prometheous.coding.string;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {

   public static void main(String[] args) {

      String str = "    ";
      findCharCount(str).entrySet().stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
   }

   private static Map<Character, Integer> findCharCount(String str) {

      Map<Character, Integer> charCount = new HashMap<>();

      for (int i = 0; i < str.length(); i++) {
         Character character = str.charAt(i);
         if (charCount.containsKey(character)) {
            Integer count = charCount.getOrDefault(character, 1);
            count++;
            charCount.put(character, count);
         } else {
            charCount.put(character, 1);
         }
      }
      return charCount;
   }

}
