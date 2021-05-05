package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfStations {

    public static void main(String[] args) {
        PrinterUtils.print(minStations(Arrays.asList( 1, 2, 3, 4), Arrays.asList(10, 2, 6, 14), 1));
    }

    public static boolean minStations(List<Integer> arrive, List<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int min = 1, currMin = 1;
        int i = 1, j = 0, n = arrive.size();
        while(i < n && j < n) {
            if(arrive.get(i) <= depart.get(j)) {
                currMin++;
                i++;
            } else if(arrive.get(i) > depart.get(j)){
                j++;
                currMin--;
            }
            if(currMin > min)
                min = currMin;
        }
        return K <= min;
    }
}
