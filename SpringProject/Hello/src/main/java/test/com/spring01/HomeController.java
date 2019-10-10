package test.com.spring01;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import test.com.spring01.model.MenuVO;
import test.com.spring01.service.MenuService;

import org.springframework.beans.factory.annotation.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// TestService service = new TestService();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// autowired : 끌어당겨줄 때 사용

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = { "/index.do" }, method = RequestMethod.GET)
	public String index() {

		return "menu/index";
	}

	// value를 여러 개 넣을 수 있다. 여러 개면 배열로도 넣을 수 있다.
	// /가 오면 이 동작 실행시킨다.
	// get방식이기 때문에 post면 동작 안 한다. 무조건 get방식으로 적어줘야 한다.

	// 'home'처럼 요청하는 것으로 이름을 만든다.
	// 얘는 서블릿 하나당 하나의 메소드만 오기 때문에 찾기가 편하다.
	@RequestMapping(value = { "/", "/home.do" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// 로그를 찍는 세 가지 방법
		logger.info("aaaa");
		logger.info(locale.toString());
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		// 값 세팅
		model.addAttribute("serverTime", formattedDate);

		return "home";
	} // end of method

	

}
