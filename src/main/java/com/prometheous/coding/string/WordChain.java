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
    }

    private static boolean isPossible(String[] words) {
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            if (DFS(words, i, 0, visited)) return true;
        }
        return false;
    }

    private static boolean DFS(String[] words, int curr, int prev, boolean[] visited) {
        if (curr >= words.length) return false;      // If curr over flows, return
        if (words[prev].charAt(words[prev].length() - 1) != words[curr].charAt(0))
            return false;     /// Return if the characters mismatch

        visited[curr] = true;
        if (allVisited(visited)) return true;

        boolean possible = false;
        for (int i = 0; i < words.length; i++) {
            possible = possible || DFS(words, i, curr, visited);
            if (possible) return true;
        }
        visited[curr] = false;
        return possible;
    }

    private static boolean allVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

}
