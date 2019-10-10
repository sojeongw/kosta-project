package test.com;

import java.util.Date;

public class Test04BoardDAO {
	
	Test04BoardVO[] vos;
	int count;	
	
	public Test04BoardDAO() {
		//System.out.println("Test04BoardDAO() 생성자");
		
		count = 0;
		vos = new Test04BoardVO[2];
		vos[0] = new Test04BoardVO();
		vos[1] = new Test04BoardVO();
		
	}
	

	///// insert
	public void insert(Test04BoardVO bvo) {
		//System.out.println("insert");
		System.out.print(bvo.getTitle());
		System.out.print(bvo.getContent() + "\t");
		System.out.print(bvo.getWriter() + "\t");
		
		// 글 번호 + 시간
		bvo.setNum(count + 1);
		bvo.setRegDate(new Date());
		
		vos[count] = bvo;
		count++;
			

		//return 0;
	}

	///// update
	public void update(Test04BoardVO bvo) {
		//System.out.println("update");
		System.out.print(bvo.getNum());
		System.out.print(bvo.getTitle() + "\t");
		System.out.print(bvo.getContent() + "\t");
		System.out.print(bvo.getWriter() + "\t");
		
		bvo.setRegDate(new Date());
		vos[bvo.getNum()-1] = bvo;

		//return 0;
	}

	///// delete
	public void delete(Test04BoardVO bvo) {
		//System.out.println("delete");
		System.out.println(bvo.getNum());
		
		// 새로운 배열을 가리켜서 없어지게
		vos[bvo.getNum()-1] = new Test04BoardVO();	

		//return 0;
	}

	///// selectAll
	public Test04BoardVO[] selectAll() {
		//System.out.println("selectAll");
		
		
		return vos;
	}

	///// select
	public Test04BoardVO select(Test04BoardVO bvo) {
		//System.out.println("select");
		
		

		return vos[bvo.getNum()-1];
	}

} // end of class
