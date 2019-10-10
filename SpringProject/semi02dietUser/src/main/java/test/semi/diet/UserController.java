package test.semi.diet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	// /*
	// * Simply selects the home view to render by returning its name.
	// */

	@RequestMapping(value = "insertMember.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String insertMember() {
		logger.info("insertMember()....");

		return "insertMember";
	}

	
	@RequestMapping(value = "/insertMemberOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String insertMemberOK(@ModelAttribute("mvo")UserVO vo,HttpServletRequest request,HttpSession session) throws IOException {
		logger.info("insertMemberOK()....");
				
		String profile_pic ="";
		
		MultipartFile multipartFile = vo.getMultipartFile();
			
		
		if(null != multipartFile) {
			profile_pic = multipartFile.getOriginalFilename();
			vo.setProfile_pic(profile_pic);
			
			@SuppressWarnings("deprecation")
			String realPath = request.getRealPath("resources/uploadimg");
			
			File origin_img = new File(realPath + "/" +profile_pic);
	         multipartFile.transferTo(origin_img);

	         BufferedImage original_buffer_img = ImageIO.read(origin_img);
	         BufferedImage thumb_buffer_img = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
	         Graphics2D graphic = thumb_buffer_img.createGraphics();
	         graphic.drawImage(original_buffer_img, 0, 0, 100, 100, null);

	         File thumb_file = new File(realPath + "/thumb_" + profile_pic);
	         ImageIO.write(thumb_buffer_img, "jpg", thumb_file);			
		}


		
		int result = uService.insertMember(vo);
		
		if (result == 1)
			return "redirect:home.do";
		else
			return "redirect:insertMember.do";
	}

	@RequestMapping(value = "login.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String login() {
		logger.info("login()....");

		return "login";
	}

	@RequestMapping(value = "/loginOK.do", method = { RequestMethod.POST, RequestMethod.GET })
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
		session.setAttribute("profile_pic", vo.getProfile_pic());
		

		if (result == 1) {
			session.setAttribute("bicycle_kcal", 0.0);
			session.setAttribute("rope_kcal", 0.0);
			session.setAttribute("run_kcal", 0.0);
			
			return "main";
		} else
			return "home";
	}

	@RequestMapping(value = "main.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String main(HttpSession session) {
		logger.info("main()....");

		
	      if (session.getAttribute("id") == null)
	          return "home";
	       else
	          return "main";
	}

	@RequestMapping(value = "/BoardContent.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String BoardContent(UserVO vo, Model model, HttpServletRequest request, HttpSession session) {
		logger.info("/BoardContent.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		System.out.println(vo.getBoard_num());
		UserVO uvo = uService.selectOneBoard_member(vo);
		model.addAttribute("uvo", uvo);

		// 세션에서 받은 id와 글의 id가 같다면 수정 가능
		String id = (String) session.getAttribute("id");
		System.out.println("아이디" + uvo.getId());

		if (uvo.getId().equals(id)) {
			// 수정, 삭제 버튼이 있는 글읽기 페이지
			return "BoardContent_Member";
		} else {
			// 수정, 삭제 버튼이 없는 글읽기 페이지
			return "UpdateBoardOK";
		}
	}

	@RequestMapping(value = "/UpdateBoard_Member.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String UpdateBoard_Member(UserVO vo, Model model, HttpServletRequest request) {
		logger.info("/UpdateBoard_Member.do Test");
		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		UserVO uvo = uService.selectOneBoard_member(vo);
		// jsp로 넘기는 부분
		model.addAttribute("uvo", uvo);
		return "UpdateBoard_Member";

	}

	@RequestMapping(value = "/UpdateBoard_MemberOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String UpdateBoard_MemberOK(UserVO vo, Model model, HttpServletRequest request) {
		logger.info("/UpdateBoard_MemberOK.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		 uService.update(vo);
		System.out.println(vo.getBoard_num()); 
		System.out.println(vo.getContent());

		UserVO uvo = uService.selectOneBoard_member(vo);
		model.addAttribute("uvo", uvo);

		return "BoardContent_Member";
	}

	@RequestMapping(value = "/DeleteBoard_Member.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String DeleteBoard_Member(UserVO vo, Model model, HttpServletRequest request) {
		logger.info("/DeleteBoard_Member.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		uService.deleteBoard_member(vo);

		return "redirect:BoardList.do?cpage=1";

	}

	@RequestMapping(value = "/UpdateBoard.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String UpdateBoard(UserVO vo, Model model, HttpServletRequest request) {
		logger.info("/UpdateBoard.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));

		UserVO avo = uService.selectOneBoard_member(vo);

		// jsp로 넘기는 부분
		model.addAttribute("avo", avo);

		return "UpdateBoard";
	}

	@RequestMapping(value = "/UpdateBoardOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String UpdateBoardOK(UserVO vo, Model model, HttpServletRequest request) {
		logger.info("/UpdateBoardOK.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		System.out.println(vo.getBoard_num());

		if (request.getParameter("reply") != null) {
			vo.setContent(request.getParameter("reply"));
			// uService.update(vo);
			UserVO avo = uService.selectOneBoard_member(vo);

			model.addAttribute("vo", vo);
			model.addAttribute("avo", avo);
			logger.info("/UpdateBoardOK.do reply 성공");
		} else {
			UserVO avo = uService.selectOneBoard_member(vo);
			model.addAttribute("avo", avo);
			logger.info("/UpdateBoardOK.do 성공");
		}
		return "UpdateBoardOK";
	}

	@RequestMapping(value = "/selectAll.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String selectAll(HttpSession session, Model model, HttpServletRequest request) {
		System.out.println("selectAll()....userkcal테이블 가져와서 출력하기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		KcalVO kvo = new KcalVO();

		kvo.setId((String) session.getAttribute("id"));
		List<KcalVO> list = uService.selectAllUserkcal(kvo);
		
		for (int i = 0; i < list.size(); i++) {

			System.out.print(list.get(i).getId() + "!!");
			System.out.print(list.get(i).getSports_date() + "!!");
			System.out.println(list.get(i).getTotalkcal());

	         if(list.get(i).getRunning() != 0) list.get(i).setKcal(list.get(i).getRunning());
	         else if(list.get(i).getRope() != 0) list.get(i).setKcal(list.get(i).getRope());
	         else if(list.get(i).getBicycle() != 0)    list.get(i).setKcal(list.get(i).getBicycle());
				
		}

		model.addAttribute(list);
		request.setAttribute("list", list);

		return "selectAll";
	}

	@RequestMapping(value = "/backToMainOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String backToMainOK() {
		logger.info("backToMainOK()....");
		return "redirect:main.do";

	}

	@RequestMapping(value = "up_goal.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String up_goal(UserVO vo, HttpSession session) {
		logger.info("up_goal()....");
		System.out.println("session.getAttribute(\"id\")" + session.getAttribute("id"));
		System.out.println("session.getAttribute(\"pw\")" + session.getAttribute("pw"));
		System.out.println("session.getAttribute(\"name\")" + session.getAttribute("name"));
		System.out.println("session.getAttribute(\"age\")" + session.getAttribute("age"));
		System.out.println("session.getAttribute(\"goal\")" + session.getAttribute("goal"));

		return "up_goal";
	}

	@RequestMapping(value = "/up_goalOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String up_goalOK(UserVO vo, HttpSession session) {
		logger.info("up_goalOK()....");
		System.out.println("session.getAttribute(\"goal\")" + session.getAttribute("goal"));
		System.out.println(session.getAttribute("id"));
		
		vo.setId(session.getAttribute("id").toString());
		session.setAttribute("goal", vo.getGoal());
		
		System.out.println(vo.getGoal());
		int result = uService.up_goal(vo);

		if (result == 1)
			return "main";
		else
			return "redirect:login.do";
	}

	@RequestMapping(value = "up_info.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String up_info(UserVO vo, HttpSession session) {
		logger.info("up_info()....");

		session.getAttribute("id");
		session.getAttribute("pw");
		session.getAttribute("name");
		session.getAttribute("age");
		session.getAttribute("gender");
		session.getAttribute("tel");
		session.getAttribute("height");
		session.getAttribute("weight");
		session.getAttribute("profile_pic");
		return "up_info";
	}

	@RequestMapping(value = "/InsertBoardOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String InsertBoardOK(UserVO vo, Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("/InsertBoardOK.do Test");

		vo.setId((String) session.getAttribute("id"));
		int result = uService.insertBoard_member(vo);
		model.addAttribute("vo", vo);

		if (result == 1)
			return "redirect:BoardList.do?cpage=1";
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('권한이 없습니다.'); history.go(-1);</script>");
			out.flush();
			return "";
		}
	}

	@RequestMapping(value = "/up_infoOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String up_infoOK(UserVO vo, HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		logger.info("up_infoOK()....");
		
		String profile_pic ="";
		
		MultipartFile multipartFile = vo.getMultipartFile();
			
		
		if(null != multipartFile) {
			profile_pic = multipartFile.getOriginalFilename();
			vo.setProfile_pic(profile_pic);
			
			@SuppressWarnings("deprecation")
			String realPath = request.getRealPath("resources/uploadimg");
			
			File origin_img = new File(realPath + "/" +profile_pic);
	         multipartFile.transferTo(origin_img);

	         BufferedImage original_buffer_img = ImageIO.read(origin_img);
	         BufferedImage thumb_buffer_img = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
	         Graphics2D graphic = thumb_buffer_img.createGraphics();
	         graphic.drawImage(original_buffer_img, 0, 0, 100, 100, null);

	         File thumb_file = new File(realPath + "/thumb_" + profile_pic);
	         ImageIO.write(thumb_buffer_img, "jpg", thumb_file);			
		}
		

		session.setAttribute("pw", vo.getPw());
		session.setAttribute("name", vo.getName());
		session.setAttribute("age", vo.getAge());
		session.setAttribute("gender", vo.getGender());
		session.setAttribute("tel", vo.getTel());
		session.setAttribute("height", vo.getHeight());
		session.setAttribute("weight", vo.getWeight());
		session.setAttribute("profile_pic", vo.getProfile_pic());
		
		int result = uService.up_info(vo);
		
		if (result == 1) {
			
			return "main";}
		else
			return "redirect:up_info.do";

	}

	@RequestMapping(value = "selectSports.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String selectSports(UserVO vo, Model model, HttpSession session) {
		logger.info("selectSports()....");
		
		vo.setId((String) session.getAttribute("id"));
		vo.setName((String) session.getAttribute("name"));		
		model.addAttribute("vo", vo);

	      if (session.getAttribute("id") == null)
	          return "home";
	       else
	       return "selectSports";
	}

	@RequestMapping(value = "/selectSportsOK.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String selectSportsOK(UserVO vo, Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("selectSportsOK()....");
		
		vo.setId((String) session.getAttribute("id"));
		vo.setName((String) session.getAttribute("name"));
		model.addAttribute("vo", vo);
		
		return "redirect:selectSports.do";

	}

	@RequestMapping(value = "updateRunning.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateRunning() {
		logger.info("updateRunning()....");

		return "updateRunning";
	}


	@RequestMapping(value = "/updateRunningOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateRunningOK(int minute, int meter, HttpSession session) {
		logger.info("updateRunningOK()....");
		double run_speed = ((double) meter / 1000) / ((double) minute / 60);
		double run_kcal;
		double totalkcal;

		if (run_speed >= 5.5) {
			double met = 3.6;
			run_kcal = met * (3.5 * (Integer) session.getAttribute("weight") * minute);
		} else if (run_speed <= 5 && run_speed >= 4) {
			double met = 3.3;
			run_kcal = met * (3.5 * (Integer) session.getAttribute("weight") * minute);
		} else {
			double met = 2.9;
			run_kcal = met * (3.5 * (Integer) session.getAttribute("weight") * minute);
		}

		run_kcal = Double.parseDouble(String.format("%.2f", (run_kcal / 1000) * 5));
		session.setAttribute("minute", minute);
		session.setAttribute("meter", meter);
		session.setAttribute("run_kcal", run_kcal);

		totalkcal = run_kcal + (Double) session.getAttribute("bicycle_kcal")
				+ (Double) session.getAttribute("rope_kcal");
		// totalkcal = Double.parseDouble(String.format("%.2f", (totalkcal / 1000) *
		// 5));

		KcalVO kvo = new KcalVO();
		System.out.println("totalkcal: " + totalkcal);
		kvo.setTotalkcal(totalkcal);
		kvo.setRunning(run_kcal);
		kvo.setId((String) session.getAttribute("id"));
		int result = uService.insertUserkcal(kvo);

		return "redirect:main.do?run_kcal=" + run_kcal;
	}



	@RequestMapping(value = "updateBicycle.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateBicycle() {
		logger.info("updateBicycle()....");

		return "updateBicycle";
	}

	@RequestMapping(value = "/updateBicycleOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateBicycleOK(int minute, int meter, HttpSession session) {
		logger.info("updateWalkingOK()....");
		double totalkcal = 0;
		double bicycle_speed = ((double) meter / 1000) / ((double) minute / 60);
		double met = 8;
		if (bicycle_speed >= 15) {
			met = 9;
		} else if (bicycle_speed < 15 && bicycle_speed >= 12) {
			met = 8;
		} else {
			met = 7;
		}

		double bicycle_kcal = 3.5 * (met * (Integer) session.getAttribute("weight") * minute);
		bicycle_kcal = Double.parseDouble(String.format("%.2f", (bicycle_kcal / 1000) * 5));
		session.setAttribute("minute", minute);
		session.setAttribute("meter", meter);
		session.setAttribute("bicycle_kcal", bicycle_kcal);

		totalkcal = bicycle_kcal + (Double) session.getAttribute("run_kcal")
				+ (Double) session.getAttribute("rope_kcal");
		// totalkcal = Double.parseDouble(String.format("%.2f", (totalkcal / 1000) *
		// 5));

		KcalVO kvo = new KcalVO();
		System.out.println("totalkcal: " + totalkcal);
		kvo.setTotalkcal(totalkcal);
		kvo.setId((String) session.getAttribute("id"));
		kvo.setBicycle(bicycle_kcal);
		int result = uService.insertUserkcal(kvo);

		return "redirect:main.do?bicycle_kcal=" + bicycle_kcal;

	}

	@RequestMapping(value = "updateRope.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateRope() {
		logger.info("updateRope()....");

		return "updateRope";
	}

	@RequestMapping(value = "/updateRopeOK.do", method = { RequestMethod.POST, RequestMethod.GET })
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

		double rope_kcal = 3.5 * (met * (Integer) session.getAttribute("weight") * minute);
		double totalkcal;
		rope_kcal = Double.parseDouble(String.format("%.2f", (rope_kcal / 1000) * 5));
		session.setAttribute("minute", minute);
		session.setAttribute("count", count);
		session.setAttribute("rope_kcal", rope_kcal);

		totalkcal = rope_kcal + (Double) session.getAttribute("run_kcal")
				+ (Double) session.getAttribute("bicycle_kcal");
		// totalkcal = Double.parseDouble(String.format("%.2f", (totalkcal / 1000) *
		// 5));

		KcalVO kvo = new KcalVO();
		System.out.println("totalkcal: " + totalkcal);
		kvo.setTotalkcal(totalkcal);
		kvo.setId((String) session.getAttribute("id"));
		kvo.setRope(rope_kcal);
		int result = uService.insertUserkcal(kvo);

		return "redirect:main.do?rope_kcal=" + rope_kcal;

	}

	@RequestMapping(value = "/inquiryRecord.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String inquiryRecord(HttpSession session, KcalVO kvo, Model model) {
		logger.info("inquiryRecord()....");
		// int total_kcal = (Integer)session.getAttribute("total_kcal");
		logger.info((String) session.getAttribute("total_kcal"));
		// model.addAttribute("total_kcal", total_kcal);
		// System.out.println(kvo.getTotal_kcal());
		double total_kcal = kvo.getTotalkcal();
		Date day = new Date();
		kvo.setDay(day.toString());

		model.addAttribute("total_kcal", total_kcal);
		model.addAttribute("day", day);

	      if (session.getAttribute("id") == null)
	          return "home";
	       else
	       return "inquiryRecord";
	}
	@RequestMapping(value = "/InsertBoard.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String InsertBoard(UserVO vo, Model model, HttpSession session) {
		logger.info("/InsertBoard.do Test");

		vo.setId((String) session.getAttribute("id"));
		model.addAttribute("vo", vo);

		return "InsertBoard";
	}

	@RequestMapping(value = "/logout.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String logout(HttpSession session) {
		logger.info("/logout.do Test");

		session.invalidate();

		return "home";
	}

	@RequestMapping(value = "/BoardList.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String BoardList(Model model,String cpage, HttpSession session) {
		logger.info("/BoardList.do Test");
		int page = Integer.parseInt(cpage); // 현재 페이지 번호
		int countList = 5;//한 페이지에 출력될 게시물 수 
		int totalCount = uService.rowCount();; 
		int totalPage = totalCount / countList;//총 페이지
		if (totalCount % countList > 0) {
			totalPage++;
		}
		int startPage = ((page-1)*5)+1;//1, 6, 11, 16, ...
		int endPage = startPage + countList -1;//5, 10, 15, 20, ...
		
		model.addAttribute("page", page);
		model.addAttribute("countList", countList);
//		model.addAttribute("countPage", countPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("totalCount", totalCount);
		
		List<UserVO> list = uService.selectAllBoard_member(startPage, endPage);
		model.addAttribute("list", list);
		
		for (int iCount = 1; iCount <= endPage; iCount++) {
			System.out.print(" "+ iCount + " ");
		}
		
		if (session.getAttribute("id") == null)
			return "home";
		else
			return "BoardList";

	}

	@RequestMapping(value = "/jselectAll.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<UserVO> jselectAll() {
		logger.info("/jselectAll.do");
		List<UserVO> list = uService.selectAll();
		return list;
	}

	@RequestMapping(value = "/jselectOne.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public UserVO jselectOne(UserVO vo) {
		logger.info("/jselectOne.do");
		UserVO mvo = uService.selectOne(vo);
		return mvo;
	}
	
	@RequestMapping(value = "/check_id.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public boolean check_id(UserVO vo, HttpServletRequest request) {
		logger.info("check id");
		String id = request.getParameter("id");
		logger.info(id);
		List<UserVO> list = uService.selectId(vo);
		boolean check = false;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				check = true;
			}
		}
		return check;
		
		
	}

	

}
