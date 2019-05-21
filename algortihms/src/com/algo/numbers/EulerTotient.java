package com.algo.numbers;

public class EulerTotient {


    public static void main(String[] args) {

        int number = 10;

        int result = calculatePhi(number);
        System.out.println(result);
    }

    private static int calculatePhi(int number) {
        float result = number;
        for (int i = 2; i * i <= number; ++i) {

            if (number % i == 0) {
                while (number % i == 0) {
                    number = number / i;
                }

                result *= (1.0 - (1.0 / (float) i));

            }

        }

        if (number > 1)
            result *= (1.0 - (1.0 / (float) number));
        return (int) result;
    }


}
