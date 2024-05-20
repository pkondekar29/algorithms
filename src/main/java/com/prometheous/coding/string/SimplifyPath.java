package com.prometheous.coding.string;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println(simplify(sc.next()));
      sc.close();
   }

   public static String simplify(String path) {

      Stack<String> sc = new Stack<>();
      int i = 0;
      String curr = "";
      while (i < path.length()) {
         curr = "";
         while (i < path.length() && path.charAt(i) == '/') {
            i++;
            continue;
         }

         while (i < path.length() && path.charAt(i) != '/') {
            curr += path.charAt(i);
            i++;
         }

         if (curr.equals("/") || curr.equals(".") || curr.equals("")) {
            continue;
         } else {
            sc.push(curr);
         }
      }
      Stack<String> reversed = new Stack<>();
      int count = 0;
      while (!sc.empty()) {
         curr = sc.pop();
         if (curr.equals("..")) {     // Pop from stack
            count++;
         } else {
            if (count != 0) {
               count--;
            } else {
               reversed.push(curr);
            }
         }
      }
      if (reversed.isEmpty()) {
         return "/";
      }
      StringBuilder sb = new StringBuilder();
      while (!reversed.isEmpty()) {
         sb.append("/").append(reversed.pop());
      }
      return sb.toString();
   }

}
