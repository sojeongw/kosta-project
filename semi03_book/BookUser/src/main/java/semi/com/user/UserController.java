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

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(UserInfoVO vo, HttpSession session) {
		logger.info("login()....");

		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());

		int result = uService.user_login(vo);

		Map<String, String> map = new HashMap<String, String>();
		if (result == 1) {

			map.put("result", "login successed");

		} else
			map.put("result", "login failed");

		return map;

	}
	//////////

	///// 회원가입/////
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> insertOK(UserInfoVO vo) {
		logger.info("insertOK()....");
		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());
		System.out.println(vo.getUser_tel());
		System.out.println(vo.getUser_name());
		System.out.println(vo.getUser_email());
		System.out.println(vo.getUser_address());

		int result = uService.user_insert(vo);

		Map<String, String> map = new HashMap<String, String>();
		if (result == 1)
			map.put("result", "insert successed");
		else
			map.put("result", "insert failed");

		return map;
	}

	///// 회원정보 한명 것 가져오기(업데이트 시 필요)//////
	@RequestMapping(value = "/selectone.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, UserInfoVO> selectone(UserInfoVO vo) {
		logger.info("selectone()....");

		vo = uService.user_selectone(vo);

		Map<String, UserInfoVO> map = new HashMap<String, UserInfoVO>();

		if (vo != null)
			map.put("result", vo);
		else
			System.out.println("실패");

		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());
		System.out.println(vo.getUser_tel());
		System.out.println(vo.getUser_name());
		System.out.println(vo.getUser_email());
		System.out.println(vo.getUser_address());

		return map;
	}

	//////// 업데이트OK//////////
	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> update(UserInfoVO vo) {
		logger.info("updateOK()....");

		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());
		System.out.println(vo.getUser_name());
		System.out.println(vo.getUser_tel());
		System.out.println(vo.getUser_email());
		System.out.println(vo.getUser_address());

		int result = uService.user_update(vo);
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(result + "!!!!!!!!!!!!!!!!!!!!!!!!!");
		if (result == 1)
			map.put("result", "update successed");
		else
			map.put("result", "update failed");

		return map;
	}

	///////////////// 회원 삭제///////////
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(UserInfoVO vo) {
		logger.info("delete()....");

		int result = uService.user_delete(vo);

		Map<String, String> map = new HashMap<String, String>();
		if (result == 1)
			map.put("result", "delete successed");
		else
			map.put("result", "delete failed");

		return map;
	}

	////// 중복검사////////
	@RequestMapping(value = "/duplication_check.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> duplication_check(UserInfoVO vo) {
		logger.info("duplication_check()....");

		int result = uService.duplication_check(vo);

		Map<String, String> map = new HashMap<String, String>();
		if (result == 1)
			map.put("result", "You can use this ID");
		else
			map.put("result", "You can't use this ID");

		return map;
	}

	//////////// 곤듀꼬/////////////

	// 대출한 책 목록 보기
	@ResponseBody
	@RequestMapping(value = "/checkoutList.do", method = RequestMethod.GET)
	public /* Map<String, */List<CheckOutVO>/* > */ checkoutList(Model model, CheckOutVO vo) {
		logger.info("checkoutList");

		List<CheckOutVO> bookList = cService.checkoutList(vo);
		
		return bookList;
	}

	// 대출하기 전 책 목록 보기
	@ResponseBody
	@RequestMapping(value = "/book_selectall.do", method = RequestMethod.GET)
	public /* Map<String, */List<BookInfoVO>/* > */ book_selectall(Model model, BookInfoVO vo) {
		logger.info("book_selectall");

		List<BookInfoVO> bookList = bService.book_selectall(vo);
		Map<String, List<BookInfoVO>> map = new HashMap<String, List<BookInfoVO>>();
		map.put("bookList", bookList);

		return bookList;
	}

	// 대출할 책을 목록에서 선택하기
	@ResponseBody
	@RequestMapping(value = "/book_selectone", method = RequestMethod.GET)
	public Map<String, BookInfoVO>  book_selectone(Model model, BookInfoVO vo) {
		logger.info("book_selectone");

		// vo.setBook_num(1198057);
		BookInfoVO bvo = bService.book_selectone(vo);
		System.out.println(vo.getBook_num());
		

			Map<String, BookInfoVO> map = new HashMap<String, BookInfoVO>();
		
		map.put("result", bvo);
		return map;
	}

	// 해당 책 대출하기
	@ResponseBody
	@RequestMapping(value = "/UserCheckOut.do", method = RequestMethod.POST)
	public Map<String, String> UserCheckOut(Model model, CheckOutVO vo) {
		logger.info("UserCheckOut");

		
		// 메시지 담을 hashMap 생성
		Map<String, String> map = new HashMap<String, String>();
		String message = null;

		
		///대출 가능한 책인지 검사
		BookInfoVO bvo = new BookInfoVO();
		bvo.setBook_num(vo.getBook_num());
		
		bvo = bService.book_selectone(bvo);
		
		try {
		if(bvo.getBook_checkout().equals("false")) {
		logger.info("book_register(vo) 실패, 이미 대출된 책입니다.");
		message = "Already Checked Book, You Can't Borrow";

		map.put("result", message);
		return map;
		}
		}catch (Exception NullPointerException) {


			logger.info("DB Table에 없는 책번호");
			message = "The Book does not exist";
			map.put("result", message);
			return map;
		
		}
		
		

		
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
//		vo.setBook_num(1198057);
//		vo.setUser_id("a");
		vo.setCheckout_start(beginDate);
		vo.setCheckout_end(endDate);

		// checkout 등록 실행
		int result = cService.book_register(vo);


		if (result == 1) {
			logger.info("book_register(vo) 성공");
		
			/////book_info table에 true를 false로 바꾸기
			bvo.setBook_checkout("false");
			result = bService.book_changeTF(bvo);
			
			if(result ==1)	
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

		if (result == 1) {
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

}
