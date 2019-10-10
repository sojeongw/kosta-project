package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test01String {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// MVC 모델에서 DAO와 VO는 model에 해당 : 어딘가에 store해 줄 애들을 가지고 있는 것
		// controller
		// view
		// MVC 디자인 패턴
		
		System.out.println("String...");

		String name = "kim";
		System.out.println(name);
		System.out.println(name.equals("kim"));
		// 문자열의 길이. 배열과 달리 괄호가 있다는 점에 주의한다.
		System.out.println("문자열의 길이 : " + name.length());

		// String 생성 방법
		String str = new String();
		// 주소가 안 나오고 공백으로 출력
		System.out.println(str);
		// 문자열로 변환해서 보여주세요 = String은 굳이 붙일 필요가 없다.
		System.out.println(str.toString());

		String str2 = new String("Abc");
		System.out.println(str2);

		// 문자의 배열로 넣을 수도 있다
		str = new String(new char[] { 'a', 'b', 'c' });
		System.out.println(str);

		// String을 char[]로
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++)
			System.out.println(charArray[i]);

		System.out.println(str == str2); // false : 주소 비교
		System.out.println("abc" == "abc"); // true
		System.out.println(str.equals(str2)); // false : 내용 비교
		System.out.println(str.equalsIgnoreCase(str2)); // 스펠링만 맞으면 true

		// 아래는 같은 결과가 나온다
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

		String data = "무궁화피 꽃이 피었습니다";
		// 꽃이 있는 곳의 인덱스 번호를 출력. 글자가 중복되면 맨 처음 것을 출력.
		System.out.println(data.indexOf("꽃"));
		// 해당 인덱스(0부터)의 캐릭터를 출력
		System.out.println(data.charAt(4));
		// 꽃이 있는 곳의 인덱스의 내용을 출력
		System.out.println(data.charAt(data.indexOf("꽃")));
		// 해당 글자가 시작하는 곳 부터 출력
		System.out.println(data.substring(data.indexOf("피")));
		// 피 이상부터 었 미만까지 출력
		System.out.println(data.substring(data.indexOf("피"), data.indexOf("었")));
		// 인덱스 3이상 9미만으로 출력
		System.out.println(data.substring(3, 9));
		// 가장 마지막에 있는 피의 인덱스
		System.out.println(data.lastIndexOf("피"));

		String s = "http://yangssem.blog.me/test.jpg";
		System.out.println(s.substring(7, 23));
		System.out.println(s.substring(s.indexOf("y"), s.lastIndexOf("/")));
		System.out.println(s.substring(24));
		System.out.println(s.substring(s.lastIndexOf("/") + 1));

		String s2 = "1:aaa:bbb:ccc";
		String[] ss = s2.split(":");
		System.out.println(ss);
		// :을 기준으로 자른다.
		System.out.println(s2.split(":").length);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}

		// 정수 A,B가 있다
		// 프로그램 실행시 A,B에 입력할 정수를 한줄로 입력받고
		// 합산한 후 결과를 출력하는 프로그램을 완성하시오.

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

		// java.util.Scanner sc = new java.util.Scanner(System.in);으로 써줘도 됨
		// 다른 패키지에 동일한 오브젝트가 있다면 import는 하나만 인식하므로 이때 사용한다
		// 스캐너는 스페이스를 쳐도 따로 인식해서 저장한다.
//		Scanner sc = new Scanner(System.in);
//		int i = sc.nextInt();
//		System.out.println(i);
		
		// System.out.println("\"); 역 슬래시를 하면 에러가 나는데
		// 그 이유는 역슬래시 뒤에 오는 애가 기호를 나타내기 때문. cascade 문자.
		
//		String input2 = "1 fish 2 fish red fish blue fish";
//		// 여기에 역슬래시를 하나 더 넣은 이유는 \s가 글자임을 알려주기 위함이다.
//		Scanner sc = new Scanner(input2).useDelimiter("\\s*fish\\s*");
//		// 즉 스페이스가 적어도 한 개는 fish에 있는 것 = split(" fish ")
//		// 그래서 input2에서 마지막 fish는 안 잘린다.
//		
//		// \s : 스페이스바, * : 0 또는 그 이상
//		// 정규표현식 RegExp : Regular Expression
//		System.out.println(sc.nextInt());
//		System.out.println(sc.nextInt());
//		System.out.println(sc.next());
//		System.out.println(sc.next());
//		sc.close();
//		
		// 주어진 글자로 시작하면 true
		String ss2 = "http://yangssem.blog.me"; 
		System.out.println(ss2.startsWith("http://"));	// true. https면 false
		System.out.println(ss2.endsWith(".jpg"));	// false
		
		// 해당 스트링과 같으면 true
		System.out.println("abc".compareTo("abc"));		// 같으면 0
		System.out.println("abc".compareTo("Abc"));		// a - A = 32
		System.out.println("abc".compareToIgnoreCase("Abc"));		// 같으니까 0
		System.out.println("abc".compareTo("abc")==0);	// true. equals보다 속도 쪼금 더 빠름.
		
		// 앞뒤에 공백이 존재하면 전부 다 제거한다.
		System.out.println(" a bc ".trim().length());	// 중간 공백은 신경쓰지 않아서 4
		
		// 해당 글자를 다른 글자로 교체
		System.out.println("abc".replace("a", "B"));
		// 주의
		String st = "abc";
		st.replace("a", "X");
		// 교체해서 반환해줘 라는 뜻이지 반환해서 바꿔! 는 아님. concat도 마찬가지.
		System.out.println(st);
		st = st.replace("a", "X");
		System.out.println(st);
		
		System.out.println(st.toUpperCase());
		System.out.println(st.toLowerCase());
		
		
		
		
	} // end of main

} // end of class
