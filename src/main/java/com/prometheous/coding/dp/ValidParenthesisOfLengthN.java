package com.prometheous.coding.dp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ValidParenthesisOfLengthN {

   public static void main(String[] args) {
      //        System.out.println("()".substring(0, 0) + "()" + "()".substring(0));
      generateParenthesis(4).forEach(System.out::println);
   }

   static HashSet<String>[] dp = new HashSet[8];
   static String valid = "()";

   static {
      dp[0] = new HashSet<>();
      dp[0].add(valid);

      for (int i = 1; i < 8; i++) {
         HashSet<String> prevCombinations = dp[i - 1];

         HashSet<String> combinations = new HashSet<>();
         Iterator<String> itr = prevCombinations.iterator();
         while (itr.hasNext()) {
            String prevCombination = itr.next();
            for (int j = 0; j < prevCombination.length(); j++) {
               String newCombination = prevCombination.substring(0, j) + valid + prevCombination.substring(j);
               System.out.println(i + " " + j + " " + newCombination);
               combinations.add(newCombination);
            }
         }
         dp[i] = combinations;
      }
   }

   public static List<String> generateParenthesis(int n) {

      return dp[n - 1].stream().collect(Collectors.toList());
   }

}
