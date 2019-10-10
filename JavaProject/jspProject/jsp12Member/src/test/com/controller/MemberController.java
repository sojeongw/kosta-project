package test.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import test.com.model.MemberVO;
import test.com.service.MemberService;

/**
 * Servlet implementation class memberController
 */
@WebServlet({ "/MemberIndex.do", "/MemberInsert.do", "/MemberInsertOK.do", "/MemberDelete.do", "/MemberDeleteOK.do",
		"/MemberSelectAll.do", "/MemberUpdate.do", "/MemberUpdateOK.do", "/MemberSelectOne.do" })
public class MemberController extends HttpServlet {

	private MemberService mService = new MemberService();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
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

		if (sPath.equals("/MemberIndex.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("MemberIndex.jsp");
			rd.forward(request, response);
			
		} else if (sPath.equals("/MemberSelectAll.do")) {
			List<MemberVO> list = mService.selectAll();
			
			JSONArray array = new JSONArray(list);
			response.getWriter().print(array);

			/*request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/MemberSelectAll.jsp");
			rd.forward(request, response);*/
			
		} else if (sPath.equals("/MemberSelectOne.do")) {
			MemberVO vo = new MemberVO();
			vo.setNum(41);
			JSONObject obj = new JSONObject(vo);
			response.getWriter().print(obj);

			/*request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/MemberSelectAll.jsp");
			rd.forward(request, response);*/
			
		} else if (sPath.equals("/MemberInsert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/MemberInsert.jsp");
			rd.forward(request, response);
			
		} else if (sPath.equals("/MemberInsertOK.do")) {
			MemberVO vo = new MemberVO();
			vo.setNum(1);
			vo.setId("test id");
			vo.setPw("test pw");
			vo.setName("test name");
			vo.setTel("011");

			int result = mService.insert(vo);

			if (result == 1) {
				System.out.println("insert 성공");
				response.sendRedirect("MemberSelectAll.do");
			} else {
				System.out.println("insert 실패");
				response.sendRedirect("MemberSelectAll.do");
			}
		} else if(sPath.equals("/MemberDeleteOK.do")) {
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			int result = mService.delete(vo);
			
			if(result==1) {
				System.out.println("delete 성공");
				response.sendRedirect("MemberSelectAll.do");
			} else {
				System.out.println("delete 실패");
				response.sendRedirect("MemberSelectAll.do");
			}
		} else if(sPath.equals("/MemberUpdate.do")) {
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			MemberVO mvo = mService.selectOne(vo);
			
			request.setAttribute("mvo", mvo);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/MemberUpdate.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/MemberUpdateOK.do")) {
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			
			int result = mService.update(vo);
			
			if(result==1) {
				System.out.println("update 성공");
				response.sendRedirect("MemberSelectAll.do");
			} else {
				System.out.println("update 실패");
				response.sendRedirect("MemberSeletAll.do");
			}
			
		}
		

	}

}
