package semi.com.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import semi.com.user.model.BookInfoVO;
import semi.com.user.model.CheckOutVO;
import semi.com.user.model.UserInfoVO;
import semi.com.user.service.BookInfoService;
import semi.com.user.service.CheckOutService;
import semi.com.user.service.UserInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserInfoService uService = new UserInfoService();
	@Autowired
	BookInfoService bService = new BookInfoService();
	@Autowired
	CheckOutService cService = new CheckOutService();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// 대출하기 전 책 목록 보기
	@ResponseBody
	@RequestMapping(value = "/book_selectall.do", method = RequestMethod.GET)
	public Map<String, List<BookInfoVO>> book_selectall(Model model, BookInfoVO vo) {
		logger.info("book_selectall");

		List<BookInfoVO> bookList = bService.book_selectall(vo);
		Map<String, List<BookInfoVO>> map = new HashMap<String, List<BookInfoVO>>();
		map.put("bookList", bookList);

		return map;
	}

	// 대출할 책을 목록에서 선택하기
	@ResponseBody
	@RequestMapping(value = "/book_selectone", method = RequestMethod.GET)
	public BookInfoVO book_selectone(Model model, BookInfoVO vo) {
		logger.info("book_selectone");

		vo.setBook_num(1198057);
		BookInfoVO bvo = bService.book_selectone(vo);

		return bvo;
	}

	// 해당 책 대출하기
	@ResponseBody
	@RequestMapping(value = "/UserCheckOut.do", method = RequestMethod.GET)
	public Map<String, String> UserCheckOut(Model model, CheckOutVO vo) {
		logger.info("UserCheckOut");

		// date를 calendar로 매핑
		Calendar cal = Calendar.getInstance();
		// 대출일
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginD = new Date();
		// format 변경
		String beginDate = formatter.format(beginD);

		// 반납일
		cal.setTime(beginD);
		cal.add(Calendar.DATE, 7);
		Date endD = cal.getTime();
		// format 변경
		String endDate = formatter.format(endD);

		System.out.println("대출일 : " + beginDate);
		System.out.println("반납일 : " + endDate);

		// 테스트용 set
		vo.setBook_num(1198057);
		vo.setUser_id("test_id_01");
		vo.setCheckout_start(beginDate);
		vo.setCheckout_end(endDate);

		// checkout 등록 실행
		int result = cService.book_register(vo);

		// 메시지 담을 hashMap 생성
		Map<String, String> map = new HashMap<String, String>();
		String message;

		if (result == 1) {
			logger.info("book_register(vo) 성공");
			message = "CheckOut InsertOk";
		} else {
			logger.info("book_register(vo) 실패");
			message = "CheckOut Insert Fail";
		}

		map.put("result", message);
		return map;
	}

	// 책 반납하기 >> delete로 구현
	@ResponseBody
	@RequestMapping(value = "/book_return.do", method = RequestMethod.GET)
	public Map<String, String> book_return(Model model, CheckOutVO vo) {
		logger.info("book_return");
		
		vo.setCheckout_num(8);
		int result = cService.book_return(vo);
		
		// 메시지 담을 hashMap 생성
		Map<String, String> map = new HashMap<String, String>();
		String message;
		
		if(result==1) {
			logger.info("book_return(vo) 성공");
			message = "book_return Ok";
		} else {
			logger.info("book_return(vo) 실패");
			message = "book_return Fail";
		}
		
		map.put("result", message);
		return map;
	}

	/////////////////////////////////////////////////////////////

	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String loginOK(UserInfoVO vo, HttpSession session) {
		logger.info("loginOK()....");
		int result = uService.user_login(vo);

		// session.setAttribute("id", vo.getId());
		// session.setAttribute("pw", vo.getPw());
		// session.setAttribute("name", vo.getName());
		// session.setAttribute("age", vo.getAge());
		// session.setAttribute("gender", vo.getGender());
		// session.setAttribute("tel", vo.getTel());
		// session.setAttribute("height", vo.getHeight());
		// session.setAttribute("weight", vo.getWeight());
		// session.setAttribute("goal", vo.getGoal());

		if (result == 1) {
			// session.setAttribute("bycicle_kcal", 0.0);
			// session.setAttribute("rope_kcal", 0.0);
			// session.setAttribute("run_kcal", 0.0);
			return "main";

		} else
			return "redirect:login.do";
	}

	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	@ResponseBody
	public String insertMemberOK(UserInfoVO vo) {
		logger.info("insertOK()....");
		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());
		System.out.println(vo.getUser_tel());
		System.out.println(vo.getUser_name());
		System.out.println(vo.getUser_email());
		System.out.println(vo.getUser_address());

		int result = uService.user_insert(vo);

		if (result == 1)
			return "redirect:home";
		else
			return "redirect:home";
	}

}
