package test.com.spring01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/*
	 * value를 여러 개 넣을 수 있다. 여러 개면 배열로도 넣을 수 있다. 
	 * 이 메소드는 /가 오면 동작을 실행시킨다.
	 * get방식이기 때문에 post면 동작 안 한다. 무조건 get방식으로 적어줘야 한다.
	 * 
	 * 'home'처럼 요청하는 것으로 이름을 만든다.
	 * 얘는 서블릿 하나당 하나의 메소드만 오기 때문에 찾기가 편하다.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
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
	}

}
