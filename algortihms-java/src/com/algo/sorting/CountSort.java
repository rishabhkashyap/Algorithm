package com.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class CountSort {

	public static void main(String[] args) {
		int[]input= {2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4};
			//{5,3,0,2,4,1,0,5,2,3,1,4};
		int[]result=sort(input);
		System.out.print("Orignal array = ");
		Arrays.stream(input)
	      .forEach(ele->System.out.print(ele+"\t"));
		System.out.print("\nSorted array = ");
		Arrays.stream(result)
		      .forEach(ele->System.out.print(ele+"\t"));
		

		
	
	}
	
	private static int[] sort(int[]arr) {
		OptionalInt maxOptional=Arrays.stream(arr)
				                     .max();
		int[]freqArray=null;
		int[]result=new int[arr.length];
		if(maxOptional.isPresent()) {
			freqArray=new int[maxOptional.getAsInt()+1];
		}else {
			return null;
		}
		
		//Count frequency of each element and store in frequency array
		for(int i=0;i<arr.length;i++) {
			++freqArray[arr[i]];
		}
		System.out.print( "freq arr        = ");
		Arrays.stream(freqArray).forEach(e->System.out.print(e+"  "));
		System.out.println();
		
		for(int i=1;i<freqArray.length;i++) {
			freqArray[i]=freqArray[i]+freqArray[i-1];
		}
		System.out.print( "freq arr with pos  = ");
		Arrays.stream(freqArray).forEach(e->System.out.print(e+"  "));
		System.out.println();
		
		
		for(int i=0;i<arr.length;i++) {
			result[freqArray[arr[i]]-1]=arr[i];
			--freqArray[arr[i]];
		}
		return result;
		
		
	}     
	
	

}
