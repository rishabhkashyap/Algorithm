package com.algo.mergeSort;

import javax.lang.model.element.Element;

public class MergeSortMain {

	public static void main(String[] args) {
		MergeSort merge=new MergeSort();
		int elemments[]={6,5,10,3,2,1,9,0};
		merge.sort(elemments);
		System.out.println();
		for(int ele:elemments){
			System.out.print(ele+"\t");
		}

	}

}
