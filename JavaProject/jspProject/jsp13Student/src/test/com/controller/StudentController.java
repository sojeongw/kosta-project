package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.StudentDAO;
import test.com.model.StudentDAOimpl;
import test.com.model.StudentVO;
import test.com.service.StudentService;

/**
 * Servlet implementation class memberController
 */
@WebServlet({"/StudentIndex.do", "/StudentInsert.do", "/StudentInsertOK.do", "/StudentDelete.do", "/StudentDeleteOK.do",
	"/StudentSelectAll.do", "/StudentUpdate.do", "/StudentUpdateOK.do"})
public class StudentController extends HttpServlet {
	private StudentService sService = new StudentService();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
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
		
		if(request.getServletPath().equals("/StudentIndex.do")) {
			/*index.do로 요청했다면 index.jsp로 이동하고 싶다고 '설정'*/
			RequestDispatcher rd = request.getRequestDispatcher("StudentIndex.jsp");
			/*이동 >> request 객체와 response 객체를 넣어준다*/
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/StudentInsert.do")) {
			// 테스트
			System.out.println("/StudentInsert.do : " + request.getParameter("name"));
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/StudentInsert.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/StudentInsertOK.do")) {
			//System.out.println("/mInsertOK.do : " + request.getParameter("id"));
			
			StudentVO vo = new StudentVO();

			vo.setName(request.getParameter("name"));
			vo.setKor(Integer.parseInt(request.getParameter("kor")));
			vo.setEng(Integer.parseInt(request.getParameter("eng")));
			vo.setMath(Integer.parseInt(request.getParameter("math")));
			vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
			vo.setAvg((double) vo.getTotal() / 3);

			String grade = "";
			if (vo.getAvg() >= 90) {
				grade = "A";
			} else if (vo.getAvg() >= 80) {
				grade = "B";
			} else if (vo.getAvg() >= 70) {
				grade = "C";
			} else {
				grade = "D";
			}
			vo.setGrade(grade);
			
			int result = sService.insert(vo);
			
			if(result == 1) {
				System.out.println("servlet_insert complete");
				response.sendRedirect("StudentSelectAll.do");
			}else {
				System.out.println("servlet_insert fail");
				response.sendRedirect("StudentInsert.do");
			}
			
		}
		else if(request.getServletPath().equals("/StudentSelectAll.do")) {
			StudentDAO dao = new StudentDAOimpl();
			List<StudentVO> list = dao.selectAll(); 
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/StudentSelectAll.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/StudentUpdate.do")) {
			StudentVO vo = new StudentVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			StudentVO svo = sService.selectOne(vo);
			
			request.setAttribute("svo", svo);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/StudentUpdate.jsp");
			rd.forward(request, response);
		}
		else if(request.getServletPath().equals("/StudentUpdateOK.do")) {
			System.out.println("StudentUpdateOK.do : " + request.getParameter("num"));
			StudentVO vo = new StudentVO();
			
			//System.out.println(request.getParameter("id"));
			
			/*vo.setName(request.getParameter("name"));*/
			vo.setKor(Integer.parseInt(request.getParameter("kor")));
			vo.setEng(Integer.parseInt(request.getParameter("eng")));
			vo.setMath(Integer.parseInt(request.getParameter("math")));
			vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
			vo.setAvg((double) vo.getTotal() / 3);

			String grade = "";
			if (vo.getAvg() >= 90) {
				grade = "A";
			} else if (vo.getAvg() >= 80) {
				grade = "B";
			} else if (vo.getAvg() >= 70) {
				grade = "C";
			} else {
				grade = "D";
			}
			vo.setGrade(grade);
			
			int result = sService.update(vo);
			
			if(result == 1) {
				System.out.println("servlet_update complete");
				response.sendRedirect("StudentSelectAll.do");
			}else {
				System.out.println("servlet_update fail");
				response.sendRedirect("StudentUpdate.do");
			}
			
		}else if(request.getServletPath().equals("/StudentDeleteOK.do")) {
			// 테스트
			//System.out.println("/mInsert.do : " + request.getParameter("id"));
			StudentVO vo = new StudentVO();
			
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			sService.delete(vo);
			
			response.sendRedirect("StudentSelectAll.do");
		}
		
		
	}

}
