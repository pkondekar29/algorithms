package com.prometheous.coding.array;

public class SetMatrixZeros {

    public static int[][] setZeroes(int[][] a) {
        boolean firstCol = false;
        for(int i = 0; i < a.length; i++) {
            if(a[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        boolean firstRow = false;
        for(int j = 0; j < a[0].length; j++) {
            if(a[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        for(int i = 1; i < a.length; i++) {
            for(int j = 1; j < a[0].length; j++) {
                if(a[i][j] == 0) {
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }

        for(int j = 1; j < a[0].length; j++) {
            if(a[0][j] == 0) {
                for(int i = 0; i < a.length; i++) {
                    a[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < a.length; i++) {
            if(a[i][0] == 0) {
                for(int j = 0; j < a[0].length; j++) {
                    a[i][j] = 0;
                }
            }
        }

        if(firstRow) {
            for(int j = 0; j < a[0].length; j++)
                a[0][j] = 0;
        }
        if(firstCol) {
            for(int i = 0; i < a.length; i++)
                a[i][0] = 0;
        }
        return a;
    }

}
