package com.ds.tree;

public class TreeUtil {
	
	public static void preOrder(Node root){
		if(root!=null){
			System.out.print(root.getData()+"  ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
		
	}
	
	

}
