package com.prometheous.coding.string;

public class WordSearchInGrid {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "SEE"));
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

        if(DFS(board, bi + 1, bj, si + 1, w) || DFS(board, bi - 1, bj, si + 1, w)
                || DFS(board, bi, bj + 1, si + 1, w) || DFS(board, bi, bj - 1, si + 1, w))
            return true;

        board[bi][bj] = tmp;
        return false;
    }

}
