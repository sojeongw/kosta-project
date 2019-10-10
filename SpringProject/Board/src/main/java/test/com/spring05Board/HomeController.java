package test.com.spring05Board;

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

import test.com.spring05Board.model.BoardVO;
import test.com.spring05Board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//BoardService service = new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	BoardService service;
	
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

	@RequestMapping(value = "/BoardInsert.do", method = RequestMethod.GET)
	public String insert(BoardVO vo) {

		return "BoardInsert";
	}

	@RequestMapping(value = "/BoardInsertOK.do", method = RequestMethod.POST)
	public String insertOK(BoardVO vo) {
		service.insert(vo);

		return "redirect:BoardSelectAll.do";
	}

	@RequestMapping(value = "/BoardUpdate.do", method = RequestMethod.GET)
	public String update(BoardVO vo, Model model) {
		
		BoardVO bvo = service.selectOne(vo);
		model.addAttribute("bvo", bvo);

		return "BoardUpdate";
	}

	@RequestMapping(value = "/BoardUpdateOK.do", method = RequestMethod.GET)
	public String updateOK(BoardVO vo, Model model) {

		int result = service.update(vo);

		if (result == 1) {
			return "redirect:BoardSelectAll.do";
		} else
			return "BoardUpdate";
	}

	@RequestMapping(value = "/BoardSelectAll.do", method = RequestMethod.GET)
	public String select(BoardVO vo, Model model) {

		model.addAttribute("list", service.selectAll());

		return "BoardSelectAll";
	}

	@RequestMapping(value = "/BoardDeleteOK.do", method = RequestMethod.GET)
	public String deleteOK(BoardVO vo) {

		service.delete(vo);

		return "redirect:BoardSelectAll.do";

	}
	
	@RequestMapping(value = { "/jselectAll.do" }, method = RequestMethod.GET)
	// jsp로 연결되기 때문에 이 페이지가 jsp를 요청하는 게 아니라 그냥 응답 자체만 하는 페이지라는걸 표시해준다
	@ResponseBody
	public Map<String, List<BoardVO>> jselectAll() {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("jselectAll OK()..");

		List<BoardVO> list = service.selectAll();
		Map<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value = { "/jselectAll2.do" }, method = RequestMethod.GET)
	// jsp로 연결되기 때문에 이 페이지가 jsp를 요청하는 게 아니라 그냥 응답 자체만 하는 페이지라는걸 표시해준다
	@ResponseBody
	public List<BoardVO> jselectAll2() {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("jselectAll2 OK()..");

		List<BoardVO> list = service.selectAll();
		return list;
	}
	@RequestMapping(value = { "/jselectOne.do" }, method = RequestMethod.GET)
	// jsp로 연결되기 때문에 이 페이지가 jsp를 요청하는 게 아니라 그냥 응답 자체만 하는 페이지라는걸 표시해준다
	@ResponseBody
	public BoardVO jselectOne(BoardVO vo) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("jselectOne OK()..");

		BoardVO bvo = service.selectOne(vo);
		return bvo;
	}

}
