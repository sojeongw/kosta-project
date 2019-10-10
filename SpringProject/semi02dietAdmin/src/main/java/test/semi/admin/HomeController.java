package test.semi.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.semi.admin.model.AdminVO;
import test.semi.admin.service.AdminService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	AdminService service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Home Test");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "../home";
		//return "NewFile1";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("/login.do Test");

		return "../login";
	}

	/////// 출처 이진욱
	@RequestMapping(value = "/loginOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginOK(AdminVO vo, HttpSession session) {
		logger.info("/loginOK.do");
		int result = service.login(vo);
		
		session.setAttribute("id", vo.getId());
		session.setAttribute("pw", vo.getPw());
//		session.setAttribute("name", vo.getName());
//		session.setAttribute("age", vo.getAge());
//		session.setAttribute("gender", vo.getGender());
//		session.setAttribute("tel", vo.getTel());
//		System.out.println(vo.getId());		
//		System.out.println(vo.getPw());		
		session.setAttribute("profile_pic", vo.getProfile_pic());
		
		System.out.println(vo.getProfile_pic());
		
		System.out.println(result+"!!!!!!!!!!!!!!!!!!");		
		if(result == 1) {
			if(vo.getId().equals("manager")) {
				return "redirect:ManagerHome.do";
			}else if(vo.getId().equals("admin")) {
				return "redirect:AdminHome.do";
			}else {
				return "home";
			}
		}	else return "home";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("/logout.do Test");
		
		session.invalidate();

		return "home";
	}
 
	
	@RequestMapping(value = {"/Home.do, /main.do"}, method = RequestMethod.GET)
	public String Home(AdminVO vo, HttpSession session) {
		logger.info("/Home.do Test");
		String id = (String) session.getAttribute("id");

		if (id.equals("admin")) {
			return "redirect:AdminHome.do";
		} else if (id.equals("manager")) {
			return "redirect:ManagerHome.do";
			////////// member 페이지 받으면 수정하기 //////////
		} else
			return "home";
	}

	@RequestMapping(value = "/AdminHome.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String AdminHome(HttpSession session) {
		logger.info("AdminHome Test");
	      if (session.getAttribute("id") == null)
	          return "home";
	       else
	     	return "AdminHome";
	}

	@RequestMapping(value = "/ManagerHome.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String ManagerHome(HttpSession session,AdminVO vo) {
		logger.info("/ManagerHome.do Test");

		return "ManagerHome";
	}
	
	@RequestMapping(value = "/main.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String main() {
		logger.info("AdminHome Test");

		return "home";
	}
	
	

}
