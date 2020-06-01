package com.algo.numbers;

public class Euclid {

    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 15;
        int gcd = getGCD(number1, number2);
        int lcm = getLCM(number1, number2);
        System.out.println("GCD of " + number1 + " and " + number2 + " = " + gcd);
        System.out.println("LCM of " + number1 + " and " + number2 + " = " + lcm);
        System.out.println("\n\nSolving equation using extended euclid method ");
        Equation equation = solveEquationUsingEuclidMethod(18, 30);
        System.out.println("x = " + equation.x + "   " + "y = " + equation.y);
    }


    private static int getGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        } else {
            return getGCD(number2, number1 % number2);
        }
    }

    private static int getLCM(int number1, int number2) {
        int gcd = getGCD(number1, number2);
        int lcm = (number1 * number2) / gcd;
        return lcm;

    }


    private static Equation solveEquationUsingEuclidMethod(int a, int b) {
        Equation equation = new Equation();
        extendedEuclidMethod(a, b, equation);
        return equation;

    }

    private static void extendedEuclidMethod(int a, int b, Equation equation) {
        if (b == 0) {
            equation.x = 1;
            equation.y = 0;
        } else {
            extendedEuclidMethod(b, a % b, equation);
            int tempX = equation.y;
            int tempY = equation.x - (a / b) * equation.y;
            equation.x = tempX;
            equation.y = tempY;


        }


    }


    static class Equation {
        private int x;

        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


}
