package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04Score {

	public static void main(String[] args) throws IOException {
		
		// �ش�
		
		//�ý���ȭ���Է¿� �ڵ��κ�////////////////////////
		InputStream is =  System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		///////////////////////////////////////////////////
		
		
		System.out.println("=================");
		System.out.println("����ó�����α׷�");
		System.out.println("=================");
		//1:ȫ�浿1:99:88:77:264:88:B
		//2:ȫ�浿2:99:88:77:264:88:B
		//3:ȫ�浿3:99:88:77:264:88:B
		String[] list = new String[3];
		String x = "";
		int i = 0;
		
		while(!x.equals("x")) {
			System.out.println("�̸��� �Է��ϼ���");
			String name = br.readLine();
			System.out.println(name);
			System.out.println("���������� �Է��ϼ���.");
			int kor = Integer.parseInt(br.readLine());
			System.out.println(kor);
			System.out.println("-----------------");
			System.out.println("���������� �Է��ϼ���.");
			int eng = Integer.parseInt(br.readLine());;
			System.out.println(eng);
			System.out.println("-----------------");
			System.out.println("���������� �Է��ϼ���.");
			int math = Integer.parseInt(br.readLine());;
			System.out.println(math);
			System.out.println("-----------------");
			int total = kor+eng+math;
			System.out.println("����:"+total);
			System.out.println("-----------------");
			double avg = (double)total/3;
			System.out.println("����:"+avg);
			System.out.println("-----------------");
			char grade = avg>=90 ? 'A': avg>=80 ? 'B': avg>=70 ? 'C': 'D';//���׿���ó���ϼ���
			System.out.println("���:"+grade);
			System.out.println("=================");
			System.out.println(""+i+":"+name+":"+kor+":"+eng+":"+math+":"+total+":"+avg+":"+grade);
			
			String row = ""+i+":"+name+":"+kor+":"+eng+":"+math+":"+total+":"+avg+":"+grade+"\n";
			
			list[i] = row;
			
			
			i++;
			System.out.println("�����Ϸ��� x�Է�,����Ϸ��� �ƹ�Ű����");
			x = br.readLine();
		}//end for
		System.out.println("=================");
		
		System.out.println(list);
		System.out.println(list.length);
		for(int j=0; j<list.length; j++) {
			System.out.println(list[j]);	// �Ѹ� ���� ������ �迭 3�� ���������ϱ� null ����
		}

	}

}
