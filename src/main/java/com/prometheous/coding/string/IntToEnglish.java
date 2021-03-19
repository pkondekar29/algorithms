package com.prometheous.coding.string;

import java.util.HashMap;

public class IntToEnglish {

    public static void main(String[] args) {
        System.out.println(convert(1000));
    }

    private static String convert(int i) {

        HashMap<Integer, String> ones = new HashMap<>();
        ones.put(1, "One");
        ones.put(2, "Two");
        ones.put(3, "Three");
        ones.put(4, "Four");
        ones.put(5, "Five");
        ones.put(6, "Six");
        ones.put(7, "Seven");
        ones.put(8, "Eight");
        ones.put(9, "Nine");

        HashMap<Integer, String> tens = new HashMap<>();
        tens.put(10, "Ten");

        tens.put(11, "Eleven");
        tens.put(12, "Twelve");
        tens.put(13, "Thirteen");
        tens.put(14, "Fourteen");
        tens.put(15, "Fifteen");
        tens.put(16, "Sixteen");
        tens.put(17, "Seventeen");
        tens.put(18, "Eighteen");
        tens.put(19, "Nineteen");
        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");

        HashMap<Integer, String> hund = new HashMap<>();
        hund.put(1, "One Thousand");
        return "";
    }

}
