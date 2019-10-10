package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.boardDAO;
import test.com.model.boardDAOimpl;
import test.com.model.boardVO;

/**
 * Servlet implementation class memberController
 */
@WebServlet({"/bIndex.do", "/bInsert.do", "/bInsertOK.do", "/bDelete.do", "/bDeleteOK.do",
	"/bSelectAll.do", "/bUpdate.do", "/bUpdateOK.do"})
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public boardController() {
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
		
		if(request.getServletPath().equals("/bIndex.do")) {
			/*index.do로 요청했다면 index.jsp로 이동하고 싶다고 '설정'*/
			RequestDispatcher rd = request.getRequestDispatcher("bIndex.jsp");
			/*이동 >> request 객체와 response 객체를 넣어준다*/
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/bInsert.do")) {
			// 테스트
			System.out.println("/mInsert.do : " + request.getParameter("id"));
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bInsert.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/bInsertOK.do")) {
			//System.out.println("/mInsertOK.do : " + request.getParameter("id"));
			
			boardVO vo = new boardVO();
			boardDAO dao = new boardDAOimpl();

			vo.setNum(99);
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			
			int result = dao.insert(vo);
			
			if(result == 1) {
				System.out.println("servlet_insert complete");
				response.sendRedirect("bSelectAll.do");
			}else {
				System.out.println("servlet_insert fail");
				response.sendRedirect("bInsert.do");
			}
			
		}
		else if(request.getServletPath().equals("/bSelectAll.do")) {
			boardDAO dao = new boardDAOimpl();
			List<boardVO> list = dao.selectAll(); 
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bSelectAll.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/bUpdate.do")) {
			System.out.println("bUpdate.do : " + request.getParameter("num"));
			
			boardVO vo = new boardVO();
			boardDAO dao = new boardDAOimpl();
			
			boardVO bvo = dao.selectOne(vo);
			
			request.setAttribute("bvo", bvo);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bUpdate.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/bUpdateOK.do")) {
			System.out.println("bUpdateOK.do : " + request.getParameter("num"));
			boardVO vo = new boardVO();
			boardDAO dao = new boardDAOimpl();
			
			//System.out.println(request.getParameter("id"));
			
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			
			int result = dao.update(vo);
			
			if(result == 1) {
				System.out.println("servlet_update complete");
				response.sendRedirect("bSelectAll.do");
			}else {
				System.out.println("servlet_update fail");
				response.sendRedirect("bUpdate.do");
			}
			
		}else if(request.getServletPath().equals("/bDeleteOK.do")) {
			// 테스트
			//System.out.println("/mInsert.do : " + request.getParameter("id"));
			
			boardDAO dao = new boardDAOimpl();
			boardVO vo = new boardVO();
			
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			dao.delete(vo);
			
			response.sendRedirect("bSelectAll.do");
		}
		
		
	}

}
