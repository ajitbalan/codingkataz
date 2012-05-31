package com.coding.kataz

class CircularLinkedList {
	
	Node head
	
	void add(int data) {
		Node n = head
		if(n == null) {
			n = new Node(data)
			head = n
		} else {
			n.add(data)
			while(n.next != null) {
				n = n.next
			}
			n.next = head
		}
	}
	
	Node root() {
		Node n = head
		Node n2 = head.next
		while(true) {
			if(n != null && n2 != null && n == n2) {
				println n.data
				break;
			}
			n2 = n2.next
		}
		n
	}
	
	void display() {
		Node n = head
		while(true) {
			if(n != null && n.next == head) {
				println n.data
				break;
			}
			
			if(n!= null && n.next != head) {
				println n.data
			}
			
			n = n.next
		}
	}
}
