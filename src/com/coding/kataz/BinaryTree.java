package com.coding.kataz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ajit
 * 
 * This is a Binary Search Tree Implementation
 *
 */
public class BinaryTree {
	
	TreeNode root;
	
	public BinaryTree(TreeNode root) {
		this.root = root;
	}
	
	
	void add(int data) {
		if(root == null) {
			root = new TreeNode(data);
			return; 
		}
		
		insert(root, data);
	}	
	
	
	TreeNode insert(TreeNode node, int data) {
		if(node == null) {
			node = new TreeNode(data);
		} else {
			if(node.getData() > data) {
				node.setLeft(insert(node.getLeft(), data));
			} else {
				node.setRight(insert(node.getRight(), data));
			}
		}
		return node;
	}
	
	void display() {
		System.out.println("In Order Traversal");
		displayInOrder(root);
		System.out.println("Pre Order Traversal");
		displayPreOrder(root);
		System.out.println("Post Order Traversal");
		displayPostOrder(root);
	}
	
	void displayInOrder(TreeNode node) {
		if(node != null) {
			displayInOrder(node.getLeft());
			System.out.println(node.getData());
			displayInOrder(node.getRight());
		}
	}
	
	void displayPreOrder(TreeNode node) {
		if(node != null) {
			System.out.println(node.getData());
			displayPreOrder(node.getLeft());
			displayPreOrder(node.getRight());
		}
	}
	
	void displayPostOrder(TreeNode node) {
		if(node != null) {
			displayPostOrder(node.getLeft());
			displayPostOrder(node.getRight());
			System.out.println(node.getData());
		}
	}
	
	/**
	 * Plots the ancestors to the matrix
	 * @param matrix
	 * @param parentChildMappings
	 * @return
	 */
	boolean [][] plotAncestors(boolean [][] matrix, Map<Integer, List<TreeNode>>parentChildMappings) {
		
		for (Integer integer : parentChildMappings.keySet()) {
			int i= 0 , j = 0;
			List<TreeNode> list = parentChildMappings.get(integer);
			for (TreeNode node : list) {
				i = integer;
				j = node.getData();
				if(parentChildMappings.keySet().contains(node.getData())) {
					List<TreeNode> children = parentChildMappings.get(node.getData());
					for (int k = 0; k < children.size(); k++) {
						int value = children.get(k).getData();
						matrix[i][value] = true;	
					}
					matrix[i][j] = true;
				} else {
					matrix[i][j] = true;
				}
			}
		}
		return matrix;
	}
	
	/**
	 * Builds the parent child links for the matrix
	 * @return
	 */
	public LinkedHashMap<Integer, List<TreeNode>> buildParentChildLinks(TreeNode node, LinkedHashMap<Integer, List<TreeNode>> parentChildMappings) {
		if(node != null) {
			buildParentChildLinks(node.getLeft(), parentChildMappings);
			buildParentChildLinks(node.getRight(), parentChildMappings);
			List<TreeNode> children = new ArrayList<TreeNode>();
			if(node.getLeft() == null) {
				parentChildMappings.put(node.getData(), children);
			}
			if(node.getRight() == null) {
				parentChildMappings.put(node.getData(), children);
			} 
			else {
				children.add(node.getLeft());
				children.add(node.getRight());
				parentChildMappings.put(node.getData(), children);
			}
		}
		return parentChildMappings;
	}
}