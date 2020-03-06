package com.algo.strings;


import java.util.ArrayList;
import java.util.List;


class IPAddress {
    public static void main(String[] args) {

        String string = "25525511135";
        List<String> ipAddresses = generateIpAddresses(string);
        ipAddresses.forEach(e -> System.out.println(e));

    }

    private static List<String> generateIpAddresses(String string) {
        List<String> ipList = new ArrayList<>();
        ipAddressGenerator(string, ipList);
        return ipList;
    }

    private static void ipAddressGenerator(String string, List<String> ipList) {
        if (string.length() < 3) {
            return;
        }
        String temp = string;
        for (int i = 1; i < string.length() - 2; i++) {
            for (int j = i + 1; j < string.length() - 1; j++) {
                for (int k = j + 1; k < string.length(); k++) {
                    temp = temp.substring(0, k) + "." + temp.substring(k);
                    temp = temp.substring(0, j) + "." + temp.substring(j);
                    temp = temp.substring(0, i) + "." + temp.substring(i);
                    if (isValid(temp)) {
                        ipList.add(temp);
                    }
                    temp = string;
                }

            }
        }
    }

    private static boolean isValid(String ipAddress) {
        String[] blocks = ipAddress.split("\\.");
        for (String block : blocks) {
            int integer = Integer.parseInt(block);
            if (block.length() > 3 || integer < 0 || integer > 255) {
                return false;
            }
            if (block.length() > 1 && integer == 0) {
                return false;
            }
            if (block.length() > 1 && integer != 0 && block.charAt(0) == '0') {
                return false;
            }
        }
        return true;
    }
}



