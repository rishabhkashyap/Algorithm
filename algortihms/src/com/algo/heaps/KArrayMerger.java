package com.algo.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KArrayMerger {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println();
		for(int i:result){
			System.out.print(i+"\t");
		}

	}

	private static int[] mergeKSortedArray(int[][] arr) {
		Queue<ArrayContainer>pq=new PriorityQueue<>();
		int size=0;
		int []result;
		int ind=0;
		int m=0;
		for(int i=0;i<arr.length;i++){
			ArrayContainer ac=new ArrayContainer(arr[i], 0);
			pq.add(ac);
			size+=arr[i].length;
		}
		result=new int[size];
		
		while(!pq.isEmpty()){
			ArrayContainer element=pq.poll();
			int[]arrElement=element.getElements();
			int indexElement=element.getIndex();
			result[m++]=arrElement[indexElement];
			 ind=element.getIndex();
			if(indexElement<arr.length){
				ArrayContainer nextElement=new ArrayContainer(arrElement,indexElement+1);
				pq.add(nextElement);
			}
		}
		return result;
	}

}
