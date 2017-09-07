package com.algo.heaps;

public class ArrayContainer implements Comparable<ArrayContainer> {
	private int elements[];
	private int index;
	public ArrayContainer(int[] elements, int index) {		
		this.elements = elements;
		this.index = index;
	}
	
	
	 
	public int[] getElements() {
		return elements;
	}

	public int getIndex() {
		return index;
	}



	@Override
	public int compareTo(ArrayContainer ac) {
		// TODO Auto-generated method stub
		return this.elements[index]-ac.getElements()[ac.getIndex()];
	}
	
			
	

}
