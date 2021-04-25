package com.prometheous.coding.stack;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParantheses {

    private static Stack<Character> st = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(LongestValidParantheses.findLongestValidParanthes(str));

        sc.close();
    }

    public static int findLongestValidParanthesEff(String s) {
        int left = 0, right = 0;
        int maxlength = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxlength = Math.max(maxlength, 2 * right);
            else if (right > left)
                left = right = 0;
        }
        return maxlength;
    }

    public static int findLongestValidParanthes(String str) {
        int max = 0;
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {
                if(isValidParantheses(str, i, j)) {
                    max = Math.max(j - i + 1, max);
                }
            }
        }
        return max;
    }

    private static boolean isValidParantheses(String str, int i, int j) {
        st.clear();
        for(int k = i; k <= j; k++) {
            if(str.charAt(k) == '(') {
                st.push('(');
            } else {
                if(st.isEmpty() || st.pop() != '(') {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

}
