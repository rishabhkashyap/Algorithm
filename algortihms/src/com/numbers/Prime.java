package com.numbers;

public class Prime {

    public static void main(String[] args){
        int n=127;

        if(isPrime(n)){
            System.out.println(n+" is a prime number ");
        }else {
            System.out.println(n+" is not  a prime number ");
        }

    }

    private static boolean isPrime(int n) {
        boolean numberIsPrime=true;
        if(n==1){
            numberIsPrime =false;
        }else if(n==2){
            numberIsPrime=true;
        }else{
            for(int i=2;i*i<n;i++){
                if(n%i==0){
                    numberIsPrime=false;
                    break;
                }
            }
        }
        return numberIsPrime;
    }
}
