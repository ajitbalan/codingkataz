package com.coding.kataz

import org.junit.Test;

class CircularLinkedListTest extends GroovyTestCase {
	
	CircularLinkedList circularLinkedList 
	
	protected void setUp() throws Exception {
		circularLinkedList = new CircularLinkedList()
	}
	
	protected void tearDown() throws Exception {
		circularLinkedList = null
	}
	
	@Test
	void testAdd() throws Exception {
		circularLinkedList.add(10)
		circularLinkedList.add(20)
		circularLinkedList.display()
	}
	
	@Test
	void testGetRootNode() throws Exception {
		circularLinkedList.add(10)
		circularLinkedList.add(20)
		circularLinkedList.root()
	}
}