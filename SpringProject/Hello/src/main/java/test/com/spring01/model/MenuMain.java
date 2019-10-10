package test.com.spring01.model;

import java.util.*;

public class MenuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("menu");

		// 1.insert
		/*
		 * MenuDAO dao = new MenuDAOimpl(); MenuVO vo = new MenuVO();
		 * vo.setMenu("bento"); vo.setPrice(10000); vo.setStore("ich"); vo.setKcal(900);
		 * int result = dao.insert(vo);
		 * 
		 * if(result==1) { System.out.println("insert 성공"); }else {
		 * System.out.println("insert 실패"); }
		 */
		///////////////////////////////////////

		// 2.select
		/*MenuDAO dao = new MenuDAOimpl();
		List<MenuVO> list = dao.selectAll();
		System.out.println("list.size() : " + list.size());*/
		///////////////////////////////////////
		
		// 3.selectOne
		/*MenuDAO dao = new MenuDAOimpl();
		MenuVO vo = new MenuVO();
		vo.setNum(4);
		MenuVO mvo = dao.selectOne(vo);
		System.out.println(mvo.getNum());
		System.out.println(mvo.getMenu());
		System.out.println(mvo.getPrice());
		System.out.println(mvo.getStore());
		System.out.println(mvo.getKcal());*/
		
		// 4.update
		/*MenuDAO dao = new MenuDAOimpl();
		MenuVO vo = new MenuVO();
		vo.setNum(4);
		vo.setMenu("bento");
		vo.setPrice(10000);
		vo.setStore("ich");
		vo.setKcal(900);
		dao.update(vo);*/
		
		// 5.delete
		/*MenuDAO dao = new MenuDAOimpl();
		MenuVO vo = new MenuVO();
		vo.setNum(4);
		int result = dao.delete(vo);
		System.out.println(result);*/
	}

}
