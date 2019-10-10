package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import test.com.model.TestVO;
import test.com.service.TestService;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/index.do", "/json_selectOne.do", "/json_selectAll.do", "/json_selectOneAPI.do", "/json_selectAllAPI.do" })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// service 선언
	TestService service = new TestService();
	////////////////////////////////////////
       
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
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sPath = request.getServletPath();
		
		if(sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/json_selectOne.do")) {
			// jsp 없이 하얀 화면으로 하겠다
			
			TestVO vo = new TestVO();
			
			// lee를 가져가서 lee라는 이름에 해당하는 나이와 이름을 보내줘
			vo.setName("lee");
			
			TestVO tvo = service.json_selectOne(vo);
			
			// 텍스트 나오게 하는 법
			response.getWriter().append(" {\"name\":\""+tvo.getName()+",\"age\":"+tvo.getAge()+"}");
			
		}else if(sPath.equals("/json_selectAll.do")) {
			List<TestVO> list = service.json_selectAll();
			
			response.getWriter().append("[");
			for(int i=0; i<list.size(); i++) {
				// 텍스트 나오게 하는 법
				response.getWriter().append(" {\"name\":\""+list.get(i).getName()+",\"age\":"+list.get(i).getAge()+"}");
				if(i!=list.size()-1) response.getWriter().append(",");
			}
			response.getWriter().append("]");
			
		}else if(sPath.equals("/json_selectOneAPI.do")) {
			// jsp 없이 하얀 화면으로 하겠다
			
			TestVO vo = new TestVO();
			
			// lee를 가져가서 lee라는 이름에 해당하는 나이와 이름을 보내줘
			vo.setName("lee");
			
			TestVO tvo = service.json_selectOne(vo);
			
			// 텍스트 나오게 하는 법
			// response.getWriter().append(" {\"name\":\""+tvo.getName()+",\"age\":"+tvo.getAge()+"}");

			JSONObject jobj = new JSONObject(tvo);
			response.getWriter().print(jobj);
		}else if(sPath.equals("/json_selectAllAPI.do")) {
			List<TestVO> list = service.json_selectAll();
			JSONArray jarray = new JSONArray(list);
			response.getWriter().print(jarray);
		}
	
	}
}
