package com.github.traverse.model;

public class Node {

	private int data;
	private boolean isVisited;
	public Node() {
		this.data=1;
	}
	public int getData() {
		return data;
	}
	
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", isVisited=" + isVisited + "]";
	}
	
	
}
