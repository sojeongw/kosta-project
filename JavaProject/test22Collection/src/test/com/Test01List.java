package test.com;

import java.util.*;

public class Test01List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("list...");

		List<Integer> list = new ArrayList</* Integer 버전이 높으면 생략 가능. 하위 버전은 꼭 써줘야 함. */>();
		// 익명 내부 클래스 >> override 할 게 많으니 상속받은 클래스로 생성해준다.
		// 5버전부터 <>가 생긴 것이기 때문에 옛날 버전에선 쓰면 안 된다.
		// <>를 자바의 제네릭이라고 부른다.
		// 맨 처음에 넣은 타입으로만 했어야 했는데 그걸 일일이 알아보기 힘들어서
		// 아예 처음에 타입을 명시해주는 것.

		List<String> list2 = new ArrayList<>();
		List<Test01VO> list3 = new ArrayList<>();
		// System.out.println(list3.size());
		// =0 여기서 추가시키고 추가시키는 개념이다.
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		list3.add(new Test01VO());
		System.out.println(list3.size());

		// 내용 출력
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) 형식 주의
		}
		System.out.println("------------for 1");
		// 다른 방법. 집어넣은 순서대로 출력한다
		for (Test01VO vo : list3) {
			System.out.println(vo);
		}
		System.out.println("------------for 2");
		// 삭제
		list3.remove(3); // 4번째꺼 삭제
		// 다시 내용 출력
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) 형식 주의
		}
		System.out.println("------------");
		// 3번을 null로 바꾸기
		list3.set(3, null);
		// 다시 출력
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) 형식 주의
		}
		System.out.println("------------");
		// list3에 있는 걸 싹 지워
		list3.clear();
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i)); // get(i) 형식 주의
		}
		System.out.println("------------");

		// Test01VO[] vos = new Test01VO[10]; 2차원 배열
		List<Test01VO[]> list4 = new ArrayList<>(); // 3차원 배열

		// ArrayList를 선언하는데 제네릭에 넣을 수가 없는 타입이라면 ArrayList로 선언해보면 나올 수 있다

		
		
		
		////////////////////////////////
		Vector<Test01VO> vec = new Vector<Test01VO>();
		vec.add(new Test01VO());
		vec.add(new Test01VO());
		vec.add(new Test01VO());
		System.out.println(vec.size());
		System.out.println(vec.capacity());
		// =10 10보다 더 많아지만 자동으로 capacity가 늘어난다. size랑 전혀 상관 없다.
		vec.ensureCapacity(100);
		System.out.println(vec.capacity());
		
		System.out.println("------------");

		////////////////////////////////
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1000);
		stack.add(2000);
		stack.add(3000);
		stack.add(4000);
		stack.push(5000);	// push로도 값 입력 가능
		for(int i=0; i<stack.size(); i++) {
			System.out.println(stack.get(i));
		}
		System.out.println("------------");
		System.out.println(stack.pop());
		// 마지막에 들어간 게 나온다 = Last In First Out >> LIFO
		// 반대는 First In First Out >> FIFO
		
		
		

	}

}
