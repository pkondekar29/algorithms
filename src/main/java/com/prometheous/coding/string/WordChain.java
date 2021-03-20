package com.prometheous.coding.string;

import java.util.Arrays;

/**
 *
 * There is a large number of magnetic plates on every door.
 * Every plate has one word written on it. The plates must be arranged into a sequence in such a way
 * that every word begins with the same letter as the previous word ends.
 *
 * For example, the word acm'' can be followed by the word motorola''.
 *
 * Your task is to write a computer program that will read the list of words and determine whether
 * it is possible to arrange all of the plates in a sequence (according to the given rule) and consequently to open the door.
 *
 */
public class WordChain {
    public static void main(String args[]) throws Exception {
        String[] words = new String[] {"am", "sas", "serq"};
        System.out.println(isPossible(words));
    }

    public static boolean isPossible(String[] words) {
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            if (DFS(words, i, -1, 0, visited)) return true;
        }
        return false;
    }

    private static boolean DFS(String[] words, int curr, int prev, int count, boolean[] visited) {
        if (curr >= words.length) return false;      // If curr over flows, return
        if (prev != -1 && words[prev].charAt(words[prev].length() - 1) != words[curr].charAt(0))
            return false;     /// Return if the characters mismatch

        visited[curr] = true;
        if (count == words.length - 1) return true;

        boolean possible = false;
        for (int i = 0; i < words.length; i++) {
            if(!visited[i])
                possible = possible || DFS(words, i, curr, count + 1, visited);
            if (possible) return true;
        }
        visited[curr] = false;
        return false;
    }

}
