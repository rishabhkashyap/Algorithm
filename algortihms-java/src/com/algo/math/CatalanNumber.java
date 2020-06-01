package com.algo.math;



public class CatalanNumber {
    public static void main(String[] args){
        int number=4;
        System.out.println("Catalan number using recurrence(recuresion) = "+catalanRecurreneRecursion(number));

        System.out.println("Catalan number using recurrence(dynamic) = "+catalanDynamic(number));

        int catalan=(getBinoamialCoeff(2*number,number))/(number+1);

        System.out.println("Catalan number using binomial coefficient = "+catalan);


    }


    //Catalan number using recursion
    private static int catalanRecurreneRecursion(int n){
        int res=0;
        if(n<=1){
            return 1;
        }
        for(int i=0;i<n;i++){
            res+=catalanRecurreneRecursion(i)*catalanRecurreneRecursion(n-i-1);
        }
        return res;
    }

    //catalan number using dynamic programming
    private static  int catalanDynamic(int n){
        int []dict=new int[n+1];
        dict[0]=1;
        dict[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dict[i]=dict[i]+dict[j]*dict[i-j-1];
            }
        }

        return dict[n];


    }


    //Calculating Binomial cofficient

    private static  int getBinoamialCoeff(int n,int k){
        int[][]dict=new int[n+1][k+1];



        for(int i=0;i<=n;i++){
            for(int j=0;j<= Math.min(i,k);j++){
                if(j==0||j==i){
                    dict[i][j]=1;
                }else {
                    dict[i][j]=dict[i-1][j-1]+dict[i-1][j];
                }
            }
        }
        return dict[n][k];
    }


}
