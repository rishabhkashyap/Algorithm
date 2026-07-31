package com.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStr {
    static void main() {
        List<String> list = Arrays.asList("Hello", "World");
        var str = encodeStr(list);
        System.out.println(decodeStr(str));
    }

    private static String encodeStr(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str.length())
                    .append('#')
                    .append(str);
        }
        return sb.toString();
    }

    private static List<String> decodeStr(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                ++j;
            }
            var len = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return result;
    }
}
