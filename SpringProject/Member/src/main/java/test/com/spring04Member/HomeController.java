package test.com.spring04Member;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.spring04Member.model.MemberVO;
import test.com.spring04Member.service.MemberService;





/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//MemberService service = new MemberService();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	MemberService service;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/MemberInsert.do", method = RequestMethod.GET)
	public String insert(MemberVO vo) {

		return "MemberInsert";
	}

	@RequestMapping(value = "/MemberInsertOK.do", method = RequestMethod.POST)
	public String insertOK(MemberVO vo) {

		int result = service.insert(vo);

		if (result == 1) {
			return "redirect:MemberSelectAll.do";
		} else
			return "MemberInsert";
	}

	@RequestMapping(value = "/MemberSelectAll.do", method = RequestMethod.GET)
	public String selectAll(MemberVO vo, Model model) {

		model.addAttribute("list", service.selectAll());

		return "MemberSelectAll";
	}

	@RequestMapping(value = "/MemberUpdate.do", method = RequestMethod.GET)
	public String update(MemberVO vo, Model model) {

		MemberVO mvo = service.selectOne(vo);
		model.addAttribute("mvo", mvo);

		return "MemberUpdate";
	}

	@RequestMapping(value = "/MemberUpdateOK.do", method = RequestMethod.GET)
	public String updateOK(MemberVO vo) {

		int result = service.update(vo);

		if (result == 1) {
			return "redirect:MemberSelectAll.do";
		} else
			return "MemberUpdate";

	}

	@RequestMapping(value = "/MemberDeleteOK.do", method = RequestMethod.GET)
	public String deleteOK(MemberVO vo) {

		service.delete(vo);

		return "redirect:MemberSelectAll.do";

	}
	
	@RequestMapping(value = "/jSelectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<MemberVO>> jSelectAll() {

		List<MemberVO> list = service.selectAll();
		Map<String, List<MemberVO>> map = new HashMap<String, List<MemberVO>>();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value = "/jSelectAll2.do", method = RequestMethod.GET)
	@ResponseBody
	public List<MemberVO> jSelectAll2() {

		List<MemberVO> list = service.selectAll();
		return list;
	}
	
	@RequestMapping(value = "/jSelectOne.do", method = RequestMethod.GET)
	@ResponseBody
	public MemberVO jSelectOne(MemberVO vo) {

		MemberVO mvo = service.selectOne(vo);
		return mvo;
	}

}
