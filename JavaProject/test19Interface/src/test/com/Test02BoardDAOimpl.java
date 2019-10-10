package test.com;

import java.util.Date;

public class Test02BoardDAOimpl implements Test02BoardDAO{
	
	Test02BoardVO[] vos;
	int count;
	
	public Test02BoardDAOimpl(){
		vos = new Test02BoardVO[2];
		vos[0] = new Test02BoardVO();
		vos[1] = new Test02BoardVO();
		count = 0;
	}

	@Override
	public int insert(Test02BoardVO vo) {
		System.out.println("insert");
		vo.setNum(count + 1);
		System.out.print(vo.getNum() + "\t");
		System.out.print(vo.getTitle() + "\t");
		System.out.print(vo.getContent() + "\t");
		System.out.print(vo.getName() + "\t");
		vo.setDate(new Date());
		System.out.print(vo.getDate() + "\t");
		System.out.println();
		
		vos[count] = vo;
		count++;
		return 0;
	}

	@Override
	public int update(Test02BoardVO vo) {
		System.out.println("update");
		
		System.out.print(vo.getNum() + "\t");
		System.out.print(vo.getTitle() + "\t");
		System.out.print(vo.getContent() + "\t");
		System.out.print(vo.getName() + "\t");
		vo.setDate(new Date());
		System.out.print(vo.getDate() + "\n");
		System.out.println();
		
		this.vos[vo.getNum()-1] = vo;
		
		return 0;
	}

	@Override
	public int delete(Test02BoardVO vo) {
		System.out.println("delete");
		System.out.println(vo.getNum() + "번 글이 삭제되었습니다.");
		this.vos[vo.getNum()-1] = new Test02BoardVO();
		
		return 0;
		
	}

	@Override
	public Test02BoardVO selectOne(Test02BoardVO vo) {
		System.out.println("selectOne");
		System.out.print(vo.getNum() + "\t");
		System.out.print(this.vos[vo.getNum()-1].getTitle() + "\t");
		System.out.print(this.vos[vo.getNum()-1].getContent() + "\t");
		System.out.print(this.vos[vo.getNum()-1].getName() + "\t");
		System.out.print(this.vos[vo.getNum()-1].getDate() + "\n");
		
		return this.vos[vo.getNum()-1];
	}

	@Override
	public Test02BoardVO[] selectAll() {
		System.out.println("selectAll");
//		for(int i=0; i<this.vo.length; i++) {
//			System.out.println("");
//			System.out.print(this.vo[i].getNum() + "\t");
//			System.out.print(this.vo[i].getTitle() + "\t");
//			System.out.print(this.vo[i].getContent() + "\t");
//			System.out.print(this.vo[i].getName() + "\t");
//			System.out.print(this.vo[i].getDate() + "\n");
//			}
		
		return this.vos;
	}

}
