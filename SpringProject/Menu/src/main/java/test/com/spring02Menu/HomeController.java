package test.com.spring02Menu;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.spring02Menu.model.MenuVO;
import test.com.spring02Menu.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	MenuService service = new MenuService();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("home 시작!");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert(MenuVO vo) {
		logger.info("insert...");

		return "insert";
	}

	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(MenuVO vo) {
		logger.info("insertOK...");
		System.out.println("num : " + vo.getNum());
		System.out.println("menu : " + vo.getMenu());
		System.out.println("price : " + vo.getPrice());
		System.out.println("store : " + vo.getStore());
		System.out.println("kcal : " + vo.getKcal());

		int result = service.insert(vo);

		if (result == 1) {
			System.out.println("insert 성공");
			return "redirect:selectAll.do";
		} else {
			System.out.println("insert 실패");
			return "insert";
		}
	}

	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(MenuVO vo, Model model) {
		logger.info("selectAll...");

		List<MenuVO> list = service.selectAll();
		model.addAttribute("list", list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getNum());
			System.out.println(list.get(i).getMenu());
			System.out.println(list.get(i).getPrice());
			System.out.println(list.get(i).getStore());
			System.out.println(list.get(i).getKcal());
		}
		return "selectAll";
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(MenuVO vo, Model model) {
		logger.info("update...");
		MenuVO mvo = service.selectOne(vo);
		model.addAttribute("mvo", mvo);
		return "update";
	}

	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	public String updateOK(MenuVO vo) {
		logger.info("updateOK...");

		int result = service.update(vo);

		if (result == 1) {
			System.out.println("update 성공");
			return "redirect:selectAll.do";
		} else {
			System.out.println("update 실패");
			return "update";
		}
	}
	
	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)
	public String deleteOK(MenuVO vo) {
		logger.info("updateOK...");

		int result = service.delete(vo);

		if (result == 1) {
			System.out.println("delete 성공");
			return "redirect:selectAll.do";
		} else {
			System.out.println("delete 실패");
			return "delete";
		}
	}
}
