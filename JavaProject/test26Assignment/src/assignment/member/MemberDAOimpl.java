package assignment.member;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {

	List<MemberVO> list = new ArrayList<MemberVO>();
	int count = 1;

	// 1. insert
	public int insert(MemberVO vo) {
		System.out.println("insert-------------");
		list.add(vo);
		int flag = 0;
		vo.setNum(count);
		try {
			System.out.print(vo.getNum() + "  ");
			System.out.print(vo.getId() + "\t");
			System.out.print(vo.getPw() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.println("\t" + vo.getTel()+"\n");
			flag = 1;
			count++;
		} catch(Exception e) {
			flag = 0;
		}
		return flag;
	}
	

	// 2. update
	public int update(MemberVO vo) {
		System.out.println("update-------------");
		list.set(vo.getNum()-1, vo);
		int flag = 0;
		
		try {
			System.out.print(vo.getNum() + "  ");
			System.out.print(vo.getId() + "\t");
			System.out.print(vo.getPw() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.println("\t" + vo.getTel()+ "\n");
			flag = 1;
			
		} catch (Exception e) {
			flag = 0;
		}
		
		return flag;
	}

	// 3. delete
	public int delete(MemberVO vo) {
		System.out.println("delete-------------");
		list.remove(vo.getNum()-1);
		int flag = 0;
		
		try {
			// delete 하고나서 글 번호가 +1 되는 문제 발생
			System.out.print("삭제가 완료되었습니다.");
			System.out.println();
			
			flag = 1;
			
		} catch(Exception e) {
			flag = 0;
		}
		
		return flag;
	}

	// 4. selectAll
	public List<MemberVO> selectAll() {
		System.out.println("selectAll-------------");
		try {
//			System.out.println(list.get(0));
//			System.out.println(list.get(1));
//			System.out.println(list.get(2));
			return list;
		} catch(Exception e) {
			System.out.println("목록을 불러올 수 없습니다.\n");
			return null;
		}
		
	}

	// 5. selectOne
	public List<MemberVO> selectOne(MemberVO vo) {
		MemberVO mvo = list.get(vo.getNum()-1);
		try {
			System.out.println("selectOne-------------");
			System.out.print(mvo.getNum() + "  ");
			System.out.print(mvo.getId() + "\t");
			System.out.print(mvo.getPw() + "\t");
			System.out.print(mvo.getName() + "\t");
			System.out.println("\t" + mvo.getTel()+ "\n");
			return list;
		} catch(Exception e) {
			System.out.println("목록을 불러올 수 없습니다.\n");
			return null;
		}
		
	}

}
