package com.coding.kataz;

import groovy.util.GroovyTestCase;

import org.junit.Test;

public class SortingTest extends GroovyTestCase {

	@Test
	public void testMergeSort() {
		int [] arr = [8,2,9,1,0,6,5]
		mergeSort(0, arr.length, arr);
	}
	
	void merge(int start, int end, int middle, int [] array) {
		int [] merged = new int[array.length]
		
		for(int i = start; i <end; i++ ) {
			merged[i] = array[i]
		}
		
		int mergedLeft = start
		int mergedRight =  middle+1
		int current = start
		
		while(mergedLeft <= middle && mergedRight <= end) {
				
		}
		
		println merged
	}
	
	void mergeSort(int start, int end, int [] arr) {
		if( start < end) {
			int middle = (start+end)/2
			mergeSort(start, middle, arr)
			mergeSort(middle+1, end, arr)
			merge(start, end, middle, arr)
		}
	}
}
