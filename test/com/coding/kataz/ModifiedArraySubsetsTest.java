package com.coding.kataz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author ajit
 *
 */
public class ModifiedArraySubsetsTest  {
	
	public static void main(String[] args) {
		ModifiedArraySubsetsTest test = new ModifiedArraySubsetsTest();
		ArrayList<Integer> list  = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(4);
		
		ArrayList<Integer> subset = new ArrayList<Integer>();
		subset.add(1);
		subset.add(4);
		System.out.println(test.doSubsets(list, subset));
	}
	
	public List<List> doSubsets(List<Integer> list, List<Integer> subset) {
		HashMap<Integer,Object> allSubsets = new HashMap<Integer,Object>();
		int endRange = 0;
		int prevIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j=0; j < subset.size(); j++) {
				int value = subset.get(j);
				if(list.get(i) == value) {
					allSubsets.put(prevIndex, i);
					if(j == (subset.size() - 1)) {
						prevIndex = i;
						endRange = i;
						allSubsets.put(i, endRange);
					}
				}
				endRange++;
			}
		}
		return buildSubsets(list, allSubsets);
	}

	private List<List> buildSubsets(List<Integer> list,
			HashMap<Integer, Object> allSubsets) {
		List<List> sets = new ArrayList<List>();
		for (Integer position : allSubsets.keySet()) {
			int end = (Integer)allSubsets.get(position);
			if( position == 0) {
				sets.add(list.subList(position, end + 1));
			} else {
				sets.add(list.subList(position+1, end + 1));
			}
		}
		return sets;
	}
}