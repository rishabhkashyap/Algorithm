package com.algo.strings;


public class NthLexographicalPermutation {


    public static void main(String[] args) {

        String str = "abc";
        int n = 3;
        Permutation permutation = new Permutation();
        System.out.println(n + "th lexicographical permutation = " + permutation.nthPermutation(str, n));

    }

    private static class Permutation {
        private static final int MAX_CHAR = 26;
        private int[] factorial;
        private int[] frequency;


        private Permutation() {
            factorial = new int[15];
            frequency = new int[MAX_CHAR];
            preComputeFactorial();
        }

        private String nthPermutation(String str, int n) {
            char[] strArr = str.toCharArray();
            char[] output = new char[str.length()];
            computeFreq(strArr);
            int k = 0;
            int sum = 0;
            while (sum != n) {
                sum=0;
                for (int i = 0; i < MAX_CHAR; i++) {
                    if (frequency[i] != 0) {
                        frequency[i]--;
                        int xsum = factorial[str.length() - 1 - k];
                        for (int j = 0; j < MAX_CHAR; j++) {
                            xsum /= factorial[frequency[j]];
                        }
                        sum += xsum;
                        if (sum >= n) {
                            output[k++] = (char) (i + 'a');
                            n -= (sum - xsum);
                            break;
                        } else {
                            frequency[i]++;
                        }
                    }
                }
            }
            for (int i = MAX_CHAR - 1; i >= 0; i--) {
                if (frequency[i] != 0) {
                    output[k++] = (char) (i + 'a');
                    frequency[i]--;
                }
            }
            return String.valueOf(output);
        }

        private void computeFreq(char[] strArr) {
            for (char character : strArr) {
                frequency[character - 'a']++;
            }
        }

        private void preComputeFactorial() {
            factorial[0] = 1;

            for (int i = 1; i < 15; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
        }
    }

}
