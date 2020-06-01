package com.algo.strings;

public class RabinKarp {

    private static final long PRIME_NUMBER = 119;

    public static void main(String[] args) {
//        String text = "this is a test";
//        String pattern = "test";

        String text = "ababcabdab";
        String pattern = "abd";

        System.out.println("Index = " + findIndex(text, pattern));
    }

    private static int findIndex(String text, String pattern) {
        long textHash = calculateHash(text, pattern.length());
        long patternHash = calculateHash(pattern, pattern.length());
        for (int i = 0; i < text.length() - pattern.length()+1; i++) {
            if (textHash == patternHash
                    && checkEquals(text, i, i + pattern.length(), pattern, 0, pattern.length())) {
                return i;
            }
            if (i < text.length() - pattern.length()) {
                textHash = recalculateHash(text, i, i + pattern.length(), textHash, pattern.length());
            }
        }
        return -1;
    }

    private static long calculateHash(String text, int length) {
        long hash = 0;
        for (int i = 0; i < length; ++i) {
            hash += (long) text.charAt(i) * (long) Math.pow(PRIME_NUMBER, i);
        }
        return hash;
    }

    private static boolean checkEquals(String text, int start1, int end1,
                                       String pattern, int start2, int end2) {

        if (end1 - start1 != end2 - start2) {
            return false;
        }
        while (start1 < end1 && start2 < end2) {
            if (text.charAt(start1) != pattern.charAt(start2)) {
                return false;
            }
            ++start1;
            ++start2;
        }
        return true;
    }

    private static long recalculateHash(String text, int oldIndex, int newIndex,
                                        long textHash, int patternLength) {
        long newHash = textHash - text.charAt(oldIndex);
        newHash = newHash / PRIME_NUMBER;
        newHash += (long) text.charAt(newIndex) * (long) Math.pow(PRIME_NUMBER, patternLength - 1);
        return newHash;
    }


}
