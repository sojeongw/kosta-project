package test.com;

	

public class Test04Student {
	
	// ���ο��� ������ ����� ���� ���� ������ ����� ���� �ƴϸ� �����ڿ� ����.
	// total�̳� avg ���ϴ� ������ ���⿡ ���� ���� ���� ��� ���ο� ���ư���.
	int num = 1;
	String name = "ȫ�浿";
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	char grade;
	
	Test04Student(){		// �������� �� ���� : ���������� �ʱ�ȭ
		// ��ü���� ���� �ٸ��� �ϰ� ������ ���ο��� ��ü �����ϰ� �ٽ� ���� �ٲٸ� ��.
		num = 2;
		name = "�ڱ浿";
		kor = 50;
		eng = 40;
		math = 20;
		total = kor + eng + math;
		avg = (double)total/3;
		grade = 'C';
		
	}

}
