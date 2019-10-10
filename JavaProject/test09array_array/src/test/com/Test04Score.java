package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04Score {

	public static void main(String[] args) throws IOException {
		
		// 해답
		
		//시스템화면입력용 코딩부분////////////////////////
		InputStream is =  System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		///////////////////////////////////////////////////
		
		
		System.out.println("=================");
		System.out.println("성적처리프로그램");
		System.out.println("=================");
		//1:홍길동1:99:88:77:264:88:B
		//2:홍길동2:99:88:77:264:88:B
		//3:홍길동3:99:88:77:264:88:B
		String[] list = new String[3];
		String x = "";
		int i = 0;
		
		while(!x.equals("x")) {
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println(name);
			System.out.println("국어점수를 입력하세요.");
			int kor = Integer.parseInt(br.readLine());
			System.out.println(kor);
			System.out.println("-----------------");
			System.out.println("영어점수를 입력하세요.");
			int eng = Integer.parseInt(br.readLine());;
			System.out.println(eng);
			System.out.println("-----------------");
			System.out.println("수학점수를 입력하세요.");
			int math = Integer.parseInt(br.readLine());;
			System.out.println(math);
			System.out.println("-----------------");
			int total = kor+eng+math;
			System.out.println("총점:"+total);
			System.out.println("-----------------");
			double avg = (double)total/3;
			System.out.println("평점:"+avg);
			System.out.println("-----------------");
			char grade = avg>=90 ? 'A': avg>=80 ? 'B': avg>=70 ? 'C': 'D';//삼항연산처리하세요
			System.out.println("등급:"+grade);
			System.out.println("=================");
			System.out.println(""+i+":"+name+":"+kor+":"+eng+":"+math+":"+total+":"+avg+":"+grade);
			
			String row = ""+i+":"+name+":"+kor+":"+eng+":"+math+":"+total+":"+avg+":"+grade+"\n";
			
			list[i] = row;
			
			
			i++;
			System.out.println("종료하려면 x입력,계속하려면 아무키엔터");
			x = br.readLine();
		}//end for
		System.out.println("=================");
		
		System.out.println(list);
		System.out.println(list.length);
		for(int j=0; j<list.length; j++) {
			System.out.println(list[j]);	// 한명 값만 넣으면 배열 3개 만들어놨으니까 null 나옴
		}

	}

}
