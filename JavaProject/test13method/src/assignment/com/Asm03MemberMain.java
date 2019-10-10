package assignment.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Asm03MemberMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// 시스템 입력 설정
				InputStream is = System.in;
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				// 선택할 번호
				int select;


				// 초기값 세팅
				Asm03MemberVO mVO = new Asm03MemberVO();

				// 초기값 확인
				// System.out.println(bVO.getNum());
				// System.out.println(bVO.getTitle());
				// System.out.println(bVO.getContent());
				// System.out.println(bVO.getName());
				// System.out.println(bVO.getDate());

				Asm03MemberDAO mDAO = new Asm03MemberDAO();

				while (true) {

					//////////// 질문 선택 ////////////
					System.out.println("원하시는 번호를 선택하세요.");
					System.out.println(">>> 1.회원 가입   2.회원 정보 수정   3.회원 정보 삭제   4.회원 정보 목록   5.회원 검색");
					System.out.println();
					select = Integer.parseInt(br.readLine());

					////////////// 실행 //////////////
					switch (select) {
					// insert 제목을 입력하세요, 내용을 입력하세요, 작성자를 입력하세요, 작성일자는 시스템 시간으로
					case 1: {
						int i = 0;
						mVO.setNum(++i);
						
						System.out.println("아이디를 입력하세요.");
						mVO.setId(br.readLine());

						System.out.println("패스워드를 입력하세요.");
						mVO.setPw(br.readLine());

						System.out.println("이름을 입력하세요.");
						mVO.setName(br.readLine());

						System.out.println("전화 번호를 입력하세요");
						mVO.setTel(br.readLine());
						
						

						// 결과 출력
						mDAO.insert(mVO);

						// 질문으로 복귀
						break;

					} // end of case 1

					// update
					case 2: {
						System.out.println("수정할 번호를 입력하세요");
						mVO.setNum(Integer.parseInt(br.readLine()));

						System.out.println("수정할 아이디를 입력하세요.");
						mVO.setId(br.readLine());

						System.out.println("수정할 패스워드를 입력하세요.");
						mVO.setPw(br.readLine());

						System.out.println("수정할 이름을 입력하세요.");
						mVO.setName(br.readLine());

						System.out.println("수정할 전화 번호를 입력하세요");
						mVO.setTel(br.readLine());
						
						

						// 결과 출력
						mDAO.update(mVO);
						break;

					} // end of case 2

					// delete
					case 3: {
						System.out.println("삭제할 회원의 번호를 입력하세요");
						mVO.setNum(Integer.parseInt(br.readLine()));

						// 결과 출력
						mDAO.delete(mVO);
						break;

					} // end of case 3

					// selectAll
					case 4: {
						mDAO.selectAll();
						Asm03MemberVO[] mArr = mDAO.selectAll();

						// 결과 출력
						for (int i = 0; i < mArr.length; i++) {
							System.out.println();
							System.out.println("---------------------------------------------------");
							System.out.print(mArr[i].getNum() + "  ");
							System.out.print(mArr[i].getId() + "\t");
							System.out.print(mArr[i].getPw() + "\t");
							System.out.print(mArr[i].getName() + "\t");
							System.out.print(mArr[i].getTel() + "\t");
						}
						System.out.println("\n");

						// 질문 복귀
						break;

					} // end of case 4

					// selectOne
					case 5: {
						System.out.println("검색할 회원의 번호를 입력하세요");
						mVO.setNum(Integer.parseInt(br.readLine()));

						// 결과 출력
						mDAO.selectOne(mVO);

					} // end of case 5

					} // end of switch

				} // end of while

	}

}
