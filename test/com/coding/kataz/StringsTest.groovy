package com.coding.kataz;

import java.util.concurrent.ConcurrentHashMap.Values;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import groovy.util.GroovyTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringsTest extends GroovyTestCase {

	@Test
	public void testIfStringHasUniqueCharacters() {
		String value="his trng"
		assertEquals(true, hasUniqueCharacters(value))
	}
	
	@Test
	public void testReverseString() {
		String value="abcd"
		assertEquals("dcba", reverse(value))
		assertEquals("dcba", reverseWithoutStack(value))
		assertEquals("dcba", reverseWithFunctionStack(value))
	}
	
	@Test
	public void testRemoveDuplicatesFromString() {
		String value="abb"
		assertEquals("ab", removeDuplicates(value))
		assertEquals("ab", removeDuplicatesRecursively(value, new java.util.Stack()))
	}
	
	@Test
	public void testIfStringsAreAnagrams() {
		String value = "pat"
		String value2 = "tap"
		assertEquals(true, isAnagram(value,value2))
	}
	
	@Test
	public void testReplaceSpaceWithPercentage20() {
		String value = "I am   "
		assertEquals("I%20am", replaceSpaceWithPercentage20(value))
	}
	
	@Test
	public void testStringCompression() {
		String value = "aabcccccaaa"
		println compressString(value)
		//assertEquals("a2b1c5a3", compressString(value))
	}
	
	@Test
	void testFindSubstringInString() {
		String str = "helloslkhellodjladfjhello";
		Pattern p = Pattern.compile("hello");
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()){
			count +=1;
		}
		System.out.println(count);
	}
	
	String compressString(String value) {
		char [] values = value.toCharArray()
		char val = value.charAt(0)
		String result = ""
		int count = 1
		
		for (int i = 0; i < values.length; i++) {
			if(value.charAt(i) == val) {
				count++
			}
			else {
				result = result + val + count 
				println result
				val = value.charAt(i)
				count = 1
			}
		}
		result
	}
	
	String replaceSpaceWithPercentage20(String value) {
		char [] values = value.toCharArray()
		int  i = 0
		int length = value.length()
		int spaceCount = 0
		for (i = 0; i < values.length; i++) {
			if(i+1 < values.length) {
				if(values[i] == ' ' && values[i+1] != ' ') {
					spaceCount++
				}
			}
		}
		int newLength = (length - 1)  - (spaceCount * 3)
		int j = length - 1
		for (i = newLength; i >=0 ; i--) {
			if(values[i] == ' ') {
				values[j--] = '0'
				values[j--] = '2'
				values[j--] = '%'
			} else {
				values[j--] = values[i]
			}
			
			if(i == 0) {
				values[i] = 0
			}
		}
		values.toString().trim()
	}
	
	boolean isAnagram(String value, String value1) {
		Character [] val1 = value.toCharArray()
		Character [] val2 = value1.toCharArray()
		Arrays.sort(val1) 
		Arrays.sort(val2)  
		return Arrays.equals(val1,val2)
	}
	
	String removeDuplicates(String value) {
		Character [] values = value.toCharArray()
		int index = 0
		for (int i = 0; i < values.length; i++) {
			for (int j = i+1; j < values.length; j++) {
				if(values[i] == values[j]) {
					index = j
					values[j] = 0
					break;
				}
			}
		}
		String result = ""
		values.each {
			result += it
		}
		result.trim()
	}
	
	String removeDuplicatesRecursively(String value, java.util.Stack chars) {
		if(value.length() == 0) {
			String result = ""
			while (!chars.isEmpty()) {
				result += chars.pop()	
			}
			return result;
		}
		
		char val = value.charAt(value.length() - 1)
		if(!chars.contains(val)) {
			chars.push(val)
		}
		removeDuplicatesRecursively(value.substring(0, value.length() - 1), chars)
	}
	
	String reverse(String value) {
		Deque stack = new ArrayDeque()
		for (Character c : value) {
			stack.push(c.toString())
		}
		
		String reversed = ""
		while(stack.size() != 0) {
			reversed += stack.pop()
		}
		return reversed
	}
	
	String reverseWithoutStack(String value) {
		final char[] word = value.toCharArray();
		for (int i = value.length() - 1; i >=0 ; i --) {
			for (int j = i -1 ; j >=0; j--) {
				char x = word[i]
				word[i] = word[j]
				word[j] = x
			}
		}
		word.toString();
	}
	
	String reverseWithFunctionStack(String value) {
		if(value.length() == 0) {
			return ""
		}
		String val = value.charAt(value.length() - 1).toString()
		return val + reverseWithFunctionStack(value.substring(0, value.length()-1))
	}
	
	boolean hasUniqueCharacters(String value) {
		Set values = new HashSet()
		for (Character c : value) {
			def asciiValue = (int)c.charValue()
			if(values.add(asciiValue)) {
				continue
			} else {
				return false
			}
		}
		return true
	}
}