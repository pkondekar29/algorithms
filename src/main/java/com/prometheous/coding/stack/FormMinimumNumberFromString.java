package com.prometheous.coding.stack;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Stack;

public class FormMinimumNumberFromString {

    public static void main(String[] args) {
        PrinterUtils.print(findMinimumFrom("DIDID"));
    }

    public static String findMinimumFrom(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int length = str.length();
        for(int i = 0; i <= length; i++) {
            stack.push(i + 1);
            if(i == length || str.charAt(i) == 'I') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        return sb.toString();
    }

}
