package com.algo.recursion;

public class Keypad {

    private String[] keypad={"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};


    public static void main(String[] args){
        int[]numbers={2,3,9,9};
        Keypad keypad=new Keypad();
        char[]outputString=new char[100];
        keypad.printStringCombinations(numbers,outputString,0,0);

    }



    public void printStringCombinations(int[]input,char[] outputString,int i,int j){

        if(i==input.length){
            System.out.println(String.valueOf(outputString,0,i));
            return;
        }
        int digit=input[i];
        if(digit==0||digit==1){
            printStringCombinations(input,outputString,i+1,j);
        }
        String keypadString=keypad[digit];
        for(int k=0;k<keypadString.length();k++){
            outputString[j]=keypadString.charAt(k);
            printStringCombinations(input,outputString,i+1,j+1);
        }
    }


}
