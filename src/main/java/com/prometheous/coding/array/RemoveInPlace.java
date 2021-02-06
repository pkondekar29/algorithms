package com.prometheous.coding.array;

import java.util.Scanner;

public class RemoveInPlace {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int i = RemoveInPlace.removeElement(nums, sc.nextInt());
        System.out.println(i);
        for(int k = 0; k < i; k++) {
            System.out.print(nums[k] + " ");
        }
        sc.close();
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0, o = 0;
        while(i < nums.length) {
            if(nums[i] != val) {
                nums[o++] = nums[i];
            }
            i++;
        }
        return o;
    }

}