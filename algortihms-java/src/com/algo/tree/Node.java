package com.algo.tree;

import java.util.Objects;

public final class Node {
	private int data;
	private Node right;
	private Node left;

	public Node(int n) {
		this.data = n;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return data == node.data && Objects.equals(right, node.right) && Objects.equals(left, node.left);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, right, left);
	}
}
