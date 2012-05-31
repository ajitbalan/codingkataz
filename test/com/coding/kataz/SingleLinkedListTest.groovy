package com.coding.kataz;

import org.junit.Test;

import groovy.util.GroovyTestCase;

public class SingleLinkedListTest extends GroovyTestCase {
	
	SingleLinkedList linkedList
	
	protected void setUp() throws Exception {
		linkedList = new SingleLinkedList()	
	}
	
	protected void tearDown() throws Exception {
		linkedList = null
	}

	@Test
	void testAdd() throws Exception {
		linkedList.add(10)
		linkedList.add(20)
		linkedList.add(30)
		linkedList.display()
	}
	
	@Test
	void testDelete() throws Exception {
		linkedList.add(10)
		linkedList.add(20)
		linkedList.delete(20)
		linkedList.delete(10)
		linkedList.display()
	}
	
	@Test
	void testRemoveDuplicates() throws Exception {
		linkedList.add(10)
		linkedList.add(30)
		linkedList.add(20)
		linkedList.add(10)
		linkedList.add(30)
		linkedList.add(20)
		linkedList.removeDuplicates()
		linkedList.display()
	}
	
	@Test
	void testFindNthElementToLastElement() throws Exception {
		linkedList.add(10)
		linkedList.add(30)
		linkedList.add(20)
		println linkedList.findNthElementToLastElement(10)
	}
	
	@Test
	void testPartitionLinkedListAroundValue() throws Exception {
		linkedList.add(10)
		linkedList.add(30)
		linkedList.add(20)
		linkedList = linkedList.partition(20)
		linkedList.display()
	}
	
	
	@Test
	void testSummationOfLinkedList() throws Exception {
		SingleLinkedList list1 = new SingleLinkedList()
		SingleLinkedList list2 = new SingleLinkedList()
		SingleLinkedList list3 = new SingleLinkedList()
		list1.add(7)
		list1.add(1)
		list1.add(6)
		
		list2.add(5)
		list2.add(9)
		list2.add(2)
		
		list3.sum(list1, list2)
	}
	
	void testClone() throws Exception {
		SingleLinkedList list = new SingleLinkedList()
		
		linkedList.add(10)
		linkedList.add(30)
		linkedList.add(20)
		
		list.clone(linkedList).display()
	}
}