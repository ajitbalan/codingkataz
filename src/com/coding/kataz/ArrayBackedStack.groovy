package com.coding.kataz

class ArrayBackedStack {
	
	int [] stack 
	int stackSize
	int [] stackPointer
	
	ArrayBackedStack(int size) {
		stackSize = size
		stack = new int [stackSize * 3]
		stackPointer = [0, 0, 0]
	}
	
	void push(int stackNo, data) {
		int index = stackNo * stackSize + stackPointer[stackNo] + 1
		stackPointer[stackNo]++
		println stackPointer[stackNo]
		stack[index] = data
		println stack
	}
	
	int pop(int stackNo) {
		int index = stackNo * stackSize + stackPointer[stackNo]
		stackPointer[stackNo]--;
		int value = stack[index];
		stack[index]=0;
		println stack
		return value;
	}
	
	void display(int stackNo) {
		int index = stackNo * stackSize + stackPointer[stackNo]
		println stack[index];
	}
}