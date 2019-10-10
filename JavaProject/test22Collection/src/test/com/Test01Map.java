package test.com;

import java.util.*;

public class Test01Map {
	// 정말 많이 쓰이는 기능
	
	public static void main(String[] args) {
		
		System.out.println("Map...");
		
		// 정수도 되는데 웬만하면 string으로 받는 게 좋다
		Map<String, String> map = new Hashtable<>();
		map.put("name", "kim");
		// put은 map, pop/push는 stack
		// shift는 앞에서 빼는 것
		// add, append, remove, clear
		
		System.out.println("map size1 : " + map.size());
		// = 1
		map.put("name", "kim2");
		map.put("name", "kim3");
		map.put("name", "kim4");
		System.out.println("map size2 : " + map.size());
		// key의 중복을 허락하지 않으므로 똑같이 1 출력
		
		map.put("name2", "kim2");
		map.put("name3", "kim3");
		System.out.println("map size3 : " + map.size());
		// = 3
		System.out.println("--------------");
		// 각자 출력 >> set은 순서가 없으니 그냥 나옴
		Set<String> s = map.keySet();
		for(String key : s) {
			System.out.println(key + " = " + map.get(key));
		}
		System.out.println("--------------");
		// 하나만 출력
		System.out.println(map.get("name3"));

	}		// end of main

}		// end of class
