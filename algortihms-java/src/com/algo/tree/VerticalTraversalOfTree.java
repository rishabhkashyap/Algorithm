package com.algo.tree;

import java.util.*;

public class VerticalTraversalOfTree {

	public static void main(String[] args) {
		Node root=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node6=new Node(6);
		Node node7=new Node(7);
		Node node8=new Node(8);
		Node node9=new Node(9);
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		node6.setRight(node8);
		node7.setRight(node9);
		doVericalTraversal(root);
		

	}
	private static void  doVericalTraversal(Node root){
		Map<Integer,List<Node>> verticalNodes=new HashMap<>();
		calculateHd(root,0,verticalNodes);
		if(verticalNodes.size()>0){
			Set<Integer>hd=verticalNodes.keySet();
			hd.forEach(
					e->{
						verticalNodes.get(e).forEach(v->System.out.print(v.getData()+" "));
						System.out.println();
					}
					);
					
		}
	}
	
	private static void calculateHd(Node root, int hd, Map<Integer, List<Node>> verticalNodes) {
		if(root==null){
			return;
		}
		List<Node>nodes=null;
		if(verticalNodes.containsKey(hd)){
			nodes=verticalNodes.get(hd);
		}else{
			nodes=new ArrayList<>();
		}
		nodes.add(root);
		verticalNodes.put(hd, nodes);
		calculateHd(root.getLeft(), hd-1, verticalNodes);
		calculateHd(root.getRight(), hd+1, verticalNodes);
		
	}

}
