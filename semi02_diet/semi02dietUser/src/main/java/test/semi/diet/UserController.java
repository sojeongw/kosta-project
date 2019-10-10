package test.semi.diet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.method.support.ModelAndViewContainer;

import test.semi.diet.model.KcalVO;
import test.semi.diet.model.UserVO;
import test.semi.diet.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService uService = new UserService();

	// /**
	// * Simply selects the home view to render by returning its name.
	// */
	
	@RequestMapping(value = "insertMember.do", method = RequestMethod.GET)
	public String insertMember() {
		logger.info("insertMember()....");

		return "insertMember";
	}

	@RequestMapping(value = "/insertMemberOK.do", method = RequestMethod.POST)
	public String insertMemberOK(UserVO vo) {
		logger.info("insertMemberOK()....");

		int result = uService.insertMember(vo);

		if (result == 1)
			return "redirect:home.do";
		else
			return "redirect:insertMember.do";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("login()....");

		return "login";
	}

	
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String loginOK(UserVO vo, HttpSession session) {
		logger.info("loginOK()....");
		int result = uService.login(vo);

		session.setAttribute("id", vo.getId());
		session.setAttribute("pw", vo.getPw());
		session.setAttribute("name", vo.getName());
		session.setAttribute("age", vo.getAge());
		session.setAttribute("gender", vo.getGender());
		session.setAttribute("tel", vo.getTel());
		session.setAttribute("height", vo.getHeight());
		session.setAttribute("weight", vo.getWeight());
		session.setAttribute("goal", vo.getGoal());

		if (result == 1) {
			session.setAttribute("bycicle_kcal", 0.0);
			session.setAttribute("rope_kcal", 0.0);
			session.setAttribute("run_kcal", 0.0);
			return "main";
			
		}
		else
			return "redirect:login.do";
	}

	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public String main(HttpSession session) {
		logger.info("main()....");


		
		return "main";
	}

//	@RequestMapping(value = "selectAll.do", method = RequestMethod.GET)
//	public String selectAll() {
//		
//
//		return "selectAll";
//	}

	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(HttpSession session,Model model, HttpServletRequest request) {
	System.out.println("selectAll()....userkcal테이블 가져와서 출력하기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		KcalVO kvo = new KcalVO();
		
		kvo.setId((String)session.getAttribute("id"));
		List<KcalVO> list = uService.selectUserkcal(kvo);
		
		for(int i = 0 ; i < list.size() ; i ++) {
			
			System.out.print(list.get(i).getId()+"!!");
			System.out.print(list.get(i).getDay()+"!!");
			System.out.println(list.get(i).getTotalkcal());
			
		}
		
		model.addAttribute(list);
		request.setAttribute("list", list);
				
		return "selectAll";

	}

	@RequestMapping(value = "/backToMainOK.do", method = RequestMethod.POST)
	public String backToMainOK() {
		logger.info("backToMainOK()....");
		return "redirect:main.do";

	}

	@RequestMapping(value = "up_goal.do", method = RequestMethod.POST)
	public String up_goal(UserVO vo, HttpSession session) {
		logger.info("up_goal()....");
		System.out.println("session.getAttribute(\"id\")"+session.getAttribute("id"));
		System.out.println("session.getAttribute(\"pw\")"+session.getAttribute("pw"));
		System.out.println("session.getAttribute(\"name\")"+session.getAttribute("name"));
		System.out.println("session.getAttribute(\"age\")"+session.getAttribute("age"));
		System.out.println("session.getAttribute(\"goal\")"+session.getAttribute("goal"));

		return "up_goal";
	}

	@RequestMapping(value = "/up_goalOK.do", method = RequestMethod.POST)
	public String up_goalOK(UserVO vo, HttpSession session) {
		logger.info("up_goalOK()....");
		System.out.println("session.getAttribute(\"goal\")"+session.getAttribute("goal"));
		System.out.println(session.getAttribute("id"));
		vo.setId(session.getAttribute("id").toString());
		System.out.println(vo.getGoal());
		int result = uService.up_goal(vo);

		if (result == 1)
			return "main";
		else
			return "redirect:login.do";
	}

	@RequestMapping(value = "up_info.do", method = RequestMethod.POST)
	public String up_info(UserVO vo, HttpSession session) {
		logger.info("up_info()....");
		// vo.setId((String)session.getAttribute("id"));
		// vo.setPw((String)session.getAttribute("pw"));
		session.getAttribute("id");
		session.getAttribute("pw");
		// vo.setName((String)session.getAttribute("name"));
		// vo.setAge((Integer)session.getAttribute("age"));

		session.getAttribute("name");
		session.getAttribute("age");
		// vo.setGender((String)session.getAttribute("gender"));
		// vo.setTel((String)session.getAttribute("tel"));

		session.getAttribute("gender");
		session.getAttribute("tel");
		
		// vo.setHeight((Double)session.getAttribute("height"));
		// vo.setWeight((Integer)session.getAttribute("weight"));
		session.getAttribute("height");
		session.getAttribute("weight");

		return "up_info";
	}

	@RequestMapping(value = "/InsertBoardOK.do", method = RequestMethod.POST)
	public String InsertBoardOK(UserVO vo,Model model,HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("/InsertBoardOK.do Test");
	
		
		vo.setId((String)session.getAttribute("id"));
		int result = uService.insert(vo);
		model.addAttribute("vo", vo);

		if (result == 1)
			return "redirect:BoardList.do";
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('권한이 없습니다.'); history.go(-1);</script>");
			out.flush();
			return "";
		}
	}

	@RequestMapping(value = "/up_infoOK.do", method = RequestMethod.POST)
	public String up_infoOK(UserVO vo, HttpServletRequest request) {
		logger.info("up_infoOK()....");
		int result = uService.up_info(vo);

		if (result == 1)
			return "main";
		else
			return "redirect:up_info.do";

	}

	@RequestMapping(value = "selectSports.do", method = RequestMethod.GET)
	public String selectSports() {
		logger.info("selectSports()....");

		return "selectSports";
	}

	@RequestMapping(value = "/selectSportsOK.do", method = RequestMethod.POST)
	public String selectSportsOK() {
		logger.info("selectSportsOK()....");
		return "redirect:selectSports.do";

	}

	@RequestMapping(value = "updateRunning.do", method = RequestMethod.GET)
	public String updateRunning() {
		logger.info("updateRunning()....");

		return "updateRunning";
	}

	@RequestMapping(value = "/updateRunningOK.do", method = RequestMethod.POST)
	public String updateRunningOK(int minute, int meter, HttpSession session) {
		logger.info("updateRunningOK()....");
		System.out.println("minute: "+minute);
		System.out.println("meter: "+meter);
		System.out.println("(Integer)session.getAttribute(\"weight\"):" +(Integer)session.getAttribute("weight"));
		double run_speed = ((double)meter / 1000) / ((double)minute / 60);
		double run_kcal;
		double total_kcal;
		if (run_speed >= 5.5) {
			double met = 3.6;
			run_kcal = met * (3.5 * (Integer)session.getAttribute("weight") * minute);
		} else if (run_speed <= 5 && run_speed >= 4) {
			double met = 3.3;
			run_kcal = met * (3.5 * (Integer)session.getAttribute("weight") * minute);
		} else {
			double met = 2.9;
			run_kcal = met * (3.5 * (Integer)session.getAttribute("weight") * minute);
		}
		run_kcal = Double.parseDouble(String.format("%.2f", (run_kcal / 1000) * 5));
		session.setAttribute("minute", minute);
		session.setAttribute("meter", meter);
		session.setAttribute("run_kcal", run_kcal);
		
		
		System.out.println(session.getAttribute("bycicle_kcal")+"!!!!!!!!!!!!!!!!!!");
		System.out.println(session.getAttribute("rope_kcal")+"!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println((Double)session.getAttribute("bycicle_kcal")+(Double)session.getAttribute("rope_kcal"));
		System.out.println(11111);
		total_kcal = run_kcal + (Double)session.getAttribute("bycicle_kcal") + (Double)session.getAttribute("rope_kcal");
		total_kcal = Double.parseDouble(String.format("%.2f", (total_kcal / 1000) * 5));
		KcalVO kvo = new KcalVO();
		System.out.println("total_kcal: "+total_kcal);
		kvo.setTotalkcal(total_kcal);
		kvo.setId((String)session.getAttribute("id"));
		int result = uService.insertUserkcal(kvo);
		
		
		return "redirect:main.do?run_kcal=" + run_kcal;
	}

	@RequestMapping(value = "updateBycicle.do", method = RequestMethod.GET)
	public String updateBycicle() {
		logger.info("updateBycicle()....");

		return "updateBycicle";
	}

	@RequestMapping(value = "/updateBycicleOK.do", method = RequestMethod.POST)
	public String updateBycicleOK(int minute, int meter, HttpSession session) {
		logger.info("updateWalkingOK()....");
		double bycicle_speed = ((double)meter / 1000) / ((double)minute / 60);
		double met = 8;
		if (bycicle_speed >= 15) {
			met = 9;
		} else if (bycicle_speed < 15 && bycicle_speed >= 12) {
			met = 8;
		} else {
			met = 7;
		}
		double total_kcal = 0;
		double bycicle_kcal = 3.5 * (met * (Integer)session.getAttribute("weight") * minute);
		bycicle_kcal = Double.parseDouble(String.format("%.2f", (bycicle_kcal / 1000) * 5));
		session.setAttribute("minute", minute);
		session.setAttribute("meter", meter);
		session.setAttribute("bycicle_kcal", bycicle_kcal);
		
		
		total_kcal = bycicle_kcal + (Double)session.getAttribute("run_kcal")+(Double)session.getAttribute("rope_kcal");
		total_kcal = Double.parseDouble(String.format("%.2f", (total_kcal / 1000) * 5));

		KcalVO kvo = new KcalVO();
		System.out.println("total_kcal: "+total_kcal);
		kvo.setTotalkcal(total_kcal);
		kvo.setId((String)session.getAttribute("id"));
		int result = uService.insertUserkcal(kvo);
		
		return "redirect:main.do?bycicle_kcal=" + bycicle_kcal;

	}

	@RequestMapping(value = "updateRope.do", method = RequestMethod.GET)
	public String updateRope() {
		logger.info("updateRope()....");

		return "updateRope";
	}

	@RequestMapping(value = "/updateRopeOK.do", method = RequestMethod.POST)
	public String updateRopeOK(int minute, int count, HttpSession session) {
		logger.info("updateRopeOK()....");
		double rope_speed = count / minute;
		double met;
		if (rope_speed >= 120) {
			met = 12;
		} else if (rope_speed < 120 && rope_speed >= 100) {
			met = 10;
		} else {
			met = 8;
		}
		double rope_kcal = 3.5 * (met * (Integer)session.getAttribute("weight") * minute);
		double total_kcal;
		rope_kcal = Double.parseDouble(String.format("%.2f", (rope_kcal / 1000) * 5));
		session.setAttribute("minute", minute);
		session.setAttribute("count", count);
		session.setAttribute("rope_kcal", rope_kcal);
		
		
		total_kcal = rope_kcal + (Double)session.getAttribute("run_kcal")+(Double)session.getAttribute("bycicle_kcal");
		total_kcal = Double.parseDouble(String.format("%.2f", (total_kcal / 1000) * 5));

		KcalVO kvo = new KcalVO();
		System.out.println("total_kcal: "+total_kcal);
		kvo.setTotalkcal(total_kcal);
		kvo.setId((String)session.getAttribute("id"));
		int result = uService.insertUserkcal(kvo);

		return "redirect:main.do?rope_kcal=" + rope_kcal;

	}
	
	@RequestMapping(value ="/inquiryRecord.do", method = RequestMethod.GET)
	public String inquiryRecord(HttpSession session, KcalVO kvo, Model model) {
		logger.info("inquiryRecord()....");
//		int total_kcal = (Integer)session.getAttribute("total_kcal");
		logger.info((String) session.getAttribute("total_kcal"));
//		model.addAttribute("total_kcal", total_kcal);
//		System.out.println(kvo.getTotal_kcal());
		double total_kcal = kvo.getTotalkcal();
		Date day = new Date();	
		kvo.setDay(day.toString());

		model.addAttribute("total_kcal", total_kcal);
		model.addAttribute("day", day);
		
		return "inquiryRecord";
	}
	
	
	@RequestMapping(value = "/InsertBoard.do", method = RequestMethod.GET)
	public String InsertBoard(UserVO vo, Model model) {
		logger.info("/InsertBoard.do Test");

		return "InsertBoard";
	}

	
	@RequestMapping(value = "/UpdateBoard.do", method = RequestMethod.GET)
	public String UpdateBoard(UserVO vo, Model model) {
		logger.info("/UpdateBoard.do Test");

		// vo.setNum(1);

		UserVO bvo = uService.selectOne(vo);

		// jsp로 넘기는 부분
		model.addAttribute("bvo", bvo);

		return "UpdateBoard";
	}

	@RequestMapping(value = "/UpdateBoardOK.do", method = RequestMethod.GET)
	public String UpdateBoardOK(UserVO vo, Model model) {
		logger.info("/UpdateBoard.do Test");

		// vo.setNum(1);
		UserVO bvo = uService.selectOne(vo);

		// jsp로 넘기는 부분
		model.addAttribute("bvo", bvo);
//		int result = service.update(vo);
//		System.out.println(vo.getReply());
//
//		if (result == 1)
			return "UpdateBoardOK";
//		else
//			return "UpdateBoard?num=" + vo.getNum();
	}
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		logger.info("/logout.do Test");

			return "redirect:login.do";
	}
	
	@RequestMapping(value = "/BoardList.do", method = RequestMethod.GET)
	public String BoardList(Model model) {
		logger.info("/BoardList.do Test");
		
		List<UserVO> list = uService.selectBoardall();

		model.addAttribute("list", list);

		return "BoardList";
	}
	
	
	
	
	
	
	
	
	// @RequestMapping(value = "/updateTotalKcal.do", method = RequestMethod.POST)
	// public String updateTotalKcal(int walk_kcal) {
	// logger.info("updateTotalKcal()....");
	// int total_kcal= walk_kcal+1;
	// return "redirect:main.do?kcal="+total_kcal;
	//
	// }

	// @RequestMapping(value = "/select.do", method = RequestMethod.GET)
	// public String selectAll(HttpServletRequest request) {
	// logger.info("select()....");
	// List<BoardVO> list = bService.selectAll();
	// request.setAttribute("list", list);
	// return "select";
	// }
	//
	// @RequestMapping(value = "/jselectAll.do", method = RequestMethod.GET)
	// @ResponseBody
	// public Map<String, List<BoardVO>> jselectAll() {
	// logger.info("jselectAll()....");
	// List<BoardVO> list = bService.selectAll();
	// Map<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
	// map.put("list", list);
	// return map;
	// }
	//
	// @RequestMapping(value = "/jselectAll2.do", method = RequestMethod.GET)
	// @ResponseBody
	// public List<BoardVO> jselectAll2() {
	// logger.info("/jselectAll2.do");
	//
	// List<BoardVO> list = bService.selectAll();
	// Map<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
	//
	// map.put("list", list);
	// return list;
	// }
	//
	// @RequestMapping(value = "/jselectOne.do", method = RequestMethod.GET)
	// @ResponseBody
	// public BoardVO jselectOne(BoardVO vo) {
	// logger.info("/jselectOne.do");
	//
	// BoardVO bvo = bService.selectOne(vo);
	//
	// return bvo;
	// }
	//
	// @RequestMapping(value = "/update.do", method = RequestMethod.GET)
	// public String update(HttpServletRequest request) {
	// logger.info("update()....");
	// BoardVO vo = new BoardVO();
	// vo.setNum(Integer.parseInt(request.getParameter("num")));
	// BoardVO bvo = bService.selectOne(vo);
	// request.setAttribute("bvo", bvo);
	// return "update";
	// }
	//
	// @RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	// public String updateOK(BoardVO vo) {
	// logger.info("updateOK()....");
	// int result = bService.update(vo);
	// if(result==1) return "redirect:select.do";
	// else return "redirect:update.do";
	// }
	//
	// @RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)
	// public String deleteOK(HttpServletRequest request) {
	// logger.info("deleteOK()....");
	// BoardVO vo = new BoardVO();
	// vo.setNum(Integer.parseInt(request.getParameter("num")));
	// int result = bService.delete(vo);
	// if(result==1) return "redirect:select.do";
	// else return "redirect:select.do";
	// }

}
