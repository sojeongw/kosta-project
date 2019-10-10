package assignment.com;

public class Asm03MemberDAO {
	

	// 1. insert
		public void insert(Asm03MemberVO mVO) {
			//System.out.println("insert 메소드");
			System.out.println();
			System.out.print(mVO.getNum() + "  ");
			System.out.print(mVO.getId() + "\t");
			System.out.print(mVO.getPw() + "\t");
			System.out.print(mVO.getName() + "\t");
			System.out.println("\t" + mVO.getTel());
			System.out.println();
			
		}
		
		
		
		// 2. update
		public void update(Asm03MemberVO mVO) {
			System.out.println();
			System.out.print(mVO.getNum() + "  ");
			System.out.print(mVO.getId() + "\t");
			System.out.print(mVO.getPw() + "\t");
			System.out.print(mVO.getName() + "\t");
			System.out.println("\t" + mVO.getTel());
			System.out.println();
		}
		
		
		
		// 3. delete
		public void delete(Asm03MemberVO mVO) {
			System.out.println();
			System.out.print(mVO.getNum() + "  ");
			System.out.println();
			System.out.println();
		}
		
		
		
		// 4. selectAll
		public Asm03MemberVO[] selectAll() {
			
			Asm03MemberVO m01 = new Asm03MemberVO();
			Asm03MemberVO m02 = new Asm03MemberVO();
			Asm03MemberVO m03 = new Asm03MemberVO();
			Asm03MemberVO[] mArr = new Asm03MemberVO[] {m01, m02, m03};
			
			mArr[0] = m01;
			mArr[1] = m02;
			mArr[2] = m03;
			
			//	s01
			m01.setNum(1);
			m01.setId("박보검 마눌☆");
			m01.setPw("1234");
			m01.setName("왕소정");
			m01.setTel("010-4655-0000");
			
			//	s02
			m02.setNum(2);
			m02.setId("서강준 마눌☆");
			m02.setPw("5678");
			m02.setName("왕곤듀");
			m02.setTel("010-4655-1111");
			
			//	s03
			m03.setNum(3);
			m03.setId("유승호 마눌☆");
			m03.setPw("1324");
			m03.setName("왕왕왕");
			m03.setTel("010-4655-2222");
			
			return mArr;
		}
		
		
		
		// 5. selectOne
		public void selectOne(Asm03MemberVO mVO) {
			System.out.println(mVO.getNum());
			System.out.println();
		}

}	// end of class
