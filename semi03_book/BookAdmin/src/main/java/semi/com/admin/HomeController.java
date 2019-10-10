package semi.com.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import semi.com.admin.model.BookInfoVO;
import semi.com.admin.model.CheckOutVO;
import semi.com.admin.service.AdminService;
import semi.com.admin.model.UserInfoVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AdminService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/" , "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> insertOK(BookInfoVO vo) {
		logger.info("/insertOK.do");
		logger.info(vo.getBook_content());
		logger.info(vo.getBook_name());
		int flag = service.book_insert(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(flag == 1) {
			map.put("result", "insert successed");
		}else {
			map.put("result", "insert failed");
		}
		
		return map;
	}
	
	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> deleteOK(BookInfoVO vo) {
		logger.info("/deleteOK.do");
		
		int flag = service.book_delete(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(flag == 1) {
			map.put("result", "delete successed");
		}else {
			map.put("result", "delete failed");
		}
		
		return map;
	}
	
	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateOK(BookInfoVO vo) {
		logger.info("/updateOK.do");
		
		int flag = service.book_update(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(flag == 1) {
			map.put("result", "update successed");
		}else {
			map.put("result", "update failed");
		}
		
		return map;
	}
	
	@RequestMapping(value = "/returnOK.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> returnOK(BookInfoVO vo,CheckOutVO cvo) {
		logger.info("/returnOK.do");
		
		int flag = service.book_return(vo);
		flag += service.book_return_delete(cvo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(flag == 2) {
			map.put("result", "update successed");
		}else {
			map.put("result", "update failed");
		}
		
		return map;
	}
	
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public List<BookInfoVO> selectAll() {
		logger.info("/selectAll.do");
		List<BookInfoVO> list = service.book_selectAll();
		
//		Map<String,List<BookInfoVO>> map = new HashMap<String, List<BookInfoVO>>();
//		
//		map.put("list", list);
//		
		return list;
		
	}
	
	@RequestMapping(value = "/checkOutSelectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CheckOutVO> checkOutSelectAll() {
		logger.info("/checkOutSelectAll.do");
		List<CheckOutVO> list = service.book_checkout_selectAll();
	
//		Map<String,List<BookInfoVO>> map = new HashMap<String, List<BookInfoVO>>();
//		
//		map.put("list", list);
//		
		return list;
		
	}
	
	// 로그인
		@RequestMapping(value = "/login.do", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, String> login(UserInfoVO vo) {
			logger.info("login()....");

			System.out.println(vo.getUser_id());
			System.out.println(vo.getUser_pw());

			int result = service.user_login(vo);

			Map<String, String> map = new HashMap<String, String>();
			if (result == 1) {

				map.put("result", "login successed");

			} else
				map.put("result", "login failed");

			return map;

		}
	
}
