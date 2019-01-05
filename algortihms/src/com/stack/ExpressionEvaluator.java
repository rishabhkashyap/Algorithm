package com.stack;

import java.util.Stack;

public class ExpressionEvaluator {

    public static void main(String[] args) {
        String expression = "2*3+5/6*3+15";
        System.out.println(evaluateExpression(expression));

    }

    private static double evaluateExpression(String expression) {
        int i = 0;
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                double number = getOperand(expression, i);
                operands.push(number);
                i += Integer.toString((int) number).length();
            } else {
                if (i < expression.length()) {

                    if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                        collapseStack(ch, operands, operators);
                    }
                }
                ++i;
            }

        }
        while (!operators.isEmpty()){
            double op2 = operands.pop();
            double op1 = operands.pop();
            char stackOperator = operators.pop();
            double result = getOperatorOperationResult(op1, stackOperator, op2);
            operands.push(result);


        }
        return operands.pop();


    }

    private static void collapseStack(char ch, Stack<Double> operands, Stack<Character> operators) {

        if (!operators.isEmpty() && (getPriority(ch) <= getPriority(operators.peek()))) {
            while (!operands.isEmpty() && !operators.isEmpty()
                    && operands.size() >= 2 &&(getPriority(ch) <= getPriority(operators.peek()))) {
                double op2 = operands.pop();
                double op1 = operands.pop();
                char stackOperator = operators.pop();
                double result = getOperatorOperationResult(op1, stackOperator, op2);
                operands.push(result);

            }
            operators.push(ch);

        } else {
            operators.push(ch);

        }
    }

    private static double getOperatorOperationResult(double op1, char stackOperator, double op2) {
        double result = 0;
        switch (stackOperator) {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                result = op1 / op2;
                break;
            default:
                result = -999999;


        }
        return result;
    }

    private static int getPriority(char ch) {
        switch (ch) {
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

    private static double getOperand(String expression, int i) {
        StringBuffer sb = new StringBuffer();
        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
            sb.append(expression.charAt(i));
            ++i;
        }
        return Double.parseDouble(sb.toString());
    }
}
