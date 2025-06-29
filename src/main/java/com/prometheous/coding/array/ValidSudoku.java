package com.prometheous.coding.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> present = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    char num = board[i][j];
                    if(!present.add(num + "(" + i + ")")
                            || !present.add(j + "( " + num + " )")
                            || !present.add(num + "-" + i/3 + "/" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
