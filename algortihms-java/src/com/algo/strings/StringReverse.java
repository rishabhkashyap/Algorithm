package com.algo.strings;

public class StringReverse {

    public static void main(String[] args){
        String string="qwerty";
        string=reverse(string);
        System.out.println("Reversed string = "+string);
    }

    private static String reverse(String string) {
        if(string.length()==0||string.length()==1){
            return string;
        }
        return string.charAt(string.length()-1)+reverse(string.substring(0,string.length()-1));
    }
}
