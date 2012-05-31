package com.coding.kataz;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

public class ParenthesisTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidParenthesis() {
		//brackets(3, 0, "");
		bracketsWithoutRecursion(3, "");
	}
	
	void bracketsWithoutRecursion(int pair, String value) {
		List bits = new ArrayList ()
		int comboSize = (int)Math.pow(pair,2)
		List validCombinations = new ArrayList()
		for (int a = 0; a < comboSize; a++) {
			bits.add(0)
		}
		for (int i=0; i < Math.pow(2,pair); i++) {
				for (int j = 0; j < pair; j++) {
					bits[i] = 1
					 for (int k = 1; k <= pair; k++) {
						 List combo = new ArrayList()
						 combo.add(bits[i])
						 bits[k] = 0
						 combo.addAll(bits.subList(k, bits.size() - 1))
						 validCombinations.add(combo)
					 }
				}
		}
		println validCombinations
	}

   void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if (openStock > 0) {
            brackets(openStock-1, closeStock+1, s + "(");
        }
        if (closeStock > 0) {
            brackets(openStock, closeStock-1, s + ")");
        }
    }
   

}