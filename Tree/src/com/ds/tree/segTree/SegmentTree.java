package com.ds.tree.segTree;

public class SegmentTree {
	private int[]segTree;
	private int[]arr;
	private int start;
	private int end;
	
	public SegmentTree(int[] arr) {				
		this.arr = arr;
		int height=(int)(Math.ceil(Math.log(arr.length)/Math.log(2)));
		int size=(int)Math.pow(2, height+1)-1;
		segTree=new int[size];
	}
	
	

}
