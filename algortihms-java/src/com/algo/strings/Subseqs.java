package com.algo.strings;

import java.util.ArrayList;
import java.util.List;

public class Subseqs {
    public static void main(String[] args) {
        String str = "abc";
        List<String> subsequences = generateSubSqs(str);
        System.out.println(subsequences);
    }

    private static List<String> generateSubSqs(String str) {
        int nSubseq = 1 << str.length();//its equivalent of 2^n-1
        List<String> result = new ArrayList<>();
        //Start loop from 1 because first binary representation will be 000...
        for (int i = 1; i <= nSubseq; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                int mask = 1 << j;
                if ((i & mask) != 0) {
                    sb.append(str.charAt(j));
                }
            }
            result.add(sb.toString());

        }
        return result;
    }
}
