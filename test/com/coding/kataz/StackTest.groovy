package com.coding.kataz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackTest extends GroovyTestCase {
	
	Stack stack

	@Before
	public void setUp() throws Exception {
		stack = new Stack()
	}

	@After
	public void tearDown() throws Exception {
		stack = null
	}
	
	@Test
	public void testPush() {
		stack.push(10)
		stack.push(20)
		stack.push(30)
		stack.display()
	}
	
	@Test
	public void testPop() {
		stack.push(10)
		stack.push(20)
		stack.push(30)
		stack.pop()
		stack.pop()
		stack.pop()
		stack.display()
		
	}

	@Test
	public void testArrayBackedStack() {
		ArrayBackedStack stack = new ArrayBackedStack(3)
		stack.push(0, 10)
		stack.push(0, 20)
		stack.push(0, 30)
//		stack.push(0, 40)
		stack.push(1, 50)
		stack.push(1, 60)
		stack.display(0)
		stack.display(1)
//		stack.display(2)
//		stack.pop(0)
//		stack.pop(1)
//		stack.pop(2)
//		stack.display(0)
//		stack.display(1)
//		stack.display(2)
	}
}
