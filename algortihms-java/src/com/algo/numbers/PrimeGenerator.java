package com.algo.numbers;

//Sieve of Eratosthenes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeGenerator {
    public static void main(String[] args) {
        int n = 1000;
        List<Integer> primes = generatePrimeNumbers(n);
        System.out.println("Prime numbers");
        primes.forEach(num -> System.out.print(num + "\t"));
    }

    private static List<Integer> generatePrimeNumbers(int n) {
        boolean[] primeBoolean = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        primeBoolean[2] = true;

        for (int i = 3; i <= n; i += 2) {
            primeBoolean[i] = true;
        }

        //Mark multiples of prime as not prime by setting boolean array as false
        for (int i = 3; i <= n; i += 2) {
            if (primeBoolean[i]) {
                //Adding 2 odd numeber gives a even number,therefore increment j by 2i to get next odd number
                for (int j = i * i; j <= n; j += 2 * i) {
                    primeBoolean[j] = false;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (primeBoolean[i]) {
                primes.add(i);
            }
        }
        return primes;

    }
}
