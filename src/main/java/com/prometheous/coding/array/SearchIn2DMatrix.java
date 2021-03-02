package com.prometheous.coding.array;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int [][] a = new int[2][3];
        int target = 3;
        SearchIn2DMatrix.search(a, target);
    }

    public static boolean search(int[][] a, int t) {
        int i = 0, j = 0, m = a.length;
        while(i < m && t >= a[i + 1][0]) {
            i++;
        }
        if(i == m) {
            i = m - 1;
        }

        int n = a[i].length;
        while(j < n - 1 && t <= a[i][j + 1]) {
            j++;
        }
        if(j == n) j = n - 1;

        return t == a[i][j];
    }

}
