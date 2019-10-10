package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

/**
 * Servlet implementation class memberController
 */
@WebServlet({"/mIndex.do", "/mInsert.do", "/mInsertOK.do", "/mDelete.do", "/mDeleteOK.do",
	"/mSelectAll.do", "/mUpdate.do", "/mUpdateOK.do"})
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public memberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet...");
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost...");
		request.setCharacterEncoding("UTF-8");

		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess...");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getServletPath().equals("/mIndex.do")) {
			/*index.do로 요청했다면 index.jsp로 이동하고 싶다고 '설정'*/
			RequestDispatcher rd = request.getRequestDispatcher("mIndex.jsp");
			/*이동 >> request 객체와 response 객체를 넣어준다*/
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/mInsert.do")) {
			// 테스트
			//System.out.println("/mInsert.do : " + request.getParameter("id"));
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/mInsert.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/mInsertOK.do")) {
			//System.out.println("/mInsertOK.do : " + request.getParameter("id"));
			
			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();

			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			
			int result = dao.insert(vo);
			
			if(result == 1) {
				System.out.println("servlet_insert complete");
				response.sendRedirect("mSelectAll.do");
			}else {
				System.out.println("servlet_insert fail");
				response.sendRedirect("mInsert.do");
			}
			
		}
		else if(request.getServletPath().equals("/mSelectAll.do")) {
			MemberDAO dao = new MemberDAOimpl();
			List<MemberVO> list = dao.selectAll(); 
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/mSelectAll.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/mUpdate.do")) {
			
			System.out.println("/mUpdate.do : " + request.getParameter("num"));
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			MemberDAO dao = new MemberDAOimpl();
			
			MemberVO mvo = dao.selectOne(vo);
			
			request.setAttribute("mvo", mvo);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/mUpdate.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/mUpdateOK.do")) {
			System.out.println("/mUpdateOK.do : " + request.getParameter("num"));
			MemberVO vo = new MemberVO();
			MemberDAO dao = new MemberDAOimpl();
			
			//System.out.println(request.getParameter("id"));
			
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));		
			
			int result = dao.update(vo);
			
			if(result == 1) {
				System.out.println("servlet_update complete");
				response.sendRedirect("mSelectAll.do");
			}else {
				System.out.println("servlet_update fail");
				response.sendRedirect("mUpdate.do");
			}
			
		}else if(request.getServletPath().equals("/mDeleteOK.do")) {
			// 테스트
			//System.out.println("/mInsert.do : " + request.getParameter("id"));
			
			MemberDAO dao = new MemberDAOimpl();
			MemberVO vo = new MemberVO();
			
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			dao.delete(vo);
			
			response.sendRedirect("mSelectAll.do");
		}
		
		
	}

}
