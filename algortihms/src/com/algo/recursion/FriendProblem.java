package com.algo.recursion;

//Given n friends, each one can remain single or can be paired up with some other friend.
//Each friend can be paired only once. Find out the total number of ways in which friends
//can remain single or can be paired up.

//Input  : n = 3
//Output : 4
//
//Explanation
//{1}, {2}, {3} : all single
//{1}, {2, 3} : 2 and 3 paired but 1 is single.
//{1, 2}, {3} : 1 and 2 are paired but 3 is single.
//{1, 3}, {2} : 1 and 3 are paired but 2 is single.

public class FriendProblem {

    public static void main(String[] args){
        int n=3;
        System.out.println("Number of arrangement = "+countArrangement(3));
    }

    private static int countArrangement(int n){
        int[]arrgangementCount=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<=2){
                arrgangementCount[i]=i;
            }else {
                arrgangementCount[i]=(n-1)+(n-1)*arrgangementCount[n-2];
            }
        }
        return arrgangementCount[n];
    }
}
