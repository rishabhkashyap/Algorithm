package com.algo.numbers;



public class ModuloInverse {

    public static void main(String[] args) {

        long num = 3;
        long m = 1000000007;
        Equation equation = getModuloInverse(num, m);
        System.out.println((equation.x+m)%m);
    }

    private static Equation getModuloInverse(long num, long m) {
        Equation equation = new Equation();
        performExtendedEuclidMethod(num, m, equation);
        return equation;
    }

    private static void performExtendedEuclidMethod(long num, long m, Equation equation) {
        if (m == 0) {
            equation.x = 1;
            equation.y = 0;

        } else {
            performExtendedEuclidMethod(m,num%m, equation);
            long tempX = equation.y;
            long tempY = equation.x - (num / m) * equation.y;
            equation.x = tempX;
            equation.y = tempY;

        }
    }

    private static class Equation {
        private long x;
        private long y;
    }


}

