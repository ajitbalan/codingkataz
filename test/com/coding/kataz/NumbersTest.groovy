package com.coding.kataz;

import org.junit.Test;

public class NumbersTest {

	@Test
	public void testFindMissingNumber() {
		int [] arr = [1,2,3,5,6,7,8];
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
		    if (arr[i] == 0) {
		         idx = i; 
		    } else {
		         sum += arr[i];
		    }
		}

		// the total sum of numbers between 1 and arr.length.
		int total = (arr.length + 1) * arr.length / 2;

		System.out.println("missing number is: " + (total - sum) + " at index " + idx);
	}
	
	@Test
	public void testFindFactorsOfANumber() {
		int [] arr = [1,2,3,5,6,7,8];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 1 && arr[i] % 2 == 0) {
				 println "factor of 2 ->" + arr[i]
			}
			if (arr[i] > 1 && arr[i] % 3 == 0) {
				println "factor of 3 ->"  + arr[i]
			}
		}
	}
	
	@Test
	public void testFindPrimeNumbers() {
		int [] arr = [1,2,3,5,6,7,8];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				 println "prime number  ->" + arr[i]
			}
		}
	}
	
	@Test
	public void testFindPrimeFactorsOfANumber() {
		int [] arr = [1,2,3,5,6,7,8];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 2; j <= (arr[i])/2; j++) {
				if(arr[i] > 1) {
					if (arr[i] % 2 != 0) {
						println "prime factors of  ${arr[i]} ->" + i
				   }
				}
			}
		}
	}
	
	@Test
	public void testGreatestCommonDivisor() {
		println gcd(100 , 33)
	}
	
	
	@Test
	public void testSumTwoNumbers() {
		int X = 0,Y = 0,A = 0, B = 0;
		println "sum=" + add(10,5)
	}
	
	@Test
	public void testSubtractTwoNumbers() {
		int x = 10, y = 5
		println "sub=" + sub(x,y)
	}
	
	@Test
	public void testDivideTwoNumbers() {
		int x = 10, y = 5 
		println "division=" + div(x,y)
	}
	
	@Test
	public void testMultiplyTwoNumbers() {
		int x = 10, y = 5
		println "multiply=" + multiply(x,y)
	}
	
	
	int add (int x, int y) {
		int carry = 0;
	    int result = 0;
	    int i;
	
	    for(i = 0; i < 32; ++i) {
	        int a = (x >> i) & 1;
	        int b = (y >> i) & 1;
	        result |= ((a ^ b) ^ carry) << i;
	        carry = (a & b) | (b & carry) | (carry & a);
	    }
		return result
	}
	
	int sub(int a, int b) {
		return add(a , add(~b, 1)) 
	}
	
	int gcd(int a, int b) {
		
		if(b == 0) {
			return a
		}
		
		else {
			return gcd(b , a % b)	
		}
		
	}
	
	int multiply(int x, int y) {
		int product=0;
		while (y!=0) {
			if(y&01)
				product=product+x;
			x<<=1;
			y>>=1;
		}
		return product;
		
	}
	
	
	int div(int a, int b) {
		if(!b) return -1;
		if(a<b) {
			println "remainder " +  "$a, $b, 0, $a"
			return 0;
		}
		int q = 1,  d=1, t=d;
		while (t<a) {
			d=t;
			t=t<<2;
			q=q<<1;
		}
		while (d+b<a) {
			d=d+b;
			++q;
		}
		println "remainder " + "$a, $b, $q, ${a-d}"
		return 0;
	}
}
