package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test01String {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// MVC �𵨿��� DAO�� VO�� model�� �ش� : ��򰡿� store�� �� �ֵ��� ������ �ִ� ��
		// controller
		// view
		// MVC ������ ����
		
		System.out.println("String...");

		String name = "kim";
		System.out.println(name);
		System.out.println(name.equals("kim"));
		// ���ڿ��� ����. �迭�� �޸� ��ȣ�� �ִٴ� ���� �����Ѵ�.
		System.out.println("���ڿ��� ���� : " + name.length());

		// String ���� ���
		String str = new String();
		// �ּҰ� �� ������ �������� ���
		System.out.println(str);
		// ���ڿ��� ��ȯ�ؼ� �����ּ��� = String�� ���� ���� �ʿ䰡 ����.
		System.out.println(str.toString());

		String str2 = new String("Abc");
		System.out.println(str2);

		// ������ �迭�� ���� ���� �ִ�
		str = new String(new char[] { 'a', 'b', 'c' });
		System.out.println(str);

		// String�� char[]��
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++)
			System.out.println(charArray[i]);

		System.out.println(str == str2); // false : �ּ� ��
		System.out.println("abc" == "abc"); // true
		System.out.println(str.equals(str2)); // false : ���� ��
		System.out.println(str.equalsIgnoreCase(str2)); // ���縵�� ������ true

		// �Ʒ��� ���� ����� ���´�
		System.out.println(str + str2);
		System.out.println(str.concat(str2));

		// System.out.println("start...");
		// long startTime = System.currentTimeMillis();
		// String temp = "";
		// for(int i=0; i< 100000; i++) {
		// temp = temp.concat(str2);
		// }
		// System.out.println(temp.length());
		// System.out.println(System.currentTimeMillis()-startTime);
		// System.out.println("end...");

		String data = "����ȭ�� ���� �Ǿ����ϴ�";
		// ���� �ִ� ���� �ε��� ��ȣ�� ���. ���ڰ� �ߺ��Ǹ� �� ó�� ���� ���.
		System.out.println(data.indexOf("��"));
		// �ش� �ε���(0����)�� ĳ���͸� ���
		System.out.println(data.charAt(4));
		// ���� �ִ� ���� �ε����� ������ ���
		System.out.println(data.charAt(data.indexOf("��")));
		// �ش� ���ڰ� �����ϴ� �� ���� ���
		System.out.println(data.substring(data.indexOf("��")));
		// �� �̻���� �� �̸����� ���
		System.out.println(data.substring(data.indexOf("��"), data.indexOf("��")));
		// �ε��� 3�̻� 9�̸����� ���
		System.out.println(data.substring(3, 9));
		// ���� �������� �ִ� ���� �ε���
		System.out.println(data.lastIndexOf("��"));

		String s = "http://yangssem.blog.me/test.jpg";
		System.out.println(s.substring(7, 23));
		System.out.println(s.substring(s.indexOf("y"), s.lastIndexOf("/")));
		System.out.println(s.substring(24));
		System.out.println(s.substring(s.lastIndexOf("/") + 1));

		String s2 = "1:aaa:bbb:ccc";
		String[] ss = s2.split(":");
		System.out.println(ss);
		// :�� �������� �ڸ���.
		System.out.println(s2.split(":").length);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}

		// ���� A,B�� �ִ�
		// ���α׷� ����� A,B�� �Է��� ������ ���ٷ� �Է¹ް�
		// �ջ��� �� ����� ����ϴ� ���α׷��� �ϼ��Ͻÿ�.

//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//
//		int A, B;
//		String input = br.readLine();
//		String[] s3 = input.split(" ");
//
//		A = Integer.parseInt(s3[0]);
//		B = Integer.parseInt(s3[1]);
//
//		System.out.println(A + B);

		// java.util.Scanner sc = new java.util.Scanner(System.in);���� ���൵ ��
		// �ٸ� ��Ű���� ������ ������Ʈ�� �ִٸ� import�� �ϳ��� �ν��ϹǷ� �̶� ����Ѵ�
		// ��ĳ�ʴ� �����̽��� �ĵ� ���� �ν��ؼ� �����Ѵ�.
//		Scanner sc = new Scanner(System.in);
//		int i = sc.nextInt();
//		System.out.println(i);
		
		// System.out.println("\"); �� �����ø� �ϸ� ������ ���µ�
		// �� ������ �������� �ڿ� ���� �ְ� ��ȣ�� ��Ÿ���� ����. cascade ����.
		
//		String input2 = "1 fish 2 fish red fish blue fish";
//		// ���⿡ �������ø� �ϳ� �� ���� ������ \s�� �������� �˷��ֱ� �����̴�.
//		Scanner sc = new Scanner(input2).useDelimiter("\\s*fish\\s*");
//		// �� �����̽��� ��� �� ���� fish�� �ִ� �� = split(" fish ")
//		// �׷��� input2���� ������ fish�� �� �߸���.
//		
//		// \s : �����̽���, * : 0 �Ǵ� �� �̻�
//		// ����ǥ���� RegExp : Regular Expression
//		System.out.println(sc.nextInt());
//		System.out.println(sc.nextInt());
//		System.out.println(sc.next());
//		System.out.println(sc.next());
//		sc.close();
//		
		// �־��� ���ڷ� �����ϸ� true
		String ss2 = "http://yangssem.blog.me"; 
		System.out.println(ss2.startsWith("http://"));	// true. https�� false
		System.out.println(ss2.endsWith(".jpg"));	// false
		
		// �ش� ��Ʈ���� ������ true
		System.out.println("abc".compareTo("abc"));		// ������ 0
		System.out.println("abc".compareTo("Abc"));		// a - A = 32
		System.out.println("abc".compareToIgnoreCase("Abc"));		// �����ϱ� 0
		System.out.println("abc".compareTo("abc")==0);	// true. equals���� �ӵ� �ɱ� �� ����.
		
		// �յڿ� ������ �����ϸ� ���� �� �����Ѵ�.
		System.out.println(" a bc ".trim().length());	// �߰� ������ �Ű澲�� �ʾƼ� 4
		
		// �ش� ���ڸ� �ٸ� ���ڷ� ��ü
		System.out.println("abc".replace("a", "B"));
		// ����
		String st = "abc";
		st.replace("a", "X");
		// ��ü�ؼ� ��ȯ���� ��� ������ ��ȯ�ؼ� �ٲ�! �� �ƴ�. concat�� ��������.
		System.out.println(st);
		st = st.replace("a", "X");
		System.out.println(st);
		
		System.out.println(st.toUpperCase());
		System.out.println(st.toLowerCase());
		
		
		
		
	} // end of main

} // end of class
