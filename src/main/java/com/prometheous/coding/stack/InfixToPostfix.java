package com.prometheous.coding.stack;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        PrinterUtils.print(convert("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public static String convert(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            } else if(c == '(') {
                operatorStack.push(c);
            } else if(c == ')') {
                while(!operatorStack.isEmpty() && operatorStack.peek() != '(')
                    sb.append(operatorStack.pop());

                operatorStack.pop();        // To pop '('
            } else {        // Operator
                while(!operatorStack.isEmpty()
                        /*
                            The precedence of incoming char is less than top, then it needs to be evaluated after what's there on top of stack.
                            So, the operator on top needs to be poped, so that it is evaluated first.
                        *  */
                        && precedence(c) <= precedence(operatorStack.peek()))
                    sb.append(operatorStack.pop());
                operatorStack.push(c);
            }
        }
        while(!operatorStack.isEmpty())
            sb.append(operatorStack.pop());
        return sb.toString();
    }

    private static int precedence(Character c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

}
