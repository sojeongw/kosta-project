package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04BoardMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		Test04BoardDAO bDAO = new Test04BoardDAO();
		
		String exit = "";
		
		do {
			System.out.println("----------------------");
			System.out.println("--------게시판--------");
			System.out.println("1.글쓰기 2.글수정 3.글삭제 4.글목록 5.글검색");
			System.out.println("\n원하시는 메뉴를 선택하세요");
			
			String menu = br.readLine();
			
			if(menu.equals("1")) {
				System.out.println("1.글쓰기\n");
				System.out.println("제목을 입력하세요.");
				String title = br.readLine();
				
				System.out.println("내용을 입력하세요.");
				String content = br.readLine();
				
				System.out.println("작성자를 입력하세요.");
				String writer = br.readLine();
				
				Test04BoardVO bvo = new Test04BoardVO();
				bvo.setTitle(title);
				bvo.setContent(content);
				bvo.setWriter(writer);
				
				bDAO.insert(bvo);
				
				//System.out.println("insert : " + result);
			}	// if 1
			
			else if(menu.equals("2")) {
				System.out.println("2.글수정\n");
				System.out.println("수정할 번호를 입력하세요.");
				String num = br.readLine();
				
				System.out.println("수정할 제목을 입력하세요.");
				String title = br.readLine();
				
				System.out.println("수정할 내용을 입력하세요.");
				String content = br.readLine();
				
				System.out.println("수정할 작성자를 입력하세요.");
				String writer = br.readLine();
				
				Test04BoardVO bvo = new Test04BoardVO();
				bvo.setNum(Integer.parseInt(num));
				bvo.setTitle(title);
				bvo.setContent(content);
				bvo.setWriter(writer);
				
				bDAO.update(bvo);
				
				//System.out.println("update : " + result);
			}	// if 2
			
			else if(menu.equals("3")) {
				System.out.println("3.글삭제\n");
				System.out.println("삭제할 글 번호를 입력하세요");
				String num = br.readLine();
				
				Test04BoardVO bvo = new Test04BoardVO();
				bvo.setNum(Integer.parseInt(num));

				bDAO.delete(bvo);
				
				//System.out.println("delete : " + result);
					
			}	// if 3
			
			else if(menu.equals("4")) {
				System.out.println("4.글목록\n");
				
				Test04BoardVO[] vos = bDAO.selectAll();
				for(int i=0; i<vos.length; i++) {
					System.out.print(vos[i].getNum() + "\t");
					System.out.print(vos[i].getTitle() + "\t");
					System.out.print(vos[i].getContent() + "\t");
					System.out.print(vos[i].getWriter() + "\t");
					System.out.print(vos[i].getRegDate() + "\t");
				}	// end of for
				System.out.println();
			}	// if 4
			
			else if(menu.equals("5")) {
				System.out.println("5.글검색\n");
				System.out.println("검색할 글 번호를 입력하세요.");
				String num = br.readLine();
				
				Test04BoardVO bvo = new Test04BoardVO();
				bvo.setNum(Integer.parseInt(num));
				
				Test04BoardVO bvv = bDAO.select(bvo);	// 리턴값이 객체니까
				System.out.print(bvv.getNum() + "\t");
				System.out.print(bvv.getTitle() + "\t");
				System.out.print(bvv.getContent() + "\t");
				System.out.print(bvv.getWriter() + "\t");
				System.out.print(bvv.getRegDate() + "\t");
			}
			
			
			System.out.println();
			System.out.println("종료시 x 입력");
			exit = br.readLine();
			
		}while(!exit.equals("x"));
		
		
		
		
		
		

	}	// end of main

}	//end of class
