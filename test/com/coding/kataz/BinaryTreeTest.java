package com.coding.kataz;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 
 * @author ajit
 *
 */
public class BinaryTreeTest {	
	
	public static void main(String[] args) {
		boolean [][] matrix = new boolean [21][21];
		TreeNode root = new TreeNode(10);
		LinkedHashMap<Integer, List<TreeNode>> parentChildrenLinks = new LinkedHashMap<Integer, List<TreeNode>>();
		BinaryTree tree = new BinaryTree(root);
		tree.add(5);
		tree.add(4);
		tree.add(7);
		tree.add(20);
		parentChildrenLinks = tree.buildParentChildLinks(root, parentChildrenLinks);
		matrix = tree.plotAncestors(matrix, parentChildrenLinks);
		displayMatrix(matrix);
	}

	private static void displayMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j=0 ; j< matrix[0].length; j++) {
				System.out.println("i is ->" + i + " and j is -> " + j + " " + matrix[i][j]);
			}
		}
	}
}