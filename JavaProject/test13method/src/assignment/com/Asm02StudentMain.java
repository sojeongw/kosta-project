package assignment.com;

import java.io.*;
import java.util.*;

public class Asm02StudentMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// 시스템 입력 설정
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// 선택할 번호
		int select;

//		String title = "";
//		String content = "";
//		String name = "";
//		Date date;
//		int num = 0;

		// 초기값 세팅
		Asm02StudentVO sVO = new Asm02StudentVO();
//		sVO.setNum(1);
//		sVO.setName("왕소정");
//		sVO.setKor(0);
//		sVO.setEng(0);
//		sVO.setMath(0);
//		sVO.setTotal(sVO.getKor() + sVO.getEng() + sVO.getMath());
//		sVO.setAvg((double) sVO.getTotal() / 3);
//		
//		String grade = "";
//		if (sVO.getAvg() >= 90) {
//			grade = "A";
//		} else if (sVO.getAvg() >= 80) {
//			grade = "B";
//		} else if (sVO.getAvg() >= 70) {
//			grade = "C";
//		} else {
//			grade = "D";
//		}
//		sVO.setGrade(grade);


		// 초기값 확인
		// System.out.println(bVO.getNum());
		// System.out.println(bVO.getTitle());
		// System.out.println(bVO.getContent());
		// System.out.println(bVO.getName());
		// System.out.println(bVO.getDate());

		Asm02StudentDAO sDAO = new Asm02StudentDAO();

		while (true) {

			//////////// 질문 선택 ////////////
			System.out.println("원하시는 번호를 선택하세요.");
			System.out.println(">>> 1.점수 입력   2.점수 수정   3.점수 삭제   4.점수 목록   5.점수 검색");
			System.out.println();
			select = Integer.parseInt(br.readLine());

			////////////// 실행 //////////////
			switch (select) {
			// insert 제목을 입력하세요, 내용을 입력하세요, 작성자를 입력하세요, 작성일자는 시스템 시간으로
			case 1: {
				int i = 0;
				sVO.setNum(++i);
				System.out.println("이름을 입력하세요.");
				sVO.setName(br.readLine());

				System.out.println("국어 점수를 입력하세요.");
				sVO.setKor(Integer.parseInt(br.readLine()));

				System.out.println("영어 점수를 입력하세요.");
				sVO.setEng(Integer.parseInt(br.readLine()));

				System.out.println("수학 점수를 입력하세요");
				sVO.setMath(Integer.parseInt(br.readLine()));
				
				sVO.setTotal(sVO.getKor() + sVO.getEng() + sVO.getMath());
				sVO.setAvg((double) sVO.getTotal() / 3);
				
				String grade = "";
				if (sVO.getAvg() >= 90) {
					grade = "A";
				} else if (sVO.getAvg() >= 80) {
					grade = "B";
				} else if (sVO.getAvg() >= 70) {
					grade = "C";
				} else {
					grade = "D";
				}
				sVO.setGrade(grade);

				// 결과 출력
				sDAO.insert(sVO);

				// 질문으로 복귀
				break;

			} // end of case 1

			// update
			case 2: {
				System.out.println("수정할 번호를 입력하세요");
				sVO.setNum(Integer.parseInt(br.readLine()));

				System.out.println("수정할 국어 점수를 입력하세요");
				sVO.setKor(Integer.parseInt(br.readLine()));

				System.out.println("수정할 영어 점수를 입력하세요");
				sVO.setEng(Integer.parseInt(br.readLine()));

				System.out.println("수정할 수학 점수를 입력하세요");
				sVO.setMath(Integer.parseInt(br.readLine()));
				
				sVO.setTotal(sVO.getKor() + sVO.getEng() + sVO.getMath());
				sVO.setAvg((double) sVO.getTotal() / 3);
				
				String grade = "";
				if (sVO.getAvg() >= 90) {
					grade = "A";
				} else if (sVO.getAvg() >= 80) {
					grade = "B";
				} else if (sVO.getAvg() >= 70) {
					grade = "C";
				} else {
					grade = "D";
				}
				sVO.setGrade(grade);

				// 결과 출력
				sDAO.update(sVO);
				break;

			} // end of case 2

			// delete
			case 3: {
				System.out.println("삭제할 학생의 번호를 입력하세요");
				sVO.setNum(Integer.parseInt(br.readLine()));

				// 결과 출력
				sDAO.delete(sVO);
				break;

			} // end of case 3

			// selectAll
			case 4: {
				sDAO.selectAll();
				Asm02StudentVO[] sArr = sDAO.selectAll();

				// 결과 출력
				for (int i = 0; i < sArr.length; i++) {
					System.out.println();
					System.out.println("---------------------------------------------------");
					System.out.print(sArr[i].getNum() + "  ");
					System.out.print(sArr[i].getName() + "\t");
					System.out.print(sArr[i].getKor() + "\t");
					System.out.print(sArr[i].getEng() + "\t");
					System.out.print(sArr[i].getMath() + "\t");
					System.out.print(sArr[i].getTotal() + "\t");
					System.out.print(sArr[i].getAvg() + "\t");
					System.out.print(sArr[i].getGrade() + "\t");
					
				}
				System.out.println("\n");

				// 질문 복귀
				break;

			} // end of case 4

			// selectOne
			case 5: {
				System.out.println("검색할 학생의 번호를 입력하세요");
				sVO.setNum(Integer.parseInt(br.readLine()));

				// 결과 출력
				sDAO.selectOne(sVO);

			} // end of case 5

			} // end of switch

		} // end of while

	}

}
