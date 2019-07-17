package com.dnc;

public class SquareRoot {

    public static void main(String[] args) {
        int number = 13;
        int precision = 3;
        System.out.println("Square root of " + number + " = " + getSquareRoot(number, precision));
    }

    private static float getSquareRoot(int number, int precison) {
        int start = 0;
        int end = number;
        int mid = 0;
        float ans = 0;
        while (start <= end) {
            mid = (end + start) / 2;
            if (mid * mid == number) {
                ans = mid;
                break;
            } else if (mid * mid < number) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        float step = 0.1F;
        for (int i = 0; i <= precison; i++) {
            while (ans * ans <= number) {
                ans += step;
            }
            ans -= step;
            step = step / 10;
        }

        return ans;

    }
}
