package com.algo.hashing;

import java.util.HashSet;
import java.util.Set;
//Problem: https://leetcode.com/problems/unique-email-addresses/
public class Email929 {
    public static void main(String[] args) {
//        String[] emails = {"test.email+alex@leetcode.com",
//                "test.e.mail+bob.cathy@leetcode.com",
//                "testemail+david@lee.tcode.com"};
        String[] emails = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println(countUniqueEmails(emails));
    }

    private static int countUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '+' || email.charAt(i) =='@') {
                    break;
                }
                if (email.charAt(i) != '.') {
                    sb.append(email.charAt(i));
                }
            }
            int locDomain = email.indexOf('@');
            sb.append(email.substring(locDomain));
            set.add(sb.toString());
        }
        return set.size();
    }
}
