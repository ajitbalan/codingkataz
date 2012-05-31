package com.coding.kataz

class Node {
	
	Node next
	int data
	int carry
	
	Node(int data) {
		this.data = data
	}
	
	void add(Node n) {
		Node node = this
		while(node.next != null) {
			node = node.next
		}
		node.next = n
		node.next.next = null
	}
	
	void add(int value) {
		Node n = this
		while(n.next != null) {
			n = n.next
		}
		n.next = new Node(value)
	}
	
	void delete(Node head, int value) {
		Node n = head
		Node prev
		Node current
		while(true) {
			
			if(n != null && n.next != null && n.next.data == value) {
				prev = n
				next = n.next.next
				prev.next = next
				break
			}
			
			n = n.next
		}
	}
	
	public String toString() {
		return data
	}
}