package com.algo.stack;

import java.util.Stack;

public class Evaluator {

    public static void main(String[] args) {

        String expression1 = "10+6*2";
        String expression2 = "100*2+12";
        String expression3 = "100*2+12/2";

        float result = evaluateExpression(expression1);
        System.out.println(result);
        result = evaluateExpression(expression2);
        System.out.println(result);
        result = evaluateExpression(expression3);
        System.out.println(result);

    }

    private static float evaluateExpression(String expression) {
        Stack<Float> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                String numString = parseNumber(expression, i);
                numberStack.push(Float.parseFloat(numString));
                i += numString.length() - 1;
            } else {
                addOperator(operatorStack, numberStack, ch);
            }
        }
        while (!operatorStack.isEmpty()) {
            numberStack.push(reduce(numberStack, operatorStack));
        }
        return numberStack.peek();
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

    private static void addOperator(Stack<Character> operators, Stack<Float> operands, char ch) {
        if (operators.isEmpty()) {
            operators.push(ch);
        } else {
            while (!operators.isEmpty() && getPrecedence(operators.peek()) > getPrecedence(ch)) {
                operands.push(reduce(operands, operators));
            }
            operators.push(ch);
        }
    }


    private static float reduce(Stack<Float> operands, Stack<Character> operators) {
        if (operands.size() < 2) {
            return 0;
        }
        float op2 = operands.pop();
        float op1 = operands.pop();
        char operator = operators.pop();
        return applyOperands(op1, op2, operator);
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

    private static int getPrecedence(Character operator) {

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


}
