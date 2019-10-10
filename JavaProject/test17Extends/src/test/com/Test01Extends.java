package test.com;

// import java.lang.*; �� �����Ǿ� �ִ� ��. ���⿣ StringBuilder, StringBuffer, Boolean...etc

public class Test01Extends { // extends Object{�� �����Ǿ� ����

	public Test01Extends() {
		// ���ο��� ��ü ������ �ϰ� ������ �ҷ�����
		// Object obj = new Object(); �� ���� �ǰ� �ٷ� getClass() ���

		getClass();
		System.out.println(/* obj. */getClass());
	}

	public static void main(String[] args) {
		// private�� protected�� ���� ����ʵ�� Ŭ������ �ٴ´�.
		// ������ : modifier. public�̶�� ������ ���� ������ ����. �ƿ� ���ٰ� ������ ���°� �ƴ�.
		// abstract
		// final
		// �θ���� superclass, ������ interface
		// �ڹ��� �ܱ�, ���� ������ java.lang.Object

		System.out.println("extends...");
		System.out.println();
		// 4�� �ڿ� : ��� �ʵ�, ������, �޼ҵ�, Ŭ����
		// static���� non-static�� �� �ҷ��� �� ��ü ���� ����� �Ѵ�.
		// ����� �� �ϸ� �� ��ü�� �����ؼ� �ҷ��;� �Ѵ�.

		// ������ static�ε� ����ʵ��� �����ڴ� �ƴϹǷ� ��ü ���� �� �ҷ���
		Test01Extends ex = new Test01Extends();
		System.out.println();

		// ���� �����̶� ������ this. �ƺ����� super.
		// ����� �ϸ� super class�� �ִ� �ڿ��� �� ������ �ȴ�.
		// �Ӽ��� ���� �ʴ� �� ��ü�� ���̵�!
		// �׳� �����ϰ� ������ ��ü �����ؼ� . ��� ����Ѵ�.
		// ��� ������ : final�� ���̸� ���� �����̱� ������ ����� �� ����.
		// final �Ǿ� ������ �׳� new ���� ���� ��. ����� new�� ���ص� �ȴٴ� �� ������ ��.
		// ���� ����� ���� �ҽ��� final�� �Ǿ��־ method ��ü�� �� �������� �������� �����ϸ� ��.

		// me�� ��ӹ��� father �����ڱ��� ����
		Test01Me me = new Test01Me();
		System.out.println();
		// ���� ��ӹ��� Ŭ������ �ڿ��� ��� ����. ���� father ��ü �����ؼ� �ᵵ ��.
		// ��, super class�� final�� ���� �Ұ��ϴ�.
		System.out.println(me.lastName);
		System.out.println();
		
		// ��ӹ��� Ŭ������ �����ڱ��� ����
		Test01Child child = new Test01Child();
		System.out.println(child.lastName);
		
		System.out.println();
		
		
		// ����� ������ �������� �̿��� ��ü ����
		// ���� ��ӿ��� �ڿ������� �������� �����´�.
		// ���� Ŭ���� ��ü�� ����� �� �� ������ �����ڷ� ���� �� �ִ�.
		Test01Father father = new Test01Me();
		// father�� call �ǰ� me�� call �� >> �� ���� ��� ������ �ǹ�
		// = ����� ��� �θ� �ڽ� Ŭ������ ��ü�� ������ �� �ִ�.
		// super�� �ڽĲ� �� �� ����. �ڱ� �͸� ����ؾ� �Ѵ�.
		
		// ��ü�� ������ �� ������ �� �� �ִ� �� ����� father�� me �͸� ��� �����ϴ�.
		Test01Me me2 = new Test01Child();
		
		
		// ���ڵ� ��ü ���� ����. ������ ������ �ڱ� �͸� ��� ����.
		Test01Father father2 = new Test01Child();
		System.out.println(father2.lastName);
		
		// >> Ÿ���� �ڱ� �ڽ��̹Ƿ� �ƹ��� �ڽ� ������ ���� �ڱ� �͸� �� �� �ִ�.
		// ����� super�� Ÿ���̶�� �� �� �ִ�. ��ü ���� ��� ���� ��Ӹ� �ϸ�.
		// ex. child�� father, me Ÿ�� / me�� father Ÿ�� / child, me, father�� object Ÿ��
		
		
		

	} // end of main

} // end of class
