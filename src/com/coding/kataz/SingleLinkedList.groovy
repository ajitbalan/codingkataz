package com.coding.kataz

class SingleLinkedList {
	
	Node head
	
	void add(Node n) {
		if(head == null) {
			head = n
		} else {
			head.add(n)
		}
	}
	
	void add(int data) {
		Node n = head
		if(n == null) {
			n = new Node(data)
			head = n
		} else {
			n.add(data)
		}
	}
	
	void enqueue(int data) {
		add(data)
	}
	
	void dequeue() {
		Node n = head
		if(n == null) {
			return ;
		} else {
			Node temp = head.next
			head = null
			head = temp
		}
	}
	
	void delete(int data) {
		Node n = head
		if(n !=null && n.next == null && n.data == data) {
			head = null
			return
		}
		
		if(n != null && n.data == data) {
			head = n.next
			return
		}
		
		n.delete(head, data)
	}
	
	void removeDuplicates() {
		Node current = head
		Node next = current.next
		while(current != null && next != null ) {
			if(current.data == next.data) {
				delete(current.data)
				current = current.next
			}
			next = next.next
		}
	}
	
	List findNthElementToLastElement(int data) {
		getNodes(data)
	}
	
	List getNodes(int data) {
		Node n = head
		Node temp
		List nodes = new ArrayList()
		while(n != null) {
			if(n.data == data) {
				temp = n
				while(temp != null) {
					nodes << temp
					temp = temp.next
				}
			}
			n = n.next
		}
		nodes
	}
	
	SingleLinkedList partition(int data) {
		SingleLinkedList before = new SingleLinkedList()
		SingleLinkedList after = new SingleLinkedList()
		Node n = head
		while(n != null) {
			if(n.data < data) {
				before.add(n.data)
			} 
			else{
				after.add(n.data)
			}
			n = n.next
		}
		
		Node beforeEnd = before.getHead()
		while(beforeEnd.next != null) {
			beforeEnd = beforeEnd.next
		}
		beforeEnd.next = new Node(data)
		beforeEnd.next.next = after.head
		before
	}
	
	SingleLinkedList sum(SingleLinkedList list1, SingleLinkedList list2) {
		SingleLinkedList result = new SingleLinkedList()
		addLists(list1.head,list2.head, 0, result)
		result.display()
	}
	
	SingleLinkedList clone(SingleLinkedList list) {
		SingleLinkedList clonedList = new SingleLinkedList()
		Node n = list.head
		
		while(n != null) {
			clonedList.add(n.data)
			n = n.next
		}
		clonedList
	}
	
	Node addLists(Node list1, Node list2, int carry, SingleLinkedList list) {
		if(list1 == null && list2 == null && carry == 0) {
			return null 
		}
		
		int value = carry
		if(list1 != null) {
			value += list1.data
		}
		
		if(list2 != null) {
			value += list2.data
		}
		
		Node result = new Node(0)
		result.data = value % 10
		
		if(list1 != null || list2!= null || value >=10) {
			Node more = addLists(list1.next, list2.next, value>=10 ? 1 : 0, list)
			result.next = more
		}
		list.add(result)
		result
	}
	
	void display() {
		Node n = head
		while(true) {
			if(n != null && n.next == null) {
				println n.data
				break
			}
			if(n != null) {
				println n.data
				n = n.next
			} else {
				break
			}
		}
	}
}
