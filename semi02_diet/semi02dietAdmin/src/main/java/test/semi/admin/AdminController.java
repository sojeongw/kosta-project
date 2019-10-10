package test.semi.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/BoardList.do", method = RequestMethod.GET)
	public String BoardList(Model model) {
		logger.info("/BoardList.do Test");

		List<AdminVO> list = service.selectAll();

		model.addAttribute("list", list);

		return "BoardList";
	}

	////////////// 테스트용 insert
	@RequestMapping(value = "/InsertBoard.do", method = RequestMethod.GET)
	public String InsertBoard(AdminVO vo, Model model) {
		logger.info("/InsertBoard.do Test");

		return "InsertBoard";
	}

	@RequestMapping(value = "/InsertBoardOK.do", method = RequestMethod.POST)
	public String InsertBoardOK(AdminVO vo, Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("/InsertBoardOK.do Test");
		// System.out.println(vo.getWriter());
		int result = service.insert(vo);
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

	/////////////////

	@RequestMapping(value = "/UpdateBoard.do", method = RequestMethod.GET)
	public String UpdateBoard(AdminVO vo, Model model, HttpServletRequest request) {
		logger.info("/UpdateBoard.do Test");

		vo.setNum(Integer.parseInt(request.getParameter("num")));

		AdminVO avo = service.selectOne(vo);

		// jsp로 넘기는 부분
		model.addAttribute("avo", avo);

		return "UpdateBoard";
	}

	@RequestMapping(value = "/UpdateBoardOK.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String UpdateBoardOK(AdminVO vo, Model model, HttpServletRequest request) {
		logger.info("/UpdateBoardOK.do Test");
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));

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
	public String BoardContent(AdminVO vo, Model model, HttpServletRequest request) {
		logger.info("/UpdateBoardOK.do Test");

		vo.setNum(Integer.parseInt(request.getParameter("num")));

		// if(request.getParameter("reply")!=null) {
		vo.setReply(request.getParameter("reply"));
		AdminVO avo = service.selectOne(vo);

		model.addAttribute("avo", avo);
		// } else {
		// AdminVO avo = service.selectOne(vo);
		// model.addAttribute("avo", avo);
		// }
		return "UpdateBoardOK";
	}

	@RequestMapping(value = "/DeleteBoard.do", method = RequestMethod.GET)
	public String DeleteBoard(AdminVO vo) {
		logger.info("/DeleteBoard.do Test");

		// vo.setNum(1);
		service.delete(vo);

		return "redirect:BoardList.do";
	}

	//////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/AdminMember.do", method = RequestMethod.GET)
	public String AdminMember() {
		logger.info("/AdminMember.do Test");

		return "AdminMember";
	}

	@RequestMapping(value = "/MemberList.do", method = RequestMethod.GET)
	public String MemberList(Model model) {
		logger.info("/MemberList.do Test");

		List<AdminVO> list = service.selectAllmember();
		model.addAttribute("list", list);
		return "MemberList";
	}

	@RequestMapping(value = "/UpdateMember.do", method = RequestMethod.GET)
	public String UpdateMember(Model model, AdminVO vo) {
		logger.info("/UpdateMember.do Test");

		AdminVO bvo = service.selectOnemember(vo);

		model.addAttribute("bvo", bvo);

		return "UpdateMember";
	}

	@RequestMapping(value = "/UpdateMemberOK.do", method = RequestMethod.POST)
	public String UpdateMemberOK(Model model, AdminVO vo) {
		logger.info("/UpdateBoardOK.do Test");

		int result = service.updateMember(vo);
		if (result == 1)
			return "redirect:MemberList.do";
		else
			return "redirect:UpdateMember.do?id=" + vo.getId();
	}

	@RequestMapping(value = "/DeleteMemberOK.do", method = RequestMethod.GET)
	public String DeleteMemberOK(AdminVO vo, Model model) {
		logger.info("id :" + vo.getId());

		int result = service.deleteMember(vo);
		if (result == 1) {
			System.out.println("delete successed");
			return "redirect:MemberList.do";
		} else {
			System.out.println("delete failed");
			return "redirect:MemberList.do";
		}
	}

	@RequestMapping(value = "/UpdateGrade.do", method = RequestMethod.GET)
	public String UpdateGrade(AdminVO vo, Model model) {
		logger.info("/UpdateGrade.do Test");

		AdminVO mvo = service.selectOnemember(vo);

		model.addAttribute("mvo", mvo);

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
	public String GradeList(Model model) {
		logger.info("/GradeList.do Test");

		List<AdminVO> list = service.selectAllgrade();
		model.addAttribute("list", list);
		return "GradeList";
	}
}
