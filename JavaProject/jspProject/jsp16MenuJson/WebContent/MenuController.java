package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.MenuVO;
import test.com.service.MenuService;

/**
 * Servlet implementation class MenuController
 */
@WebServlet({ "/index.do", "/insert.do", "/insertOK.do", "/update.do", "/updateOK.do", "/deleteOK.do", "/select.do",
		"/jSelectOne.do", "/jSelectAll.do" })
public class MenuController extends HttpServlet {

	/*
	 * dao를 만지려면 항상 컨트롤러로 와야하는 번거로움이 있어서 가교역할을 하는 repository, 저장소를 만든다. = dao 연결시켜주는
	 * service는 service 오브젝트. 이 안에는 MenuDAO에 있는 메소드들로 구성을 해준다. 컨트롤러는 service를 불러오고
	 * service는 dao를 불러오고. >> 루즈 커플링. 결속력을 느슨하게 해서 코딩상으로 중간에 관여를 할 수 있도록 한다. <-> 타이트
	 * 커플링 관점 지향 프로그래밍 : 관제하다가 처리해주는 프로그래밍. = AOP(Aspect Oriented Programming) 공통으로
	 * 들어가는 것의 뼈대를 잘 만들어주기 위한 게 controller dao가 들어가는건 repository 중간에 연결해주는 건 service
	 * 이 구조로 만들지 않으면 AOP가 적용되지 못한다. 직접 관여하지 않고 가교 역할을 하는 object를 만들고 dao를 대신 call해서
	 * 결과는 똑같이 받는다.
	 * 
	 */
	private MenuService mService = new MenuService();
	/* private MenuDAO dao = new MenuDAOimpl(); */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sPath = request.getServletPath();
		System.out.println("sPath : " + sPath);

		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("menu/insert.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insertOK.do")) {

			// 1.insert
			MenuVO vo = new MenuVO();
			vo.setMenu(request.getParameter("menu"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			vo.setStore(request.getParameter("store"));
			vo.setKcal(Integer.parseInt(request.getParameter("kcal")));
			int result = mService.insert(vo);

			if (result == 1) {
				System.out.println("insert 성공");
				response.sendRedirect("select.do");
			} else {
				System.out.println("insert 실패");
			}
			///////////////////////////////////////

		} else if (sPath.equals("/update.do")) {

			// 3.selectOne

			MenuVO vo = new MenuVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			MenuVO mvo = mService.selectOne(vo);

			request.setAttribute("mvo", mvo);

			RequestDispatcher rd = request.getRequestDispatcher("menu/update.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/updateOK.do")) {

			MenuVO vo = new MenuVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setMenu(request.getParameter("menu"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			vo.setStore(request.getParameter("store"));
			vo.setKcal(Integer.parseInt(request.getParameter("kcal")));

			int result = mService.update(vo);

			if (result == 1) {
				System.out.println("update 성공");
				response.sendRedirect("select.do");
			} else {
				System.out.println("update 실패");
				response.sendRedirect("update.do?num=" + request.getParameter("kcal"));
			}

		} else if (sPath.equals("/deleteOK.do")) {

			MenuVO vo = new MenuVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));

			int result = mService.delete(vo);

			if (result == 1) {
				System.out.println("delete 성공");
			} else {
				System.out.println("delete 실패");
			}
			response.sendRedirect("select.do");

		} else if (sPath.equals("/select.do")) {

			// 2.select

			List<MenuVO> list = mService.selectAll();
			System.out.println("list.size() : " + list.size());
			///////////////////////////////////////

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("menu/select.jsp");
			rd.forward(request, response);
			
		} else if(sPath.equals("/jSelectOne.do")) {
			MenuVO vo = new MenuVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			MenuVO mvo = mService.selectOne(vo);
			PrintWriter pw = response.getWriter();
			// vo에 있는 속성들이 json이 된다.
			
			pw.append("{\"num\":"+mvo.getNum()+","
					+ "\"menu\":\""+mvo.getMenu()+"\","
					+ "\"price\":"+mvo.getPrice()+","
					+ "\"store\":\""+mvo.getStore()+"\","
					+ "\"kcal\":"+mvo.getKcal()+"}");
		}

	}
}
