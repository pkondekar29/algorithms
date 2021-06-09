package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        PrinterUtils.print(new WordBreak().wordBreakMemo("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        PrinterUtils.printLine();
        PrinterUtils.print(new WordBreak().wordBreakDP("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        PrinterUtils.print(new WordBreak().wordBreakDP("leetcode", Arrays.asList("leet","code","sand","and","cat")));
    }

    public boolean wordBreakDP(String str, List<String> wordDict) {
        int length = str.length();
        boolean[] matches = new boolean[length + 1];
        matches[0] = true;

        for(int i = 0; i <= length; i++) {
            if(matches[i]) {
                for (String word : wordDict) {
                    if(i + 1 <= length && str.startsWith(word)){
                        matches[i + word.length()] = true;
                    }
                }
            }
        }
        PrinterUtils.print(matches);
        return matches[length];
    }

    public boolean wordBreakMemo(String str, List<String> wordDict) {
        Boolean[] memo = new Boolean[str.length()];
        return dfs(str, 0, wordDict, memo);
    }

    private boolean dfs(String str, int at, List<String> wordDict, Boolean[] memo) {
        if(at == str.length()) return true;
        if(memo[at] != null) return memo[at];

        boolean matches = false;
        for(String word : wordDict) {
            if(str.startsWith(word)) {
                matches = matches || dfs(str, at + word.length(), wordDict, memo);
            }
        }
        memo[at] = matches;
        return matches;
    }

}
