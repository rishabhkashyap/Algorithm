package com.algo.stack;

import java.util.Stack;

public class Evaluator {

    public static void main(String[] args) {

        String expression1 = "10+6*2";
        String expression2 = "100*2+12";

        float result = evaluateExpression(expression1);
        System.out.println(result);
        result = evaluateExpression(expression2);
        System.out.println(result);

    }

    private static float evaluateExpression(String expression) {
        Stack<Float> numberStack = new Stack<>();
        Stack<Character> opertatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                String numString = parseNumber(expression, i);
                numberStack.push(Float.parseFloat(numString));
                i += numString.length() - 1;
            } else {
                if (opertatorStack.isEmpty()) {
                    opertatorStack.push(ch);
                } else {

                    while (!opertatorStack.isEmpty() && getPrcedence(opertatorStack.peek()) > getPrcedence(ch)) {
                        float operand1 = 0;
                        float operand2 = 0;
                        if (numberStack.size() >= 2) {
                            operand1 = numberStack.pop();
                            operand2 = numberStack.pop();
                            char operator = opertatorStack.pop();
                            float result = applyOperands(operand1, operand2, operator);
                            numberStack.push(result);
                        }

                    }

                    opertatorStack.push(ch);


                }

            }
        }

        if (!opertatorStack.isEmpty()) {
            while (!opertatorStack.isEmpty()) {
                float operand1 = 0;
                float operand2 = 0;
                if (numberStack.size() >= 2) {
                    operand1 = numberStack.pop();
                    operand2 = numberStack.pop();
                    char operator = opertatorStack.pop();
                    float result = applyOperands(operand1, operand2, operator);
                    numberStack.push(result);
                }


            }
        }

        return numberStack.peek();
    }

    private static float applyOperands(float operand1, float operand2, char operator) {

        float result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
                result = -999;


        }
        return result;
    }

    private static int getPrcedence(Character operator) {

        int preference = -1;

        switch (operator) {
            case '+':
                preference = 1;
                break;
            case '-':
                preference = 1;
                break;
            case '*':
                preference = 2;
                break;
            case '/':
                preference = 2;
                break;
            default:
                preference = 0;
        }
        return preference;
    }

    private static String parseNumber(String expression, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = index;
        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
            stringBuilder.append(expression.charAt(i));
            ++i;
        }
        return stringBuilder.toString();
    }


}
