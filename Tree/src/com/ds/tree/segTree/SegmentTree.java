package com.ds.tree.segTree;

public class SegmentTree {
	private int[] segTree;
	private int[] arr;
	private int start;
	private int end;

	public SegmentTree(int[] arr) {
		this.arr = arr;
		int height = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
		int size = (int) Math.pow(2, height + 1) - 1;
		segTree = new int[size];

	}
	
	public  void createSegTree(){
		createSegTreeUtil(0,arr.length-1,0);
	}

	private int  createSegTreeUtil(int start, int end, int current) {
		if(start==end){
			segTree[current]=arr[start];
			return segTree[current];
		}else{
			int mid=mid(start,end);
			segTree[current]= createSegTreeUtil(start, mid, leftChild(current))+
					createSegTreeUtil(mid+1, end, rightChild(current));
			return segTree[current];
		}
		
		
		
	}
	
	public int  getSum(int queryStart,int queryEnd){
		if(queryStart<0 && queryEnd>segTree.length){
			return -1;
		}else{
			return getSumUtil(0,arr.length-1,queryStart,queryEnd,0);
		}
		
	}

	private int getSumUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int current) {
		//Return value of segTree if there is partial overlap or full
		//overlap of range
		if(queryStart<=startIndex && queryEnd>=endIndex){
			return segTree[current];
		}
		if(startIndex>queryEnd || endIndex<queryStart){
			return 0;
		}
		int mid=mid(startIndex,endIndex);
		
		return getSumUtil(startIndex, mid, queryStart, queryEnd, leftChild(current))
				+getSumUtil(mid+1, endIndex, queryStart, queryEnd, rightChild(current));
	}

	private int leftChild(int pos) {
		return 2 * pos + 1;
	}

	private int rightChild(int pos) {
		return 2 * pos + 2;
	}

	private int mid(int start, int end) {
		return (start + (end - start) / 2);
	}
	
	public void displaySegTree(){
		System.out.println("Size of seg tree = "+segTree.length+"\n");
		System.out.println();
		for(int i: segTree){
			System.out.print(i+"\t");
		}
	}

}
