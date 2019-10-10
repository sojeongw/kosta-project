package kosta.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class StudentMain {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAOimpl();
		StudentVO vo = new StudentVO();

		// 시스템 입력 설정
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// 선택할 번호
		int select;

		while (true) {

			//////////// 질문 선택 ////////////
			System.out.println("원하시는 번호를 선택하세요.");
			System.out.println(">>> 1.점수 입력   2.점수 수정   3.점수 삭제   4.점수 목록   5.점수 검색");
			System.out.println();
			try {
				select = Integer.parseInt(br.readLine());

				////////////// 실행 //////////////
				switch (select) {
				// insert 제목을 입력하세요, 내용을 입력하세요, 작성자를 입력하세요, 작성일자는 시스템 시간으로
				case 1: {
					
					// vo.setNum(++i);
					
					System.out.println("이름을 입력하세요.");
					vo.setName(br.readLine());

					System.out.println("국어 점수를 입력하세요.");
					vo.setKor(Integer.parseInt(br.readLine()));

					System.out.println("영어 점수를 입력하세요.");
					vo.setEng(Integer.parseInt(br.readLine()));

					System.out.println("수학 점수를 입력하세요");
					vo.setMath(Integer.parseInt(br.readLine()));

					vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
					vo.setAvg((double) vo.getTotal() / 3);

					String grade = "";
					if (vo.getAvg() >= 90) {
						grade = "A";
					} else if (vo.getAvg() >= 80) {
						grade = "B";
					} else if (vo.getAvg() >= 70) {
						grade = "C";
					} else {
						grade = "D";
					}
					vo.setGrade(grade);

					// 결과 출력
					dao.insert(vo);

					// 질문으로 복귀
					break;

				} // end of case 1

				// update
				case 2: {
					System.out.println("수정할 번호를 입력하세요");
					vo.setNum(Integer.parseInt(br.readLine()));

					System.out.println("수정할 국어 점수를 입력하세요");
					vo.setKor(Integer.parseInt(br.readLine()));

					System.out.println("수정할 영어 점수를 입력하세요");
					vo.setEng(Integer.parseInt(br.readLine()));

					System.out.println("수정할 수학 점수를 입력하세요");
					vo.setMath(Integer.parseInt(br.readLine()));

					vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
					vo.setAvg((double) vo.getTotal() / 3);

					String grade = "";
					if (vo.getAvg() >= 90) {
						grade = "A";
					} else if (vo.getAvg() >= 80) {
						grade = "B";
					} else if (vo.getAvg() >= 70) {
						grade = "C";
					} else {
						grade = "D";
					}
					vo.setGrade(grade);

					// 결과 출력
					dao.update(vo);
					break;

				} // end of case 2

				// delete
				case 3: {
					System.out.println("삭제할 학생의 번호를 입력하세요");
					vo.setNum(Integer.parseInt(br.readLine()));

					// 결과 출력
					dao.delete(vo);
					break;

				} // end of case 3

				// selectAll
				case 4: {
					dao.selectAll();
					

					// 질문 복귀
					break;

				} // end of case 4

				// selectOne
				case 5: {
					
					System.out.println("검색할 학생의 번호를 입력하세요");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					// 결과 출력
					dao.selectOne(vo);
					

				} // end of case 5

				} // end of switch
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("잘못된 입력입니다.");
				e.printStackTrace();
			}

		} // end of while

	} // end of main

} // end of class
