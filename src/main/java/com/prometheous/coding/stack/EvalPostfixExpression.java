package com.prometheous.coding.stack;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Stack;

public class EvalPostfixExpression {

    public static void main(String[] args) {
        String postfixExp = InfixToPostfix.convert("3+2*2");
        PrinterUtils.print(postfixExp);
        PrinterUtils.print(evaluate(postfixExp));
    }

    public static int evaluate(String str) {
        Stack<Integer> operandStack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c))
                operandStack.push(c - '0');
            else {
                int num1 = operandStack.pop();
                int num2 = operandStack.pop();

                int res = evaluate(num1, num2, c);
                operandStack.push(res);
            }
        }
        return operandStack.pop();
    }

    private static int evaluate(int num1, int num2, Character c) {
        switch (c) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
        }
        return 0;
    }

}
