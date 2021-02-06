package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        findPermutations(nums).forEach(l ->
                System.out.println(l.stream().map(String::valueOf).collect(Collectors.joining(" "))));
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> eachPermutation = new ArrayList<>();
        findPermutations_(result, nums, 0, eachPermutation);
        return result;
    }

    private static void findPermutations_(List<List<Integer>> result, int[] nums, int k, List<Integer> eachPermutation) {
        if(k == nums.length) {
            result.add(eachPermutation);
            return;
        }
        for(int i = k; i < nums.length; i++) {
            eachPermutation.add(nums[i]);
            findPermutations_(result, nums, i + 1, eachPermutation);
        }
    }

}
