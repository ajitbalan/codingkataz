package com.coding.kataz;

import groovy.util.GroovyTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest extends GroovyTestCase {

	SingleLinkedList linkedList 
	
	@Before
	public void setUp() throws Exception {
		linkedList = new LinkedList()
	}

	@After
	public void tearDown() throws Exception {
		linkedList = null
	}

	@Test
	public void testEnqueue() {
		linkedList.enqueue(10)
		linkedList.enqueue(20)
		linkedList.enqueue(30)
		linkedList.display()
	}
	
	@Test
	public void testDequeue() {
		linkedList.enqueue(10)
		linkedList.enqueue(20)
		linkedList.enqueue(30)
		linkedList.dequeue()
		linkedList.dequeue()
		linkedList.display()
		
	}

}
