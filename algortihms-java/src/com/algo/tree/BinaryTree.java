package com.algo.tree;

public class BinaryTree {
	
	boolean areIdentical(Node node1,Node node2){
		if(node2==null&&node2==null){
			return true;
			
		}
		if(node1==null||node2==null){
			return false;
		}
		return(node1.getData()==node2.getData()&& areIdentical(node1.getLeft(),node2.getLeft())&&areIdentical(node1.getRight(),node2.getRight()));
	}
	
	public  boolean isSubTree(Node t,Node s){
		if(s==null){
			return true;
		}
		if(t==null){
			return false;
		}
		if(areIdentical(t,s)){
			return true;
		}
		return (isSubTree(t.getLeft(),s)||isSubTree(t.getRight(),s));
	}

}
