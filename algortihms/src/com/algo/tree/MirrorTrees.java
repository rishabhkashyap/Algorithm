package com.algo.tree;

public class MirrorTrees {

	public static void main(String[] args) {
		
		Node root=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		System.out.println("Orignal Tree");
		System.out.println();
		TreeUtil.preOrder(root);
		flipTree(root);
		System.out.println("\n Flipped tree \n");
		TreeUtil.preOrder(root);
	}
	
	//Flip Tree
		private static void flipTree(Node root){
			Node temp;
			if(root!=null){
				flipTree(root.getLeft());
				flipTree(root.getRight());
				temp=root.getLeft();
				root.setLeft(root.getRight());
				root.setRight(temp);			
			}
			return;
		}
	
	

}
