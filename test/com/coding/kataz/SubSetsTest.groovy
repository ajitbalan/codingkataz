package com.coding.kataz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SubSetsTest extends GroovyTestCase {

	@Test
	public void testPowerSet() {
		Set full = new HashSet()
		full.add(10)
		full.add(20)
		full.add(30)
		full.add(40)
		println powerSet(full)
	}
	
	@Test
	public void testCombinationsWithNumbers() {
		List numbers = new ArrayList()
		numbers.add(10)
		numbers.add(20)
		numbers.add(30)
		numbers.add(40)
		println combinations(numbers)
	}
	
	@Test
	public void testCombinationsWithStrings() {
		List numbers = new ArrayList()
		numbers.add("10")
		numbers.add("20")
		numbers.add("30")
		numbers.add("40")
		println combinations(numbers)
	}
	
	@Test
	public void testCombinationsWithoutRecursion() {
		List numbers = new ArrayList()
		numbers.add("10")
		numbers.add("20")
		numbers.add("30")
		numbers.add("40")
		println combinationsWithoutRecursion(numbers)
	}
	
	
	List<List> combinationsWithoutRecursion(List numbers) {
		List<List> combinationList = new ArrayList<List>()
		if(numbers.isEmpty()) {
			combinationList.add(new ArrayList<List>())
			return combinationList
		}
		
		List list = new ArrayList(numbers)
		for(int i = 0; i < Math.pow(2, list.size()); i++) {
			List newList = new ArrayList()
			newList.add(list[i])
			for (int j=1; j <= list.size(); j++) {
				newList.add(list[j])
			}
			combinationList.add(newList)
		}
		combinationList
	}
	
	List<List> combinations(List numbers) {
		List<List> combinationList = new ArrayList<List>()
		if(numbers.isEmpty()) {
			combinationList.add(new ArrayList<List>())
			return combinationList
		}
		
		List list = new ArrayList(numbers)
		Object first = list.get(0)
		List rest = new ArrayList(list.subList(1, list.size()))
		for (List obj : combinations(rest)) {
			List newList = new ArrayList()
			newList.add(first)
			newList.addAll(obj)
			combinationList.add(newList)
			combinationList.add(obj)
		}
		combinationList
	}
	
	public Set<Set> powerSet(Set originalSet) {
        Set<Set> sets = new HashSet<Set>()
        if (originalSet.isEmpty()) {
            sets.add(new HashSet())
            return sets
        }
        List list = new ArrayList(originalSet)
        Object head = list.get(0);
        Set rest = new HashSet(list.subList(1, list.size()))
        for (Set set : powerSet(rest)) {
            Set newSet = new HashSet()
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
