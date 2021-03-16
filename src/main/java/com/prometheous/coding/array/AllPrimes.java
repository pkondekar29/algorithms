package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPrimes {

    public static void main(String[] args) {
        int n = 6;
        findPrimes(n).stream().forEach(System.out::println);
    }

    private static List<Integer> findPrimes(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        for(int i = 2; i * i <= n; i++) {
            if(sieve[i] == true) {
                for(int k = i * i; k <= n; k += i) {
                    sieve[k] = false;
                }
            }
        }

        List<Integer> allPrimes = new ArrayList<>();
        allPrimes.add(1);
        for(int i = 2; i <= n; i++) {
            if(sieve[i] == true)
                allPrimes.add(i);
        }
        return allPrimes;
    }


}
