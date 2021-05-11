package com.prometheous.coding.array;

import java.util.Scanner;

public class TrapWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(trap(a));

        sc.close();
    }

    public static int trap(int[] a) {
        int totalSum = 0;
        for(int i = 0; i < a.length - 1; i++) {
            int left = a[i];
            for(int j = 0; j < i; j++)
                left = Math.max(left, a[j]);
            int right = a[i];
            for(int j = i + 1; j < a.length; j++)
                right = Math.max(right, a[j]);

            totalSum += Math.min(left, right) - a[i];
        }
        return totalSum;
    }

    public static int trapEff(int[] a) {
        int totalSum = 0;
        int n = a.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = a[0];
        for(int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], a[i]);

        rightMax[n - 1] = a[n - 1];
        for(int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);

        for(int i = 0; i < n; i++)
            totalSum += (Math.min(leftMax[i], rightMax[i]) - a[i]);

        return totalSum;
    }

}
