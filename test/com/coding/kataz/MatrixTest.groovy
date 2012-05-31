package com.coding.kataz;

import junit.framework.Test;
import groovy.util.GroovyTestCase;

public class MatrixTest extends GroovyTestCase {

	int [][] matrix = new int [3][3]
	
	@Override
	protected void setUp() throws Exception {
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = Math.random() * 10
			}
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
		matrix = null
	}
	
	@org.junit.Test
	void testSetRowAndColumnToZeroIfElementIsZero() throws Exception {
		boolean [] rows = new boolean [matrix.length]
		boolean [] columns = new boolean [matrix[0].length] 
		println matrix
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = true
					columns[j] = true
				}
			}
		}
		
		for (int i=0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(rows[i] || columns[j]) {
					matrix[i][j] = 0
				}
			}
		}
		println matrix
	}
}
