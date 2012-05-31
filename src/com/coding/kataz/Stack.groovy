package com.coding.kataz

class Stack {
	
	Node head
	int size = 0
	
	void push(int data) {
		Node n = head
		if(n == null) {
			n = new Node(data)
			head = n
		} else {
			n = new Node(data)
			n.next = head
			head = n
		}
		size++
	}
	
	Node pop() {
		Node n = head
		Node temp
		while(true) {
			if(n != null && n.next != null) {
				temp = head.next
				head = temp
				temp = null
				n = n.next
				break
			}
			
			if(n != null && n.next == null) {
				head = null
				break
			}
		}
		size--
	}
	
	boolean isEmpty() {
		return size == 0
	}
	
	void display() {
		Node n = head
		while(true) {
			if(n!= null) {
				println n.data
				n = n.next
			} else {
				break
			}
		}
	}
}
