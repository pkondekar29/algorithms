package com.prometheous.coding.array;

import java.util.Scanner;

public class ThreeSumClosest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            if(n < 3) 
                throw new IllegalArgumentException();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int target = sc.nextInt();
    
            System.out.println(ThreeSumClosest.closest(nums, target));
        } finally {
            sc.close();
        }
    }

    public static int closest(int[] a, int target) {
        int minSum = Integer.MAX_VALUE, n = a.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int currSum = a[i] + a[j] + a[k];
                    System.out.println(currSum);
                    if(Math.abs(target - currSum) < Math.abs(target - minSum)) {
                        minSum = currSum;
                    }
                }
            }
        }
        return minSum;
    }
}