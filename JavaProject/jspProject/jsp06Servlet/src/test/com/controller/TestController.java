package test.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/index.do", "/test.do", "/insert.do" })
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
		}
	}

}
