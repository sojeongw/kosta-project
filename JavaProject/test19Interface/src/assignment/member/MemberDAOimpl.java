package assignment.member;

public class MemberDAOimpl implements MemberDAO{
	
	// 1. insert
				public void insert(MemberVO vo) {
					//System.out.println("insert ¸Þ¼Òµå");
					System.out.println();
					System.out.print(vo.getNum() + "  ");
					System.out.print(vo.getId() + "\t");
					System.out.print(vo.getPw() + "\t");
					System.out.print(vo.getName() + "\t");
					System.out.println("\t" + vo.getTel());
					System.out.println();
					
				}
				
				
				
				// 2. update
				public void update(MemberVO vo) {
					System.out.println();
					System.out.print(vo.getNum() + "  ");
					System.out.print(vo.getId() + "\t");
					System.out.print(vo.getPw() + "\t");
					System.out.print(vo.getName() + "\t");
					System.out.println("\t" + vo.getTel());
					System.out.println();
				}
				
				
				
				// 3. delete
				public void delete(MemberVO vo) {
					System.out.println();
					System.out.print(vo.getNum() + "  ");
					System.out.println();
					System.out.println();
				}
				
				
				
				// 4. selectAll
				public MemberVO[] selectAll() {
					
					MemberVO m01 = new MemberVO();
					MemberVO m02 = new MemberVO();
					MemberVO m03 = new MemberVO();
					MemberVO[] mArr = new MemberVO[] {m01, m02, m03};
					
					mArr[0] = m01;
					mArr[1] = m02;
					mArr[2] = m03;
					
					//	s01
					m01.setNum(1);
					m01.setId("¹Úº¸°Ë ¸¶´­¡Ù");
					m01.setPw("1234");
					m01.setName("¿Õ¼ÒÁ¤");
					m01.setTel("010-4655-0000");
					
					//	s02
					m02.setNum(2);
					m02.setId("¼­°­ÁØ ¸¶´­¡Ù");
					m02.setPw("5678");
					m02.setName("¿Õ°ïµà");
					m02.setTel("010-4655-1111");
					
					//	s03
					m03.setNum(3);
					m03.setId("À¯½ÂÈ£ ¸¶´­¡Ù");
					m03.setPw("1324");
					m03.setName("¿Õ¿Õ¿Õ");
					m03.setTel("010-4655-2222");
					
					return mArr;
				}
				
				
				
				// 5. selectOne
				public void selectOne(MemberVO vo) {
					System.out.println(vo.getNum());
					System.out.println();
				}


}
