package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllCombinations {

    public static void main(String[] args) {
        int n = 4, k = 2;
        AllCombinations.combinations(n, k)
            .stream().map(intList -> intList.stream().map(Object::toString).collect(Collectors.joining(",")))
            .forEach(System.out::println);
    }

    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] currArr = new int[k];
        findAllCombinations(n, k, 0, 0, currArr, res);
        return res;
    }

    private static void findAllCombinations(int n, int k, int counter, int currIndex, int[] arr, List<List<Integer>> res) {
        if(counter >= k) {
            List<Integer> arrList = new ArrayList<>();
            for(int l : arr) {
                arrList.add(l);
            }
            res.add(arrList);
            return;
        }
        for (int p = currIndex; p < n; p++) {
            boolean considered = isPresent(arr, p + 1);     // If number is already considered
            if (!considered) {
                arr[counter] = p + 1;
                findAllCombinations(n, k, ++counter, currIndex + 1, arr, res);
            }
        }
    }

    private static boolean isPresent(int[] arr, int p) {
        boolean present = false;
        for(int j = 0; j < arr.length && !present; j++) {
            if(arr[j] == p) present = true;
        }
        return present;
    }

    public static List<List<Integer>> find(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        double p = Math.pow(2, n);
        for(int i = 0; i < p; i++) {
            String str = Integer.toBinaryString(i);
            if(str.length() != n) {
                String zeros = IntStream.range(0, n - str.length())
                        .mapToObj(x -> "0")
                        .collect(Collectors.joining());
                str = zeros + str;
            }
            int noOfOnes = 0;
            int[] tempPos = new int[n];
            Arrays.fill(tempPos, 0);
            for(int j = n - 1; j >= 0; j--) {
                if(str.charAt(j) == '1') {
                    noOfOnes++;
                    tempPos[n - j - 1] = 1;
                }
            }
            if(noOfOnes == k) {
                List<Integer> pairs = new ArrayList<>();
                for(int j = 0; j < str.length(); j++) {
                    if(tempPos[j] == 1) pairs.add(j + 1);
                }
                res.add(pairs);
            }
        }
        return res;
    }

    public static List<List<Integer>> findA(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        double p = Math.pow(2, n);
        for(int i = 0; i < p; i++) {
            String str = Integer.toBinaryString(i);
            if(str.length() != n) {
                int tempn = str.length();
                for(int j = 0; j < n - tempn; j++) {
                    str = "0" + str;
                }
            }
            int noOfOnes = 0;
            int[] tempPos = new int[n];
            for(int j = n - 1; j >= 0; j--) {
                if(str.charAt(j) == '1') {
                    noOfOnes++;
                    tempPos[n - j - 1] = 1;
                }
            }
            if(noOfOnes == k) {
                List<Integer> pairs = new ArrayList<>();
                for(int j = 0; j < str.length(); j++) {
                    if(tempPos[j] == 1) pairs.add(j + 1);
                }
                res.add(pairs);
            }
        }
        return res;
    }

}
