package com.algo.tree;

public class SizeOfTree {

	public static void main(String[] args) {
		Node root=new Node(10);
		Node node8=new Node(8);
		Node node2=new Node(2);
		Node node3= new Node(3);
		Node node5=new Node(5);
		Node node7=new Node(7);
		root.setRight(node2);
		root.setLeft(node8);
		node8.setLeft(node3);
		node8.setRight(node5);
		node2.setLeft(node7);
		//node7.setRight(new Node(22));
		int size=getNumberOfNodes(root);
		System.out.println("Size of tree = "+size);

	}

	private static int getNumberOfNodes(Node root) {
	 if(root==null){
		 return 0;
	 }
	 return (getNumberOfNodes(root.getLeft())+getNumberOfNodes(root.getRight())+1);
		
	}

}
