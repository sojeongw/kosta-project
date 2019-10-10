package assignment.board;

import java.util.*;

public class Test02BoardDAOimpl implements Test02BoardDAO {

	List<Test02BoardVO> list = new ArrayList<Test02BoardVO>();

	@Override
	public int insert(Test02BoardVO vo) {
		//System.out.println("------insert 시작");
		list.add(vo);
		
		int flag = 0;
		try {
			System.out.println(vo.getNum());
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			System.out.println(vo.getName());
			vo.setDate(new Date());
			System.out.println(vo.getDate());

			flag = 1;
		} catch (Exception e) {
			flag = 0;
		} finally {
			System.out.println("------insert 완료\n");
		}

		return flag;
	} // end of insert

	@Override
	public int update(Test02BoardVO vo2) {
		
		int flag = 0;
		try {
			list.set(vo2.getNum()-1, vo2);
			System.out.println(vo2.getNum());
			System.out.println(vo2.getTitle());
			System.out.println(vo2.getContent());
			System.out.println(vo2.getName());
			vo2.setDate(new Date());
			System.out.println(vo2.getDate());

			flag = 1;
		} catch (Exception e) {
			flag = 0;
		} finally {
			System.out.println("------update 완료\n");
		}

		return flag;
	}

	@Override
	public int delete(Test02BoardVO vo) {
		int flag=0;
		
		try {
			list.remove(vo);
			
			flag = 1;
		} catch (Exception e) {
			
		} finally {
			System.out.println("------delete 완료\n");
		}
		return flag;
	}

	@Override
	public List<Test02BoardVO> selectOne(Test02BoardVO vo) {
		try {
			Test02BoardVO vo2 = list.get(vo.getNum()-1);
			System.out.println(vo2.getNum());
			System.out.println(vo2.getTitle());
			System.out.println(vo2.getContent());
			System.out.println(vo2.getName());
			System.out.println(vo2.getDate());
		} catch(Exception e){
			
		} finally {
			System.out.println("------selectOne 완료\n");
		}
		return null;
	}

	@Override
	public List<Test02BoardVO> selectAll() {
		try {
			List<Test02BoardVO> list = this.list;
		} catch(Exception e) {
			
		} finally {
			System.out.println("------selectAll 완료\n");
		}
		return list;
	}

} // end of class

// vo.setNum(count + 1);
// System.out.print(vo.getNum() + "\t");
// System.out.print(vo.getTitle() + "\t");
// System.out.print(vo.getContent() + "\t");
// System.out.print(vo.getName() + "\t");
// vo.setDate(new Date());
// System.out.print(vo.getDate() + "\t");
// System.out.println();
//
// this.vos[count] = vo;
// count++;
// return 0;

// @Override
// public int update(Test02BoardVO vo) {
// System.out.println("update");
//
// System.out.print(vo.getNum() + "\t");
// System.out.print(vo.getTitle() + "\t");
// System.out.print(vo.getContent() + "\t");
// System.out.print(vo.getName() + "\t");
// vo.setDate(new Date());
// System.out.print(vo.getDate() + "\n");
// System.out.println();
//
// this.vos[vo.getNum()-1] = vo;
//
// return 0;
// }
//
// @Override
// public int delete(Test02BoardVO vo) {
// System.out.println("delete");
// System.out.println(vo.getNum() + "번 글이 삭제되었습니다.");
// this.vos[vo.getNum()-1] = new Test02BoardVO();
//
// return 0;
//
// }
//
// @Override
// public Test02BoardVO selectOne(Test02BoardVO vo) {
// System.out.println("selectOne");
// System.out.print(vo.getNum() + "\t");
// System.out.print(this.vos[vo.getNum()-1].getTitle() + "\t");
// System.out.print(this.vos[vo.getNum()-1].getContent() + "\t");
// System.out.print(this.vos[vo.getNum()-1].getName() + "\t");
// System.out.print(this.vos[vo.getNum()-1].getDate() + "\n");
//
// return this.vos[vo.getNum()-1];
// }
//
// @Override
// public Test02BoardVO[] selectAll() {
// System.out.println("selectAll");
//// for(int i=0; i<this.vo.length; i++) {
//// System.out.println("");
//// System.out.print(this.vo[i].getNum() + "\t");
//// System.out.print(this.vo[i].getTitle() + "\t");
//// System.out.print(this.vo[i].getContent() + "\t");
//// System.out.print(this.vo[i].getName() + "\t");
//// System.out.print(this.vo[i].getDate() + "\n");
//// }
//
// return this.vos;
// }
