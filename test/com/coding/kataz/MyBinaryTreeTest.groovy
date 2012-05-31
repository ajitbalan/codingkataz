package com.coding.kataz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyBinaryTreeTest extends GroovyTestCase {
	
	MyBinaryTree tree

	@Before
	public void setUp() throws Exception {
		TreeNode root = new TreeNode(10)
		tree = new MyBinaryTree(root)
	}

	@After
	public void tearDown() throws Exception {
		tree = null
	}
	
	@Test
	public void testAdd() {
		tree.add(20)
		tree.add(5)
		tree.add(30)
		tree.display()
	}
	
	@Test
	public void testIsBalancedTree() {
		tree.add(20)
		tree.add(5)
		println tree.isBalanced()
		tree.display()
	}
	
	
	public void testLevelOrderTraversal() {
		tree.add(20)
		tree.add(5)
		tree.add(30)
		tree.add(40)
		tree.displayLevelOrder()
	}
	
	public void testBinaryTreeToList() {
		tree.add(20)
		tree.add(5)
		tree.add(30)
		tree.add(40)
		tree.toList().each {
			println it.data	
		}
	}
	
	public void testMirrorBinaryTree() {
		tree.add(20)
		tree.add(5)
		tree.add(30)
		tree.add(40)
		tree.mirror();
		tree.display()
	}
	
	public void testBinaryTreeIsBinarySearchTree() {
		tree.add(20)
		tree.add(5)
		tree.add(30)
		println tree.isBst()
	}
	
	public void testVerticalSumOfBinaryTree() {
		tree.add(20)
		tree.add(5)
		tree.add(30)
		tree.add(40)
		tree.verticalsum();
	}
	
	public void testZigZagTraversalOfBinaryTree() {
		tree.add(20)
		tree.add(5)
		tree.add(30)
		tree.add(40)
		tree.zigzag()
		
	}
	
}