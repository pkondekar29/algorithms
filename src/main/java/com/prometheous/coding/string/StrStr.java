package com.prometheous.coding.string;

import java.util.Scanner;

public class StrStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(strstr(s1, s2));
    }

    public static int strstr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if(l2 > l1)
            return -1;
        int i = 0, j;
        while(i <= l1 - l2) {
            j = i;
            while(j < i + l2) {
                if(haystack.charAt(j) != needle.charAt(j - i))
                    break;
                j++;
            }
            if(j - l2 == i)
                return i;
            i++;
        }
        return -1;
    }

}
