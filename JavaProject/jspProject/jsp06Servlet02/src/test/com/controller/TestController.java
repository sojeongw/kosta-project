package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.TestDAO;
import test.com.model.TestDAOimpl;
import test.com.model.TestVO;

/**
 * Servlet implementation class TestController
 */

/*1. 잘 매핑 되어있는지
2. 슬래쉬가 잘 있는지
3. 같은 글자가 있는지*/

@WebServlet({ "/index.do", "/test.do", "/insert.do", "/insertOK.do", "/selectAll.do",
	"/update.do", "/updateOK.do", "/deleteOK.do"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost...");
		
		/*post 방식에서 깨지니까 여기서 utf 설정*/
		request.setCharacterEncoding("UTF-8");
		
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doProcess...");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*response.getWriter() = print와 같은 의미*/
		
		/*index.do로 요청했는지 알기 위해*/
		if(request.getServletPath().equals("/index.do")) {
			/*index.do로 요청했다면 index.jsp로 이동하고 싶다고 '설정'*/
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			/*이동 >> request 객체와 response 객체를 넣어준다*/
			rd.forward(request, response);
			
		}else if(request.getServletPath().equals("/test.do")) {
			System.out.println(request.getParameter("id"));
			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
			
		}else if(request.getServletPath().equals("/insert.do")) {
			System.out.println(request.getParameter("id"));
			/*얘는 jsp에 있다는 걸 알려줘야 함*/
			RequestDispatcher rd = request.getRequestDispatcher("jsp/insert.jsp");
			rd.forward(request, response);
			
		}else if(request.getServletPath().equals("/insertOK.do")) {
			/*테스트*/
			System.out.println(request.getParameter("id"));	
			System.out.println(request.getParameter("pw"));		
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("tel"));

			/*객체 생성*/
			TestVO vo = new TestVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			
			TestDAO dao = new TestDAOimpl();
			int result = dao.insert(vo);
			System.out.println("result : "+result);
			
			if(result == 1){
				System.out.println("complete. move to select");
				// 응답 보내기
				response.sendRedirect("selectAll.do");
			} else {
				System.out.println("fail. go back");
				response.sendRedirect("insert.do");
			}
			
			/*이건 주소가 바뀌어야 하니까, 똑같은게 계속 들어갈 수 있으니까 redirect*/
			/*= 서블릿 주소 요청 값이 아니라서 다시 주소가 노출될 수 있기 때문*/
			//response.sendRedirect("selectAll.do");
			
		}else if(request.getServletPath().equals("/selectAll.do")) {
			
			TestDAO dao = new TestDAOimpl();
			List<TestVO> list = dao.selectAll();
			
			/*request에 넣고 request의 dispatcher에 보낸다*/
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/select.jsp");
			rd.forward(request, response);
			
		}else if(request.getServletPath().equals("/update.do")) {
			TestVO vo = new TestVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			TestDAO dao = new TestDAOimpl();
			TestVO tvo = dao.selectOne(vo);
			
			request.setAttribute("tvo", tvo);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/update.jsp");
			rd.forward(request, response);
			
		}else if(request.getServletPath().equals("/updateOK.do")) {
			
			response.sendRedirect("selectAll.do");
			
		}else if(request.getServletPath().equals("/deleteOK.do")) {
			TestVO vo = new TestVO();	
			//System.out.println(request.getParameter("num"));
		 	vo.setNum(Integer.parseInt(request.getParameter("num"))); 
		 	
		 	TestDAO dao = new TestDAOimpl();
			int result = dao.delete(vo);
			
			if(result == 1){
				System.out.println("complete. move to select");
				response.sendRedirect("selectAll.do");
			} else {
				System.out.println("fail. go back");
				response.sendRedirect("update.do?num="+request.getParameter("num"));
			} 
			
			
		}
	}

}
