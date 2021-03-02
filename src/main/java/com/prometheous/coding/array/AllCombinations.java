package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllCombinations {

    public static void main(String[] args) {
        int n = 1, k = 1;
        AllCombinations.find(n, k)
            .stream().map(intList -> intList.stream().map(Object::toString).collect(Collectors.joining(",")))
            .forEach(System.out::println);
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

}
