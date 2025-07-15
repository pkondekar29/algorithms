package com.prometheous.coding.dp;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) return 0;
        Map<String, Integer> hashMap = new HashMap<>();
        wordList.add(beginWord);
        for(int i = 0; i < wordList.size(); i++) {
            hashMap.put(wordList.get(i), i);
        }
        if(!hashMap.containsKey(endWord)) return 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {hashMap.get(beginWord), 0});
        int len = endWord.length();
        while(!q.isEmpty()) {
            int[] at = q.poll();
            String atWord = wordList.get(at[0]);
            int cost = at[1];

            if(atWord.equals(endWord)) return cost;

            for(int k = 0; k < len; k++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    if(atWord.charAt(k) != c) {
                        String nextWord = k == 0 ? c + atWord.substring(1, len) :
                                k == len - 1 ? atWord.substring(0, len - 1) + c :
                                        atWord.substring(0, k) + c + atWord.substring(k + 1, len);
                        if(hashMap.containsKey(nextWord)) {
                            q.offer(new int[]{hashMap.get(nextWord), cost+1});
                        }
                        System.out.println(nextWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.addAll(List.of("hot", "dot","dog","lot","log","cog"));
//        "hot","dot","dog","lot","log","cog"
        new WordLadder().ladderLength("hit", "cog", wordList);
    }
}