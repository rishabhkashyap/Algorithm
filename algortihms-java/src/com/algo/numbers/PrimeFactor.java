package com.algo.numbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public static void main(String[] args) {
        int number = 1239;
        List<Integer> primeFactors = getPrimeFactors(number);
        System.out.println("Using sieve");
        System.out.println("Prime factors of " + number + " are :");
        primeFactors.forEach(e -> System.out.print(e + "\t"));
        System.out.println("\n\nWithout using sieve");
        System.out.println("Prime factors of " + number + " are :");
        primeFactors = getPrimeFactorsWithoutSieve(number);
        primeFactors.forEach(e -> System.out.print(e + "\t"));

    }

    private static List<Integer> getPrimeFactors(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        List<Integer> preCompiledListOfPrimes = getPrimes(1000);
        int i = 0;
        int factor = preCompiledListOfPrimes.get(0);
        while (factor * factor <= number) {

            while (number % factor == 0) {
                primeFactors.add(factor);
                number = number / factor;
            }
            ++i;
            factor = preCompiledListOfPrimes.get(i);
        }
        if (number != 1) {
            primeFactors.add(number);
        }
        return primeFactors;


    }


    private static List<Integer> getPrimes(int num) {
        boolean[] primeBoolean = new boolean[num + 1];
        List<Integer> primes = new ArrayList<>();
        primeBoolean[1] = false;
        primeBoolean[2] = true;
        for (int i = 3; i <= num; i += 2) {
            primeBoolean[i] = true;
        }
        for (int i = 3; i <= num; i++) {
            if (primeBoolean[i]) {
                for (int j = i * i; j <= num; j += 2 * i) {
                    primeBoolean[j] = false;
                }
            }

        }
        for (int i = 2; i <= num; i++) {
            if (primeBoolean[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static List<Integer> getPrimeFactorsWithoutSieve(int number) {

        List<Integer> primeFactors = new ArrayList<>();
        while (number % 2 == 0) {
            primeFactors.add(2);
            number /= 2;
        }

        for (int j = 3; j <= Math.sqrt(number); j += 2) {
            while (number % j == 0) {
                primeFactors.add(j);
                number = number / j;
            }

        }
        if (number > 2) {
            primeFactors.add(number);
        }
        return primeFactors;

    }


}
