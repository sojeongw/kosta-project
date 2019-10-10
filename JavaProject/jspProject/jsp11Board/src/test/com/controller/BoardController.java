package test.com.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.BoardVO;
import test.com.service.BoardService;

/**
 * Servlet implementation class memberController
 */
@WebServlet({ "/BoardIndex.do", "/BoardInsert.do", "/BoardInsertOK.do", "/BoardDelete.do", "/BoardDeleteOK.do",
		"/BoardSelectAll.do", "/BoardUpdate.do", "/BoardUpdateOK.do" })
public class BoardController extends HttpServlet {

	private BoardService bService = new BoardService();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardController() {
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

		String sPath = request.getServletPath();
		System.out.println("sPath: " + sPath);

		if (sPath.equals("/BoardIndex.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("BoardIndex.jsp");
			rd.forward(request, response);
			///////////////////////////////////
		} else if (sPath.equals("/BoardSelectAll.do")) {
			List<BoardVO> list = new ArrayList<>();
			list = bService.selectAll();

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/BoardSelectAll.jsp");
			rd.forward(request, response);
			///////////////////////////////////
		} else if (sPath.equals("/BoardInsert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/BoardInsert.jsp");
			rd.forward(request, response);
			///////////////////////////////////
		} else if (sPath.equals("/BoardInsertOK.do")) {

			BoardVO vo = new BoardVO();
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			//vo.setReg_Date(new Date());

			int result = bService.insert(vo);

			if (result == 1) {
				System.out.println("insert 성공");
				response.sendRedirect("BoardSelectAll.do");
			} else {
				System.out.println("insert 실패");
				response.sendRedirect("BoardSelectAll.do");
			}
		}
		/////////////////////////////////
		else if (sPath.equals("/BoardDeleteOK.do")) {
			BoardVO vo = new BoardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			int result = bService.delete(vo);

			if (result == 1) {
				System.out.println("delete 성공");
				response.sendRedirect("BoardSelectAll.do");
			} else {
				System.out.println("delete 실패");
				response.sendRedirect("BoardSelectAll.do");
			}
			//////////////////////////////////////
		} else if (sPath.equals("/BoardUpdate.do")) {
			BoardVO vo = new BoardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			BoardVO bvo = bService.selectOne(vo);
			
			request.setAttribute("bvo", bvo);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/BoardUpdate.jsp");
			rd.forward(request, response);
		////////////////////////////////////////
		} else if (sPath.equals("/BoardUpdateOK.do")) {
			BoardVO vo = new BoardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			//vo.setReg_Date(new Date());
			
			int result = bService.update(vo);
			
			if(result == 1) {
				System.out.println("update 완료");
				response.sendRedirect("BoardSelectAll.do");
			} else {
				System.out.println("update 실패");
				response.sendRedirect("BoardSelectAll.do");
			}
		}

	}

}
