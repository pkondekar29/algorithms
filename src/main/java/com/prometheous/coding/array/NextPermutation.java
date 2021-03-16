package com.prometheous.coding.array;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        nextPermutation(a);
        for(int i : a) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1)
            return nums;
        int i = n - 1;
        while(i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        i--;
        if(i >= 0) {
            int max = nums[i], maxPos = i;
            for (int k = i + 1; k < n; k++) {
                if (nums[k] > max) {
                    maxPos = k;
                }
            }
            int temp = nums[maxPos];
            nums[maxPos] = nums[i];
            nums[i] = temp;
        }

        Arrays.sort(nums, i + 1, n);
        return nums;
    }

}
