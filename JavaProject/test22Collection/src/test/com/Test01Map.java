package test.com;

import java.util.*;

public class Test01Map {
	// ���� ���� ���̴� ���
	
	public static void main(String[] args) {
		
		System.out.println("Map...");
		
		// ������ �Ǵµ� �����ϸ� string���� �޴� �� ����
		Map<String, String> map = new Hashtable<>();
		map.put("name", "kim");
		// put�� map, pop/push�� stack
		// shift�� �տ��� ���� ��
		// add, append, remove, clear
		
		System.out.println("map size1 : " + map.size());
		// = 1
		map.put("name", "kim2");
		map.put("name", "kim3");
		map.put("name", "kim4");
		System.out.println("map size2 : " + map.size());
		// key�� �ߺ��� ������� �����Ƿ� �Ȱ��� 1 ���
		
		map.put("name2", "kim2");
		map.put("name3", "kim3");
		System.out.println("map size3 : " + map.size());
		// = 3
		System.out.println("--------------");
		// ���� ��� >> set�� ������ ������ �׳� ����
		Set<String> s = map.keySet();
		for(String key : s) {
			System.out.println(key + " = " + map.get(key));
		}
		System.out.println("--------------");
		// �ϳ��� ���
		System.out.println(map.get("name3"));

	}		// end of main

}		// end of class
