package test.semi.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import test.semi.admin.model.AdminVO;
import test.semi.admin.service.AdminService;

//import semi.diet.model.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {

	@Autowired
	AdminService service;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

//	@RequestMapping(value = "/BoardList.do", method = RequestMethod.GET)
//	public String BoardList(Model model, HttpSession session) {
//		logger.info("/BoardList.do Test");
//
//		List<AdminVO> list = service.selectAll();
//
//		model.addAttribute("list", list);
//		String se_id = (String) session.getAttribute("id");
//		model.addAttribute("se_id", se_id);
//
//		return "BoardList";
//	}
	
	@RequestMapping(value = "/BoardList.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String BoardList(Model model,String cpage, HttpSession session) {
		logger.info("/BoardList.do Test");
		int page = Integer.parseInt(cpage); // 현재 페이지 번호
		int countList = 5;//한 페이지에 출력될 게시물 수 
		int totalCount = service.rowCount();
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
		List<AdminVO> list = service.selectAll(startPage, endPage);
		model.addAttribute("list", list);
		String se_id = (String) session.getAttribute("id");
		model.addAttribute("se_id", se_id);
		
		for (int iCount = 1; iCount <= endPage; iCount++) {
			System.out.print(" "+ iCount + " ");
		}
		
		if (session.getAttribute("id") == null)
			return "home";
		else
			return "BoardList";

	}


	////////////// 테스트용 insert
	@RequestMapping(value = "/InsertBoard.do", method = RequestMethod.GET)
	public String InsertBoard(AdminVO vo, Model model) {
		logger.info("/InsertBoard.do Test");

		return "InsertBoard";
	}

	@RequestMapping(value = "/InsertBoardOK.do", method = RequestMethod.POST)
	public String InsertBoardOK(AdminVO vo,  Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response)
			throws IOException {
		logger.info("/InsertBoardOK.do Test");
		// System.out.println(vo.getWriter());
		vo.setId((String) session.getAttribute("id"));
		int result = service.insert(vo);
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
	


	/////////////////

	@RequestMapping(value = "/UpdateBoard.do", method = RequestMethod.GET)
	public String UpdateBoard(AdminVO vo, Model model, HttpServletRequest request, HttpSession session) {
		logger.info("/UpdateBoard.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));

		AdminVO avo = service.selectOne(vo);
		String se_id = (String) session.getAttribute("id");
		model.addAttribute("se_id", se_id);

		// jsp로 넘기는 부분
		model.addAttribute("avo", avo);

		return "UpdateBoard";
	}

	@RequestMapping(value = "/UpdateBoardOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String UpdateBoardOK(AdminVO vo, Model model, HttpServletRequest request, HttpSession session) {
		logger.info("/UpdateBoardOK.do Test");
		
		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		String se_id = (String) session.getAttribute("id");
		model.addAttribute("se_id", se_id);

		if (request.getParameter("reply") != null) {
			vo.setReply(request.getParameter("reply"));
			service.update(vo);
			AdminVO avo = service.selectOne(vo);

			model.addAttribute("vo", vo);
			model.addAttribute("avo", avo);
		} else {
			AdminVO avo = service.selectOne(vo);
			model.addAttribute("avo", avo);
		}
		return "UpdateBoardOK";
	}

	@RequestMapping(value = "/BoardContent.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String BoardContent(AdminVO vo, Model model, HttpServletRequest request, HttpSession session) {
		logger.info("/UpdateBoardOK.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));

		// if(request.getParameter("reply")!=null) {
		vo.setReply(request.getParameter("reply"));
		AdminVO avo = service.selectOne(vo);
		String se_id = (String) session.getAttribute("id");
		model.addAttribute("se_id", se_id);

		model.addAttribute("avo", avo);
		// } else {
		// AdminVO avo = service.selectOne(vo);
		// model.addAttribute("avo", avo);
		// }
		return "UpdateBoardOK";
	}

	@RequestMapping(value = "/DeleteBoard.do", method = RequestMethod.GET)
	public String DeleteBoard(AdminVO vo,Model model, HttpServletRequest request) {
		logger.info("/DeleteBoard.do Test");

		vo.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		service.delete(vo);

		return "redirect:BoardList.do?cpage=1";
	}

	//////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/AdminMember.do", method = RequestMethod.GET)
	public String AdminMember() {
		logger.info("/AdminMember.do Test");

		return "AdminMember";
	}

	@RequestMapping(value = "/MemberList.do", method = RequestMethod.GET)
	public String MemberList(Model model, String cpage, HttpSession session, HttpServletRequest request) {
		/*logger.info("/MemberList.do Test");

		List<AdminVO> list = service.selectAllmember();
		model.addAttribute("list", list);
		return "MemberList";*/
		logger.info("/MemberList.do Test");
		System.out.println("para:  "+cpage);
		int page = Integer.parseInt(cpage); // 현재 페이지 번호
		System.out.println("page: "+page);
		int countList = 5; //한 페이지에 출력될 게시물 수 
//		int countPage = 10; //한 화면에 출력될 페이지 수 
		int totalCount = service.rowCount();
		int totalPage = totalCount / countList;//총 페이지
		if (totalCount % countList > 0) {
			totalPage++;
		}
		int startPage = ((page-1)*5)+1;//1, 6, 11, 16, ...
		int endPage = startPage + countList -1;//5, 10, 15, 20, ...
		System.out.println("startPage: "+startPage);
		System.out.println("endPage: "+endPage);
		model.addAttribute("page", page);
		model.addAttribute("countList", countList);
//		model.addAttribute("countPage", countPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("totalCount", totalCount);
		List<AdminVO> list = service.selectAllmember(startPage, endPage);
		model.addAttribute("list", list);
		String se_id = (String) session.getAttribute("id");
		model.addAttribute("se_id", se_id);
		   String image = (String) session.getAttribute("profile_pic");
		   model.addAttribute("profile_pic", image);
		
		for (int iCount = 1; iCount <= endPage; iCount++) {
			System.out.print(" "+ iCount + " ");
		}
		if (session.getAttribute("id") != null) {
			if (session.getAttribute("id").equals(("admin"))||session.getAttribute("id").equals(("manager")))
				return "MemberList";
			else
				return "home";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/UpdateMember.do", method = RequestMethod.GET)
	public String UpdateMember(Model model, AdminVO vo,HttpSession session) {
		logger.info("/UpdateMember.do Test");

		AdminVO bvo = service.selectOnemember(vo);

		model.addAttribute("bvo", bvo);
		String se_id = (String) session.getAttribute("id");
		model.addAttribute("se_id", se_id);

		return "UpdateMember";
	}

	@RequestMapping(value = "/UpdateMemberOK.do", method = RequestMethod.POST)
	public String UpdateMemberOK(Model model, AdminVO vo) {
		logger.info("/UpdateBoardOK.do Test");

		
		System.out.println(vo.getPw());		
		System.out.println(vo.getTel());
		System.out.println(vo.getAge());
		
		int result = service.updateMember(vo);
		if (result == 1)
			return "redirect:MemberList.do?cpage=1";
		else
			return "redirect:UpdateMember.do?id=" + vo.getId();
	}

	@RequestMapping(value = "/DeleteMemberOK.do", method = RequestMethod.GET)
	public String DeleteMemberOK(AdminVO vo, Model model) {
		logger.info("id :" + vo.getId());

		int result = service.deleteMember(vo);
		if (result == 1) {
			System.out.println("delete successed");
			return "redirect:MemberList.do?cpage=1";
		} else {
			System.out.println("delete failed");
			return "redirect:MemberList.do";
		}
	}

	@RequestMapping(value = "/UpdateGrade.do", method = RequestMethod.GET)
	public String UpdateGrade(AdminVO vo, Model model, HttpSession session) {
		logger.info("/UpdateGrade.do Test");

		AdminVO mvo = service.selectOnemember(vo);

		model.addAttribute("mvo", mvo);
		String se_id = (String) session.getAttribute("id");
		model.addAttribute("se_id", se_id);

		return "UpdateGrade";
	}

	@RequestMapping(value = "/UpdateGradeOK.do", method = RequestMethod.POST)
	public String UpdateGradeOK(AdminVO vo) {
		logger.info("/UpdateRanking.do Test");
		int result = service.updateGrade(vo);
		if (result == 1)
			return "redirect:GradeList.do";
		else
			return "redirect:UpdateGrade.do?id=" + vo.getId();
	}

	@RequestMapping(value = "/GradeList.do", method = RequestMethod.GET)
	public String GradeList(Model model, HttpSession session) {
		logger.info("/GradeList.do Test");

		List<AdminVO> list = service.selectAllgrade();
		model.addAttribute("list", list);
		String se_id = (String) session.getAttribute("id");
		String image = (String) session.getAttribute("profile_pic");
		model.addAttribute("se_id", se_id);
		model.addAttribute("profile_pic", image);
		
		if (session.getAttribute("id") == null)
	          return "home";
	       else
	    	   return "GradeList";
	}
	
	@RequestMapping(value = "/jselectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public List<AdminVO> jselectAll() {
		int startPage =0;//1, 6, 11, 16, ...
		int endPage = 0;//5, 10, 15, 20, ...
		List<AdminVO> list = service.selectAll(startPage, endPage);
		return list;
	}
	
	@RequestMapping(value = "/jselectOne.do", method = RequestMethod.GET)
	@ResponseBody
	public AdminVO jselectOne(AdminVO vo) {
		
		AdminVO mvo = service.selectOne(vo);
		return mvo;
	}
}
