package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParentheses {

   public static void main(String[] args) {

      String str = ")(f";
      PrinterUtils.printList(removeInvalidParentheses(str));
   }

   public static List<String> removeInvalidParentheses(String s) {

      List<String> res = new ArrayList<>();
      HashSet<String> checked = new HashSet<>();
      Queue<String> queue = new LinkedList<>();

      queue.add(s);
      checked.add(s);
      boolean found = false;
      while (!queue.isEmpty()) {
         String polled = queue.poll();
         if (isValidParenthesis(polled)) {
            res.add(polled);
            found = true;
         } else if (!found) {
            for (int i = 0; i < polled.length(); i++) {
               if (isAlphaNumeric(polled.charAt(i)))
                  continue;

               String removedCharString = polled.substring(0, i) + polled.substring(i + 1);
               if (!checked.contains(removedCharString)) {
                  queue.add(removedCharString);
                  checked.add(removedCharString);
               }
            }
         }
      }
      return res;
   }

   public static boolean isValidParenthesis(String str) {

      int count = 0;
      for (int i = 0; i < str.length(); i++) {
         if (isAlphaNumeric(str.charAt(i)))
            continue;

         if (str.charAt(i) == '(')
            count++;
         else if (str.charAt(i) == ')')
            count--;
         if (count < 0)
            return false;
      }
      return count == 0;
   }

   private static boolean isAlphaNumeric(Character c) {

      return Character.isAlphabetic(c) || Character.isDigit(c);
   }
}
