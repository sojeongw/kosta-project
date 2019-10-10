package test.com;

import java.util.*;

public class Test01List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("list...");

		List<Integer> list = new ArrayList</* Integer ������ ������ ���� ����. ���� ������ �� ����� ��. */>();
		// �͸� ���� Ŭ���� >> override �� �� ������ ��ӹ��� Ŭ������ �������ش�.
		// 5�������� <>�� ���� ���̱� ������ ���� �������� ���� �� �ȴ�.
		// <>�� �ڹ��� ���׸��̶�� �θ���.
		// �� ó���� ���� Ÿ�����θ� �߾�� �ߴµ� �װ� ������ �˾ƺ��� ����
		// �ƿ� ó���� Ÿ���� ������ִ� ��.

		List<String> list2 = new ArrayList<>();
		List<Test01VO> list3 = new ArrayList<>();
		// System.out.println(list3.size());
		// =0 ���⼭ �߰���Ű�� �߰���Ű�� �����̴�.
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		System.out.println(list3.size());

		// ���� ���
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) ���� ����
		}
		System.out.println("------------for 1");
		// �ٸ� ���. ������� ������� ����Ѵ�
		for (Test01VO vo : list3) {
			System.out.println(vo);
		}
		System.out.println("------------for 2");
		// ����
		list3.remove(3); // 4��°�� ����
		// �ٽ� ���� ���
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) ���� ����
		}
		System.out.println("------------");
		// 3���� null�� �ٲٱ�
		list3.set(3, null);
		// �ٽ� ���
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) ���� ����
		}
		System.out.println("------------");
		// list3�� �ִ� �� �� ����
		list3.clear();
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) ���� ����
		}
		System.out.println("------------");

		// Test01VO[] vos = new Test01VO[10]; 2���� �迭
		List<Test01VO[]> list4 = new ArrayList<>(); // 3���� �迭

		// ArrayList�� �����ϴµ� ���׸��� ���� ���� ���� Ÿ���̶�� ArrayList�� �����غ��� ���� �� �ִ�

		
		
		
		////////////////////////////////
		Vector<Test01VO> vec = new Vector<Test01VO>();
		vec.add(new Test01VO());
		vec.add(new Test01VO());
		vec.add(new Test01VO());
		System.out.println(vec.size());
		System.out.println(vec.capacity());
		// =10 10���� �� �������� �ڵ����� capacity�� �þ��. size�� ���� ��� ����.
		vec.ensureCapacity(100);
		System.out.println(vec.capacity());
		
		System.out.println("------------");

		////////////////////////////////
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1000);
		stack.add(2000);
		stack.add(3000);
		stack.add(4000);
		stack.push(5000);	// push�ε� �� �Է� ����
		for(int i=0; i<stack.size(); i++) {
			System.out.println(stack.get(i));
		}
		System.out.println("------------");
		System.out.println(stack.pop());
		// �������� �� �� ���´� = Last In First Out >> LIFO
		// �ݴ�� First In First Out >> FIFO
		
		
		

	}

}
