package kmw.com.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kmw.com.admin.model.Login_VO;
import kmw.com.admin.service.Login_Service;


/**
 * Handles requests for the application home page.
 */
@Controller
public class Login_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Login_Controller.class);
	

	@Autowired
	Login_Service LoginService;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/login.do"}, method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("login.do");
	
			return "loginPage";

	}
		
	@RequestMapping(value = {"/loginOK.do"}, method = RequestMethod.POST)
	public String loginOK(Locale locale, Model model, HttpSession session, Login_VO vo) {
		
		System.out.println("loginok.do");
		Login_VO loginvo = LoginService.LoginSelectOne(vo);
		
		
		if(loginvo != null) {
			session.setAttribute("login", loginvo.getId());
			model.addAttribute("login", session.getAttribute("login"));
			return "testPage";
		} else 
			return "redirect:login.do";
	}
	
	@RequestMapping(value = {"/AndroidLoginSelectOne.do"}, method = RequestMethod.GET)
	@ResponseBody 
	public Login_VO LoginSelectOne(Login_VO vo) {
		logger.info("AndroidLoginSelectOne.do");
		Login_VO loginvo = LoginService.AndroidLoginSelectOne(vo);
			return loginvo;

	}
	
	@RequestMapping(value = {"/logoutOK.do"}, method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {
		logger.info("logout.do");
		session.invalidate();
			return "loginPage";

	}
	
}












