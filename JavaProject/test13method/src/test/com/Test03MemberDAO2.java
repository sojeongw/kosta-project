package test.com;

public class Test03MemberDAO2 {

	public int insert(Test03memberVO vo) {
		System.out.println("insert...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		return 1;
	}
	
	public int update(Test03memberVO vo) {
		System.out.println("update...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		return 1;
	}
	
	public int delete(Test03memberVO vo) {
		System.out.println("delete...");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		return 1;
	}
	
	public Test03memberVO[] select() {		// 배열 : null - new - 주소 - 렝스 - 반복문
		//Test03memberVO[] vos = new Test03memberVO[] {new Test03memberVO(),new Test03memberVO()};
		// 5. null이 아니게 하기 위해 new를 각 아이템으로 만듦 >> 객체를 return하게 됨.
		
		Test03memberVO vo1 = new Test03memberVO();		// 이제 return에 넣은것보다 점 찍어서 바로 사용 가능
		Test03memberVO vo2 = new Test03memberVO();
		
		Test03memberVO[] vos = new Test03memberVO[] {vo1, vo2};
		
		vo1.setNum(0101);
		vo1.setId("vol1");
		vo1.setPw("vol1");
		vo1.setName("vol1");
		vo1.setTel("vol1");
		
		vo2.setNum(0202);
		vo2.setId("vol2");
		vo2.setPw("vol2");
		vo2.setName("vol2");
		vo2.setTel("vol2");
		
		
		return vos;	// 1. null을 없애서
		}
	
	
	// search
	public Test03memberVO search(Test03memberVO vo) {
		Test03memberVO vo4 = new Test03memberVO();
//		System.out.println("mvo : " + mvo);
//		System.out.println(mvo.getName());
		vo4.setNum(568789);
		
		Test03memberVO vo5 = new Test03memberVO();
		System.out.println(vo5.getNum());
		
		return vo4;
	}
	
	
		
		
//		System.out.println("select...");
//		Test03memberVO[] voArr = new Test03memberVO[2];
////		System.out.println(voArr);
////		System.out.println(voArr.length);
//		voArr[0] = new Test03memberVO();
//		voArr[0].setName("박보검");
//		voArr[0].setId("park");
//		voArr[0].setPw("1234");
//		voArr[0].setTel("019");
//		
//		voArr[1] = new Test03memberVO();
//		voArr[1].setName("서강준");
//		voArr[1].setId("seo");
//		voArr[1].setPw("5678");
//		voArr[1].setTel("017");
//		return voArr;
//		}
		
	

}		// end of class
