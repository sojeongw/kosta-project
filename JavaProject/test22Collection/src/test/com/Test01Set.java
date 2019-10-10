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
		// =1	�ߺ��Ǵϱ� 1
		System.out.println("--------------");
		// �߰�
		set.add(20000);
		set.add(20000);
		System.out.println("set size() : " + set.size());
		System.out.println("--------------");
		// ����
		set.remove(10000);
		System.out.println("set size() : " + set.size());
		System.out.println("--------------");
		
		set.add(30000);
		set.add(80000);
		set.add(10500);
		set.add(10000);
		set.add(90020);
		
		// Iterator
		// �̷��� ��ȯ�� �Ǿ�߸� �ݺ����� ���� �� �ִ�.
		// add �ϰ� ���� �ؾߵ�. �־���� �������� ����.
		Iterator<Integer> it = set.iterator();
		// while�� �̿��� �ݺ���
		while (it.hasNext()) {		// ������ �� ������ true �ƴϸ� false
			Integer data = (Integer) it.next();
			System.out.println(data);
		}
		System.out.println("--------------");
		// for�� �̿��� �ݺ���. for each for
		// set�� ������� ������ ���� ������ ������� ���´ٴ� ������ ����.
		for(Integer data : set) {
			System.out.println(data);
		}
		
		
		
		
		
		
		
	}

}
