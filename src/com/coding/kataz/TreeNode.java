package com.coding.kataz;

/**
 * 
 * @author ajit
 *
 */
public class TreeNode {
	
	private  TreeNode left;
	private  TreeNode right;
	private int data;
	
	TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public int getData() {
		return data;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		TreeNode other = (TreeNode)obj;
		if(this.data == other.data) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "" + data;
	}
	
}