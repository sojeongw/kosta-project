package test.com;

import test.com.Test01Member.Test01Inner;

public class Test01Main {

	/* 4�� ���� ��� */
	// �Ӽ� : ��� �ʵ�, ���� ����

	// ���� : �޼ҵ�, �Լ�

	// ������ : constructor

	// Ŭ����
	// ���⿡�� ������ �� �ִ�
	Test01Anonymous3 am3 = new Test01Anonymous3() {

		@Override
		public void ccc() {
			// TODO Auto-generated method stub
			System.out.println("ccc()...");
		}

	};

	public static void main(String[] args) {

		// System.out.println("inner class");

		/*
		 * ���� Ŭ���� : Ŭ���� ���ο� Ŭ������ �����ϸ� ���� Ŭ���� = ��ø Ŭ����. nested / inner class
		 * 
		 * ��� ���� : �ܺ� Ŭ������ ���� �������� ��ü ���� ���� �����ϰ��� �� ��
		 * 
		 * inner class�� ��� ��� ����
		 */

		/*
		 * 1. member inner class �ƹ� �������� �׳� Ŭ���� �ϳ� �� ���� ��. public class Test01Member{
		 * public class Test01Inner2{ } }
		 * 
		 * default�� public�� �� inner class�� ��� �ҷ��� ���̳�?
		 */

		Test01Member mOuter = new Test01Member();
		mOuter.testOuter();

		// ù��° ���
		Test01Member.Test01Inner mInner1 = new Test01Member().new Test01Inner();
		Test01Member.Test01Inner mInner2 = mOuter.new Test01Inner();

		mInner1.testInner();
		System.out.println(mInner1.userName);

		// �ι�° ��� : main�� import test.com.Test01Member.Test01inner; �ϸ�
		// Test01Inner mIner2 = new Test01Inner(); ���� �� ����

		// 2. static inner
		System.out.println(Test01Static.Test01Inner.userName);
		System.out.println(Test01Static.Test01Inner.userName);

		// static class�� ������ ���� Ŭ���� �̸�. ����, ������.inner()�� �ƴ�!
		Test01Static.Test01Inner sInner1 = new Test01Static.Test01Inner();
		sInner1.testInner();

		// 3. local inner : �޼ҵ� �ȿ� Ŭ���� ����
		// final ��� ����

		// 4. �͸�(����) ���� Ŭ���� anonymous inner class

		String userName = "kim";
		Test01Anonymous am1 = new Test01Anonymous() {/* �̰� �͸� inner class�� �ȴ� */
			// �� ���� Ŭ������ Test01Anonymouse�� ��ӹް� �� ��
			// >> ����� �޾����� am1�� ����� ����� �� ����.
			// sub�� ��ü�� ���������� �������� ����� �� = super�͸� ��ߵȴ�.
			String name;

			// userName = "lee"; ���� ������ ������ �� �� ������ final�̶� ���� �Ұ�
			// ���� ���ÿ� �����ϴ� �� �ƴ϶� ���⼭ ���ǵ� �Ÿ� ��� ����
			public void xxx() {
				System.out.println("xxx() " + userName);
			} // end of xxx()

			// �Ϲ� Ŭ������ �������̵� �ص� �ǰ� �� �ص� �ż� �������� �߰�
			@Override
			public void aaa() {
				// TODO Auto-generated method stub
				super.aaa();
			}

			// �� �ȿ����� �� �ؼ� ������ ���� �� ���̴�.
			
			/*
			 * �޼ҵ带 ȣ���� �� �͸� �̳� Ŭ������ �����ϰ� �Ǵµ�
			 * �׶� �͸� �̳�Ŭ���� �ȿ� �������̵� �� �޼ҵ��� ����
			 * �޼ҵ带 ���� �ʿ��� �ϴ� �� �ƴϰ�
			 * �ݸ��� �ʿ��� �� ���ִ� ������ �ݹ� �����̴�.
			 * ���� ������ �߰�ȣ �ȿ� ���� ������ �޴� �޼ҵ�� �ڱ� ������ ���� �����ϸ� ������ �ݵȴ�
			 */
		};
		am1.aaa();

		Test01Anonymous2 am2 = new Test01Anonymous2() {
			public void move() {

			}
			
			// ��� abstract�ϱ� override �ʼ�
			@Override
			public void bbb() {
				// TODO Auto-generated method stub

			}
		}; //

		Test01Anonymous3 am3 = new Test01Anonymous3() {

			@Override
			public void ccc() {
				// TODO Auto-generated method stub
				System.out.println("ccc()...");
			}

		};
		am3.ccc();

		// ��� �ʵ忡 �����Ѱ� main ��ü�� ������ ����
		Test01Main main = new Test01Main();
		main.am3.ccc();
		
		// null�� �ּҰ��� ������, null�� �ƴϰ� ���ִ� �� new

	} // end of main

} // end of class
