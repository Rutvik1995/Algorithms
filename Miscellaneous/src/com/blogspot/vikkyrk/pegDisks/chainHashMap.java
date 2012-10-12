package com.blogspot.vikkyrk.pegDisks;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class chainHashMap<K> {

	HashMap<K,ArrayList<K>> hMap;
	
	public chainHashMap() {
		hMap = new HashMap<K,ArrayList<K>>(6,1);
	}
	
	public void put(K key) {
		ArrayList<K> value = hMap.get(key);
		if(value == null) {
			value = new ArrayList<K>();
			value.add(key);
			hMap.put(key,value);
		} else if(!contains(key)) {
			System.out.println("Collision in Hash");
			value.add(key);
		}
	}
     
	public boolean contains(K key) {
		if(hMap.containsKey(key)) {
			ArrayList<K> aList = hMap.get(key);
			Iterator<K> iter = aList.iterator();
			while(iter.hasNext()) {
				if(iter.next().equals(key))
					return true;
			}
		} 
		
		return false;
	}
	
	@Override
	public String toString() {
		Collection<ArrayList<K>> values = hMap.values();
		Iterator<ArrayList<K>> iter = values.iterator();
		String result = "";
		while(iter.hasNext()) {
			result+= "(";
			result+= iter.next().toString();
			result+= ")\n";
		}
		
		return result;
	}
}
