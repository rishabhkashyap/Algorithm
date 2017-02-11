package com.ds.tree;

import java.util.LinkedList;

public class AllPaths {

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
		node7.setRight(new Node(22));
		findPaths(root);
		System.out.println("Path to 23 exists = "+hasPath(root, 23));

	}
	public static void findPaths(Node root){
		int[]path=new int[100];
		LinkedList<int[]> paths=new LinkedList<>();
		findPaths(root,path,0,paths);
//		System.out.println("Stored paths");
//		System.out.println(paths.get(0)[0]);
	}
	public static void findPaths(Node root,int[]path,int len,LinkedList<int[]> paths){
		if(root==null){
			return;
		}
		path[len]=root.getData();
		len++;
		if(root.getLeft()==null && root.getRight()==null){
			paths.add(path);
			printPath(path,len);
		}else{
			findPaths(root.getLeft(), path, len,paths);
			findPaths(root.getRight(), path, len,paths);
		}
	}
	
	public static void printPath(int[]path,int len){
		System.out.println();
		for(int i=0;i<len;i++){
			System.out.print(path[i]+" ");
		}
	}
	
	//Method return true if there exists a path whose sum is equal to
	//give number
	public static boolean hasPath(Node root,int sum){
		if(root==null)
			return false;
		if(root.getLeft()==null&&root.getRight()==null && root.getData()==sum){
			return true;
		}
		return (hasPath(root.getLeft(), sum-root.getData())||hasPath(root.getRight(), sum-root.getData()));
	}
}
