package test.com.spring03Student;

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

import test.com.spring03Student.model.StudentVO;
import test.com.spring03Student.service.StudentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	StudentService service;
	
	//StudentService service = new StudentService();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("home", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/StudentInsert.do", method = RequestMethod.GET)
	public String insert(StudentVO vo) {
		logger.info("insert");
		
		
		return "StudentInsert";
	}
	
	@RequestMapping(value = "/StudentInsertOK.do", method = RequestMethod.POST)
	public String insertOK(StudentVO vo) {
		logger.info("insertOK");
		vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
		vo.setAvg((double) vo.getTotal() / 3);

		String grade = "";
		if (vo.getAvg() >= 90) {
			grade = "A";
		} else if (vo.getAvg() >= 80) {
			grade = "B";
		} else if (vo.getAvg() >= 70) {
			grade = "C";
		} else {
			grade = "D";
		}
		vo.setGrade(grade);
		
		int result = service.insert(vo);
		
		if(result == 1) {
			return "redirect:StudentSelectAll.do";
		} else return "StudentInsert";	
		
	} @RequestMapping(value = "/StudentSelectAll.do", method = RequestMethod.GET)
	public String select(Model model) {
		logger.info("insert");
		
		model.addAttribute("list", service.selectAll());
		
		return "StudentSelectAll";
	}
	
	@RequestMapping(value = "/StudentDeleteOK.do", method = RequestMethod.GET)
	public String deleteOK(StudentVO vo) {
		logger.info("deleteOK");
		
		
		service.delete(vo);
		
		return "redirect:StudentSelectAll.do";
	}
	
	@RequestMapping(value = "/StudentUpdate.do", method = RequestMethod.GET)
	public String update(StudentVO vo, Model model) {
		logger.info("update");
		
		StudentVO svo = service.selectOne(vo);
		model.addAttribute("svo", svo);
		
		return "StudentUpdate";
	}
	
	@RequestMapping(value = "/StudentUpdateOK.do", method = RequestMethod.GET)
	public String updateOK(StudentVO vo, Model model) {
		logger.info("update");
		vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
		vo.setAvg((double) vo.getTotal() / 3);

		String grade = "";
		if (vo.getAvg() >= 90) {
			grade = "A";
		} else if (vo.getAvg() >= 80) {
			grade = "B";
		} else if (vo.getAvg() >= 70) {
			grade = "C";
		} else {
			grade = "D";
		}
		vo.setGrade(grade);
		
		int result = service.update(vo);
		
		if(result == 1) {
			return "redirect:StudentSelectAll.do";
		} else return "StudentUpdate";	
	}
	
	
	@RequestMapping(value = "/jSelectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<StudentVO>> jSelectAll() {

		List<StudentVO> list = service.selectAll();
		Map<String, List<StudentVO>> map = new HashMap<String, List<StudentVO>>();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value = "/jSelectAll2.do", method = RequestMethod.GET)
	@ResponseBody
	public List<StudentVO> jSelectAll2() {

		List<StudentVO> list = service.selectAll();
		return list;
	}
	
	@RequestMapping(value = "/jSelectOne.do", method = RequestMethod.GET)
	@ResponseBody
	public StudentVO jSelectOne(StudentVO vo) {

		StudentVO svo = service.selectOne(vo);
		return svo;
	}
	
	
}
