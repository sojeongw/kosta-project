package test.com;

public class Test01Main2 {
	
	int num;		// num�� �⺻�� 0
	int[] sus;		// sus�� �⺻�� null
	String[] name;
	
	
	Test01Main2(){
		
		num = 10;
		
		sus = new int[num];			// �ʱ�ȭ�� ���ְ� �Է�
		for(int i=0; i<sus.length; i++) {
			sus[i] = num*2 + i;
			}	// end of for
		}		// end
		
	Test01Main2(int x, int y) {
		num = x;
		sus = new int[num];			// �ʱ�ȭ�� ���ְ� �Է�
		for(y=0; y<sus.length; y++) {
			sus[y] = num*2 + y;
			} // end of for
		}	//end
	
	Test01Main2(int num, int[] y){
		this.num = num;		// this�� �� Ŭ������ �ִ� �� ��Ī. ���� ������ �ƴϴ�.
		sus = y;
	}
		
	Test01Main2(String[] sArr){
		name = sArr;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. �Ű����� ���� �����ڷ� �ʱ�ȭ
		
		Test01Main2 tm = new Test01Main2();
		
		for(int i=0; i<tm.sus.length; i++) {
			System.out.println(tm.sus[i]);
			}	// end of for
		
		System.out.println();
		
		// 2. �Ű����� �ִ� �����ڷ� �ʱ�ȭ ���
		
//		tm = new Test01Main2(5, 1);
//		System.out.println(tm.num);
//		
//		for(int i=0; i<tm.sus.length; i++) {
//		System.out.println(tm.sus[i]);
//		}	// end of for
		
		tm = new Test01Main2(5, new int[3]);		// 000 ����ִ� �迭
		for(int i=0; i<tm.sus.length; i++) {
			System.out.println(tm.sus[i]);
			}	// end of for
		
		tm = new Test01Main2(5, new int[] {11,22,33});	// ���� ��Ƽ� �ֱ�
		for(int i=0; i<tm.sus.length; i++) {
			System.out.println(tm.sus[i]);
			}	// end of for
		
		System.out.println();
		
		// 3. ���� ������ �̸� �迭�� �ʱ�ȭ�ϰ� ���
		
		tm = new Test01Main2(new String[] {"�ռ���","�ں���","����"});
		for(int i=0; i<tm.name.length; i++) {
			System.out.println(tm.name[i]);
			}	// end of for
		
		

	}	// end of main

}
