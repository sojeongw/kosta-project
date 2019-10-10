package assignment.com;

import java.util.Date;

public class Asm01BoardDAO {
	
	
	
	// 1. insert
	public void insert(Asm01BoardVO bVO) {
		//System.out.println("insert");
		System.out.println();
		System.out.print(bVO.getNum() + "  ");
		System.out.print(bVO.getTitle() + "\t");
		System.out.print(bVO.getContent() + "\t");
		System.out.print(bVO.getName());
		System.out.println("\t" + bVO.getDate());
		System.out.println();
		
		
		
	}
	
	
	
	// 2. update
	public void update(Asm01BoardVO bVO) {
		System.out.println();
		System.out.print(bVO.getNum() + "  ");
		System.out.print(bVO.getTitle() + "\t");
		System.out.print(bVO.getContent() + "\t");
		System.out.print(bVO.getName());
		System.out.println("\t" + bVO.getDate());
		System.out.println();
	}
	
	
	
	// 3. delete
	public void delete(Asm01BoardVO bVO) {
		System.out.println();
		System.out.print(bVO.getNum() + "  ");
		System.out.println();
		System.out.println();
	}
	
	
	
	// 4. selectAll
	public Asm01BoardVO[] selectAll() {
		Asm01BoardVO[] bArr = new Asm01BoardVO[3];
		Asm01BoardVO b01 = new Asm01BoardVO();
		Asm01BoardVO b02 = new Asm01BoardVO();
		Asm01BoardVO b03 = new Asm01BoardVO();
		
		
		bArr[0] = b01;
		bArr[1] = b02;
		bArr[2] = b03;
		
		b01.setNum(1);
		b01.setTitle("소정아 사랑해!");
		b01.setContent("나랑 결혼해줄래?\t");
		b01.setName("박보검");
		b01.setDate(new Date());
		
		b02.setNum(2);
		b02.setTitle("소정아 사랑해!");
		b02.setContent("내가 더 많이 사랑해!\t");
		b02.setName("서강준");
		b02.setDate(new Date());
		
		b03.setNum(3);
		b03.setTitle("소정아 사랑해!");
		b03.setContent("내가 더 더 많이 사랑해!\t");
		b03.setName("유승호");
		b03.setDate(new Date());
		
		
		return bArr;
	}
	
	
	
	// 5. selectOne
	public void selectOne(Asm01BoardVO bVO) {
		System.out.println(bVO.getNum());
	}
	
}	// end of class
