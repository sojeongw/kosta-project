package test.com;

public class Test03MainMember {

	public static void main(String[] args) {

		System.out.println("member...");

		Test03MemberDAO2 dao = new Test03MemberDAO2();
		// int result = dao.insert(new Test03memberVO());
		// 이렇게 넣으면 값 세팅을 못 한다. 꼭 하고 싶으면 생성자로밖에 못한다.
		Test03memberVO vo = new Test03memberVO();
		vo.setNum(11);
		vo.setId("admin");
		vo.setPw("hi123456");
		vo.setName("kim");
		vo.setTel("010");
		int result = dao.insert(vo);
		System.out.println("insert: " + result);

		System.out.println();

		Test03memberVO vo2 = new Test03memberVO();
		vo2.setNum(1178);
		vo2.setId("admin78");
		vo2.setPw("hi12345678");
		vo2.setName("kim78");
		vo2.setTel("01078");
		int result2 = dao.update(vo2);
		System.out.println("update: " + result);

		System.out.println();

		Test03memberVO vo3 = new Test03memberVO();
		vo3.setNum(1190);
		vo3.setId("admin90");
		vo3.setPw("hi12345690");
		vo3.setName("kim90");
		vo3.setTel("01090");
		int result3 = dao.delete(vo3);
		System.out.println("delete: " + result);

		System.out.println();

		// select
		Test03memberVO[] vos = dao.select();
		System.out.println(vos);			// 2. 주소를 받고
		System.out.println(vos.length);		// 3. 길이를 보고
		for(int i=0; i<vos.length; i++) {
			System.out.println(vos[i]);		// 4. 방에 new가 안되어있으니 null이 나온다.
			// >> select에서 각 방의 new를 해준다.
			System.out.println(vos[i].getNum());
			System.out.println(vos[i].getId());
			System.out.println(vos[i].getPw());	// 6. 이 값들을 알고 싶으면 vos로 가서 set에 세팅
		}
		
		// search
		Test03memberVO vo4 = new Test03memberVO();
		vo4.setNum(4444);
		vo4.setId("id_4444");
		vo4.setPw("pw_4444");
		vo4.setName("name_4444");
		vo4.setTel("tel_4444");
		
		

//		System.out.println(vos[0].getName());
//		System.out.println(vos[0].getId());
//		System.out.println(vos[0].getPw());
//		System.out.println(vos[0].getTel());
//		
//		System.out.println();
//		
//		System.out.println(vos[1].getName());
//		System.out.println(vos[1].getId());
//		System.out.println(vos[1].getPw());
//		System.out.println(vos[1].getTel());
		

	} // end of main

} // end of class