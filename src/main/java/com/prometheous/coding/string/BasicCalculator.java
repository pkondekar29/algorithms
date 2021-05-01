package com.prometheous.coding.string;

import com.prometheous.coding.stack.EvalPostfixExpression;
import com.prometheous.coding.stack.InfixToPostfix;
import com.prometheous.coding.utils.PrinterUtils;

public class BasicCalculator {

    public static void main(String[] args) {
        PrinterUtils.print(calculate("(1+(4+5+2)-3)+(6+8)"));
        String postfixExp = InfixToPostfix.convert("(1+(4+5+2)-3)+(6+8)");
        PrinterUtils.print(postfixExp);
        PrinterUtils.print(EvalPostfixExpression.evaluate(postfixExp));
    }

    private static int calculate(String str) {
        int res = 0;
        int num;
        Character prevOperator = null;
        int i = 0;
        while(i < str.length()) {
            char c = str.charAt(i);
            if(c == ' ') {
                i++;
                continue;
            }

            if(Character.isDigit(c)) {
                num = 0;
                while (Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                if(prevOperator == null) {
                    res = num;
                } else {
                    switch (prevOperator) {
                        case '+':
                            res += num;
                            break;
                        case '-':
                            res -= num;
                            break;
                        case '*':
                            res *= num;
                            break;
                        case '/':
                            res /= num;
                            break;
                    }
                }
            } else {
                prevOperator = c;
                i++;
            }
        }
        return res;
    }

}
