package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);
		Node node8 = new Node(8);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		Node node7 = new Node(7);
		root.setRight(node2);
		root.setLeft(node8);
		node8.setLeft(node3);
		node8.setRight(node5);
		node2.setLeft(node7);
		node7.setRight(new Node(22));
		doLevelOrderTraversal(root);
	}

	private static void doLevelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			
			if (node != null) {
				System.out.print(node.getData() + " ");
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
			if(node==null && !queue.isEmpty()){
				queue.add(null);
			}

		}

	}

}
