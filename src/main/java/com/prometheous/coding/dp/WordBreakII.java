package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WordBreakII {

   public static void main(String[] args) {
      //        PrinterUtils.printList(new WordBreakII().wordBreakDP("catsanddog", Arrays.asList("cat","cats","and",
      //        "sand","dog")));
      PrinterUtils.printList(
            new WordBreakII().wordBreakMemo("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
   }

   public List<String> wordBreakDP(String str, List<String> wordDict) {

      int n = str.length();
      List<String>[] dp = new ArrayList[n + 1];
      dp[0] = new ArrayList<>();
      dp[0].add("");

      for (int i = 0; i <= n; i++) {
         if (dp[i] != null) { // We can make some sentence till here
            for (String word : wordDict) {
               int nextPotentialMatchIndex = i + word.length();

               if (nextPotentialMatchIndex <= n && str.indexOf(word, i) == i) {
                  dp[nextPotentialMatchIndex] =
                        dp[nextPotentialMatchIndex] == null ? new ArrayList<>() : dp[nextPotentialMatchIndex];

                  dp[nextPotentialMatchIndex].addAll(dp[i]);
                  dp[nextPotentialMatchIndex] = dp[nextPotentialMatchIndex].stream().map(s -> s + " " + word)
                        .collect(Collectors.toList());
               }
            }
         }
      }
      for (List<String> l : dp)
         if (l != null)
            PrinterUtils.printList(l);
      return dp[n];
   }

   public List<String> wordBreakMemo(String str, List<String> wordDict) {

      HashMap<Integer, List<String>> memo = new HashMap<>();
      return dfs(str, wordDict, 0, memo);
   }

   private List<String> dfs(String str, List<String> wordDict, int at, HashMap<Integer, List<String>> memo) {

      if (at > str.length())
         return null;
      if (at == str.length()) {
         List<String> dummyList = new ArrayList<>();
         dummyList.add("");
         return dummyList;
      }
      if (memo.containsKey(at))
         return memo.get(at);

      List<String> sentencesAtThisPoint = new ArrayList<>();
      for (String word : wordDict) {
         if (str.startsWith(word, at)) {   // We can match the current word at index at
            List<String> possibleSentences = dfs(str, wordDict, at + word.length(), memo);
            if (possibleSentences != null && possibleSentences.size() > 0) {
               for (String possibleSentenceAfterThis : possibleSentences) {
                  String possibleSentence =
                        possibleSentenceAfterThis.length() == 0 ? word : word + " " + possibleSentenceAfterThis;
                  sentencesAtThisPoint.add(possibleSentence);
               }
            }
         }
      }
      memo.put(at, sentencesAtThisPoint);
      return sentencesAtThisPoint;
   }

   public List<String> wordBreakMemoConcise(String str, List<String> wordDict) {

      HashMap<String, List<String>> memo = new HashMap<>();
      return dfsEff(str, wordDict, memo);
   }

   private List<String> dfsEff(String str, List<String> wordDict, HashMap<String, List<String>> memo) {

      if (memo.containsKey(str))
         return memo.get(str);

      List<String> result = new ArrayList<>();
      for (String word : wordDict)
         if (str.startsWith(word)) {
            String next = str.substring(word.length());
            if (next.length() == 0)
               result.add(word);
            else {
               List<String> possibleSentences = dfsEff(next, wordDict, memo);
               for (String sentence : possibleSentences)
                  result.add(word + " " + sentence);
            }
         }
      memo.put(str, result);
      return result;
   }

}
