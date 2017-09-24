package com.ds.tree.segTree;

public class SegTreeMain {

	public static void main(String[] args) {
		 int[] elements = {1,3,5,7,9,11};
		 SegmentTree segmentTree=new SegmentTree(elements);
		 segmentTree.createSegTree();
		 segmentTree.displaySegTree();
		 int sum=segmentTree.getSum(1, 5);
		 System.out.println();
		 System.out.println("Sum from 1 to 3 = "+sum);
		 

	}

}
