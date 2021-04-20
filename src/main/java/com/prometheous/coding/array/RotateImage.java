package com.prometheous.coding.array;

public class RotateImage {

    public static void main(String[] args) {
        int[][] a = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] a = new int[][] {{1}};
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
//        rotateImage(a);
        rotateImageSingleItr(a);
        System.out.println();
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateImage(int[][] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][n - j - 1];
                a[i][n - j - 1] = temp;
            }
        }
    }

    public static void rotateImageSingleItr(int[][] matrix) {
        if(matrix == null|| matrix.length ==0 || matrix[0].length ==0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        if(row != col) return;
        //If we scan along the upper side, the lower side will also be scanned
        //Therefore,the maximum value of i will be 2*i<=row -1
        for(int i =0;i<=(row - i)-1;i++){
            //The lower bound of j should be the same as i.
            //If we scan the left side or left side of the inner loop, the right side will also be scanned.
            //Therefore, the maximum value of j will be as follows
            //i+1 will be the length of the right side have already been scanned with the corresponding i.
            for(int j = i;j<=(row - 1)-(i+1);j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-1-j][i];
                matrix[row-1-j][i] = matrix[row-1-i][row-1-j];
                matrix[row-1-i][row-1-j] = matrix[j][row-1-i];
                matrix[j][row-1-i] = temp ;
            }
        }
    }

}
