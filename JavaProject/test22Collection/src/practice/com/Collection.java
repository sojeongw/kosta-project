package practice.com;

import java.util.*;

public class Collection {
	public static void main(String[] args) {
	
	List<Integer> list = new ArrayList<>();
	System.out.println(list.size());
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(8);
	System.out.println(list.size());
	for(Integer i : list) {
		System.out.println(list);
	}

	list.remove(1);
	for(Integer i : list) {
		System.out.println(list);
	}
	
	list.set(2, 15);
	for(Integer i : list) {
		System.out.println(list);
	}
	
	
	
	}	
}
