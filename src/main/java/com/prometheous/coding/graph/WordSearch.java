package com.prometheous.coding.graph;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[] {"oath","pea","eat","rain"};
        PrinterUtils.printList(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();
        for(int j = 0; j < words.length; j++) {
            if(exist(board, words[j])) foundWords.add(words[j]);
        }
        return foundWords;
    }

    public static boolean exist(char[][] board, String w) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(DFS(board, i, j, 0, w)) return true;
            }
        }
        return false;
    }

    private static boolean DFS(char[][] board, int bi, int bj, int si, String w) {
        if(si == w.length()) return true;
        if(bi < 0 || bi >= board.length || bj < 0 || bj >= board[0].length
                || board[bi][bj] != w.charAt(si))
            return false;

        char tmp = board[bi][bj];
        board[bi][bj] = '0';

        boolean found = DFS(board, bi + 1, bj, si + 1, w) || DFS(board, bi - 1, bj, si + 1, w)
                || DFS(board, bi, bj + 1, si + 1, w) || DFS(board, bi, bj - 1, si + 1, w);

        board[bi][bj] = tmp;
        return found;
    }

}
