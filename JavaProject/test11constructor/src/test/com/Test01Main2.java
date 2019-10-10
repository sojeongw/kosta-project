package test.com;

public class Test01Main2 {
	
	int num;		// num의 기본값 0
	int[] sus;		// sus의 기본값 null
	String[] name;
	
	
	Test01Main2(){
		
		num = 10;
		
		sus = new int[num];			// 초기화를 해주고 입력
		for(int i=0; i<sus.length; i++) {
			sus[i] = num*2 + i;
			}	// end of for
		}		// end
		
	Test01Main2(int x, int y) {
		num = x;
		sus = new int[num];			// 초기화를 해주고 입력
		for(y=0; y<sus.length; y++) {
			sus[y] = num*2 + y;
			} // end of for
		}	//end
	
	Test01Main2(int num, int[] y){
		this.num = num;		// this는 내 클래스에 있는 걸 지칭. 로컬 변수가 아니다.
		sus = y;
	}
		
	Test01Main2(String[] sArr){
		name = sArr;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 매개변수 없는 생성자로 초기화
		
		Test01Main2 tm = new Test01Main2();
		
		for(int i=0; i<tm.sus.length; i++) {
			System.out.println(tm.sus[i]);
			}	// end of for
		
		System.out.println();
		
		// 2. 매개변수 있는 생성자로 초기화 출력
		
//		tm = new Test01Main2(5, 1);
//		System.out.println(tm.num);
//		
//		for(int i=0; i<tm.sus.length; i++) {
//		System.out.println(tm.sus[i]);
//		}	// end of for
		
		tm = new Test01Main2(5, new int[3]);		// 000 들어있는 배열
		for(int i=0; i<tm.sus.length; i++) {
			System.out.println(tm.sus[i]);
			}	// end of for
		
		tm = new Test01Main2(5, new int[] {11,22,33});	// 값을 담아서 주기
		for(int i=0; i<tm.sus.length; i++) {
			System.out.println(tm.sus[i]);
			}	// end of for
		
		System.out.println();
		
		// 3. 전역 변수인 이름 배열을 초기화하고 출력
		
		tm = new Test01Main2(new String[] {"왕소정","박보검","공유"});
		for(int i=0; i<tm.name.length; i++) {
			System.out.println(tm.name[i]);
			}	// end of for
		
		

	}	// end of main

}
