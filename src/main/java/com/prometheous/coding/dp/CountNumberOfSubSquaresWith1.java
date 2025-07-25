package com.prometheous.coding.dp;

public class CountNumberOfSubSquaresWith1 {

    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
                res += dp[i + 1][j + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new CountNumberOfSubSquaresWith1().countSquares(new int[][]{
                {0,1,1,1},
                {0,0,1,1},
                {0,1,0,1},
                {0,0,1,1}
        });
    }
}
