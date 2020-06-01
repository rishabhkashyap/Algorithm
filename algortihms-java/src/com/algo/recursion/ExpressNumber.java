package com.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class ExpressNumber {

    public static void main(String[] args) {
        char[] numbers = {'1', '2', '3','4','5','6','7','8','9'};
        int target = 6;
        expressNumber(numbers, target);
    }

    private static void expressNumber(char[] numbers, int target) {
        if (numbers.length > 0) {
            List<Character> expression = new ArrayList<>();
            expressNumberHelper(numbers, target, expression, 0, 0);
        }
    }

    private static void expressNumberHelper(char[] numbers, int target, List<Character> expression, int sum, int i) {
        if (sum == target) {
            printList(expression);
            return;
        }
        if (sum == 0 && i + 1 < numbers.length) {
            int num1 = numbers[i] - 48;
            int num2 = numbers[i+1] - 48;
            int temp = num1 + num2;

            temp = num1 * num2;
            expression.add(numbers[i]);
            expression.add('*');
            expression.add(numbers[i + 1]);
            expressNumberHelper(numbers, target, expression, sum + temp, i + 2);
            expression.clear();
            temp = num1 + num2;
            expression.add(numbers[i]);
            expression.add('+');
            expression.add(numbers[i + 1]);
            expressNumberHelper(numbers, target, expression, sum + temp, i + 2);

            expression.clear();
            temp = num1 - num2;
            expression.add(numbers[i]);
            expression.add('-');
            expression.add(numbers[i + 1]);
            expressNumberHelper(numbers, target, expression, sum + temp, i + 2);


        } else if (i < numbers.length && !expression.contains(numbers[i])) {
            int num = numbers[i] - 48;
            expression.add('+');
            expression.add(numbers[i]);
            expressNumberHelper(numbers, target, expression, sum + num, i + 1);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);

            //subtract
            expression.add('-');
            expression.add(numbers[i]);
            expressNumberHelper(numbers, target, expression, sum - num, i + 1);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);

            //multiply
            expression.add('*');
            expression.add(numbers[i]);
            expressNumberHelper(numbers, target, expression, sum * num, i + 1);


        }
    }

    private static void printList(List<Character> expression) {
        System.out.println();
        expression.forEach(e -> System.out.print(e + "\t"));
    }
}
