package com.coding.kataz

class MyBinaryTree {
	
	TreeNode root
	
	MyBinaryTree(TreeNode root) {
		this.root = root
	}
	
	int maxDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right))
	}
	
	int minDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(node.left), minDepth(node.right))
	}
	
	void add(int data) {
		if(root == null) {
			root = new TreeNode(data)
			return; 
		}
		
		insert(root, data)
	}	
	
	
	TreeNode insert(TreeNode node, int data) {
		if(node == null) {
			node = new TreeNode(data)
		} else {
			if(node.data > data) {
				node.left = insert(node.left, data)
			} else {
				node.right = insert(node.right, data)
			}
		}
		node
	}
	
	boolean isBalanced() {
		return maxDepth(root) - minDepth(root) <= 1
	}
	
	List toList() {
		LinkedList list = new LinkedList()
		formList(root, list)
		list
	}
	
	boolean isBst() {
		int lastValue = Integer.MIN_VALUE
		return checkBst(root, lastValue)
	}
	
	boolean checkBst(TreeNode node, Integer lastValue) {
		
		if(node == null) {
			return true	
		}
		
		if(!checkBst(node.left, lastValue)) {
			return false
		}
		
		if(node.data < lastValue) {
			return false	
		}
		
		lastValue = node.data
		
		if(!checkBst(node.right,lastValue)) {
			return false
		}
		
		return true
	}
	
	void mirror() {
		mirror(root)
	}
	
	void verticalsum() {
		HashMap columns = new HashMap()
		sum(root, 0, columns)
		println columns	
	}
	
	void zigzag() {
		zigZag(root)
	}
	
	void zigZag(TreeNode root) {
		java.util.Stack currentLevel = new java.util.Stack()
		java.util.Stack nextLevel = new java.util.Stack()
		boolean leftToRight = true;
		currentLevel.push(root);
		while (!currentLevel.isEmpty()) {
		  TreeNode currNode = currentLevel.pop();
		  if (currNode) {
			println currNode.data 
			if (leftToRight) {
			  nextLevel.push(currNode.left)
			  nextLevel.push(currNode.right)
			} else {
			  nextLevel.push(currNode.right)
			  nextLevel.push(currNode.left)
			}
		  }
		  if (currentLevel.isEmpty()) {
			leftToRight = !leftToRight;
			currentLevel = nextLevel
			nextLevel = currentLevel
		  }
		}
	  }
	
	void sum(TreeNode n, int column, HashMap columns) {
		if(n == null) {
			return;
		}
		
		if(columns.containsKey(column)) {
			int val = columns.get(column) + n.data
			columns.put(column, val)
		} else {
			columns.put(column, n.data)
		}
		sum(n.left, column--, columns)
		sum(n.right, column++, columns)
	}
	
	void formList(TreeNode node, LinkedList list) {
		if(node != null) {
			list.add(node)
			formList(node.left, list)
			formList(node.right, list)
		}
	}
	
	void mirror(TreeNode n) {
		if(n != null) {
			TreeNode tmp = n.left;
			n.left = n.right;
			n.right = tmp;
			mirror(n.left);
			mirror(n.right);
		}
	}
	
	void display() {
		println "In Order Traversal"
		displayInOrder(root)
		println "Pre Order Traversal"
		displayPreOrder(root)
		println "Post Order Traversal"
		displayPostOrder(root)
	}
	
	void displayLevelOrder() {
		if(root != null) {
			LinkedList queue = new LinkedList()
			queue.add(root)
			int level = 0
			while(!queue.isEmpty()) {
				TreeNode n = queue.remove()
				if(n != null) {
					if(n.left) {
						queue.add(n.left)
					}
					
					if(n.right) {
						queue.add(n.right)
					}
					
					if(n.left || n.right) {
						level++
						println "Level is ->" + level
					}
				}
			}
		}
	}
	
	void displayInOrder(TreeNode node) {
		if(node != null) {
			displayInOrder(node.left)
			println node.data
			displayInOrder(node.right)
		}
	}
	
	void displayPreOrder(TreeNode node) {
		if(node != null) {
			println node.data
			displayPreOrder(node.left)
			displayPreOrder(node.right)
		}
	}
	
	void displayPostOrder(TreeNode node) {
		if(node != null) {
			displayPostOrder(node.left)
			displayPostOrder(node.right)
			println node.data
		}
	}
}
