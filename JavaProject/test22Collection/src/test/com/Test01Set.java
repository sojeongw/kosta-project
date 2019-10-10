package test.com;

import java.util.*;

public class Test01Set {
	
	public static void main(String[] args) {
		System.out.println("set...");
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(10000);
		set.add(10000);
		set.add(10000);
		set.add(10000);
		set.add(10000);
		System.out.println("set size() : " + set.size());
		// =1	중복되니까 1
		System.out.println("--------------");
		// 추가
		set.add(20000);
		set.add(20000);
		System.out.println("set size() : " + set.size());
		System.out.println("--------------");
		// 삭제
		set.remove(10000);
		System.out.println("set size() : " + set.size());
		System.out.println("--------------");
		
		set.add(30000);
		set.add(80000);
		set.add(10500);
		set.add(10000);
		set.add(90020);
		
		// Iterator
		// 이렇게 반환이 되어야만 반복문을 돌릴 수 있다.
		// add 하고 나서 해야됨. 넣어놓고 수정하지 마라.
		Iterator<Integer> it = set.iterator();
		// while을 이용한 반복문
		while (it.hasNext()) {		// 가져올 게 있으면 true 아니면 false
			Integer data = (Integer) it.next();
			System.out.println(data);
		}
		System.out.println("--------------");
		// for를 이용한 반복문. for each for
		// set은 집어넣은 순서가 없기 때문에 순서대로 나온다는 보장이 없다.
		for(Integer data : set) {
			System.out.println(data);
		}
		
		
		
		
		
		
		
	}

}
