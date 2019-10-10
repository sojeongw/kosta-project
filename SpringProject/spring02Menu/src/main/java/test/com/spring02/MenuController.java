package test.com.spring02;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import test.com.spring02.model.MenuVO;
import test.com.spring02.TestVO;
import test.com.spring02.MenuController;
import test.com.spring02.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	MenuService service;

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	// value에 담긴건 서블릿 패스
	@RequestMapping(value = { "/Menu.do" }, method = RequestMethod.GET)
	public String Menu(HttpServletRequest request, HttpServletResponse response) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest

		request.setAttribute("name", "KIM");
		return "Menu";
	}

	@RequestMapping(value = { "/insert.do" }, method = RequestMethod.GET)
	public String insert() {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("insert()..");

		return "menu/insert";
	}

	@RequestMapping(value = { "/insertOK.do" }, method = RequestMethod.POST)
	public String insertOK(MenuVO vo) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("insertOK()..");
		// logger.info("id : " + request.getParameter("id"));
		/*
		 * logger.info("num : " + vo.getNum()); logger.info("menu : " + vo.getMenu());
		 * logger.info("price : " + vo.getPrice()); logger.info("store : " +
		 * vo.getStore()); logger.info("kcal : " + vo.getKcal());
		 */
		// 이제 impl로 보낸다

		int result = service.insert(vo);

		if (result == 1) {
			return "redirect:selectAll.do";
		} else
			return "redirect:insert.do?num=" + vo.getNum();
	}

	////// ModelAndView >> model을 따로 사용하지 않아도 된다.
	@RequestMapping(value = { "/selectAll.do" }, method = RequestMethod.GET)
	public String selectAll(Model model) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("selectAll()..");

		List<MenuVO> list = service.selectAll();
		model.addAttribute("list", list);

		return "menu/selectAll";
	}

	@RequestMapping(value = { "/selectOne.do" }, method = RequestMethod.GET)
	public String selectOne(MenuVO vo) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		service.selectOne(vo);

		logger.info("selectOne()..");
		logger.info("num : " + vo.getNum());
		logger.info("menu : " + vo.getMenu());
		logger.info("price : " + vo.getPrice());
		logger.info("store : " + vo.getStore());
		logger.info("kcal : " + vo.getKcal());

		return "menu/selectOne";
	}

	@RequestMapping(value = { "/update.do" }, method = RequestMethod.GET)
	public String update(MenuVO vo, Model model) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest

		logger.info("num : " + vo.getNum());
		logger.info("menu : " + vo.getMenu());
		logger.info("price : " + vo.getPrice());
		logger.info("store : " + vo.getStore());
		logger.info("kcal : " + vo.getKcal());

		MenuVO mvo = service.selectOne(vo);
		model.addAttribute("mvo", mvo);

		return "menu/update";
	}

	@RequestMapping(value = { "/updateOK.do" }, method = RequestMethod.POST)
	public String updateOK(MenuVO vo) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		int result = service.update(vo);
		logger.info("num : " + vo.getNum());
		logger.info("menu : " + vo.getMenu());
		logger.info("price : " + vo.getPrice());
		logger.info("store : " + vo.getStore());
		logger.info("kcal : " + vo.getKcal());

		if (result == 1) {
			return "redirect:selectAll.do";
		} else
			return "redirect:update.do?num=" + vo.getNum();
	}

	@RequestMapping(value = { "/deleteOK.do" }, method = RequestMethod.GET)
	public String deleteOK(MenuVO vo) {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		int result = service.delete(vo);
		logger.info("deleteOK()..");
		logger.info("num : " + vo.getNum());
		logger.info("menu : " + vo.getMenu());
		logger.info("price : " + vo.getPrice());
		logger.info("store : " + vo.getStore());
		logger.info("kcal : " + vo.getKcal());

		if (result == 1) {
			return "redirect:selectAll.do";
		} else
			return "redirect:selectAll.do";
	}

	/////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = { "/jselectAll.do" }, method = RequestMethod.GET)
	// jsp로 연결되기 때문에 이 페이지가 jsp를 요청하는 게 아니라 그냥 응답 자체만 하는 페이지라는걸 표시해준다
	@ResponseBody
	public Map<String, List<MenuVO>> jselectAll() {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("jselectAll OK()..");

		List<MenuVO> list = service.selectAll();
		Map<String, List<MenuVO>> map = new HashMap<String, List<MenuVO>>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = { "/jselectAll2.do" }, method = RequestMethod.GET)
	// jsp로 연결되기 때문에 이 페이지가 jsp를 요청하는 게 아니라 그냥 응답 자체만 하는 페이지라는걸 표시해준다
	@ResponseBody
	public List<MenuVO> jselectAll2() {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("jselectAll2 OK()..");

		List<MenuVO> list = service.selectAll();
		return list;
	}
	
	
	// 보여줄 페이지
	@RequestMapping(value = { "/jselectOnePage.do" }, method = RequestMethod.GET)
	public String jselectOnePage() {
		// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
		// ex. httpServletRequest
		logger.info("jselectOnePage OK()..");

		return "menu/jselectOne";
	}
	
	// 데이터를 가져오는 곳
		@RequestMapping(value = { "/jselectOne.do" }, method = RequestMethod.GET)
		// jsp로 연결되기 때문에 이 페이지가 jsp를 요청하는 게 아니라 그냥 응답 자체만 하는 페이지라는걸 표시해준다
		@ResponseBody
		public MenuVO jselectOne(MenuVO vo) {
			// Menu() 괄호에는 request에 해당하는 것들은 다 적을 수 있다.
			// ex. httpServletRequest
			logger.info("jselectOne OK()..");

			MenuVO mvo = service.selectOne(vo);
			return mvo;
		}
		
		
		@RequestMapping(value = { "/android_deleteOK.do" }, method = RequestMethod.GET)
		@ResponseBody
		public Map<String, String> android_deleteOK(MenuVO vo) {
			int result = service.delete(vo);
			Map<String, String> map = new HashMap<String, String>();
			String message;
			if (result == 1) {
				 message = "DeleteOk";
			} else message = "DeleteFailed";
			map.put("result", message);
			return map;
		}

	////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/insertFile.do", method = RequestMethod.GET)
	public String insertFile() {
		logger.info("/insertFile.do");

		return "menu/insertFile";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/insertFileOK.do", method = RequestMethod.POST)
	public String insertFileOK(@ModelAttribute("tvo") MenuVO vo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("method insertOk! getMenu = {}", vo.getMenu());
		logger.info("method insertOk! getPrice = {}", vo.getPrice());
		String imgName = "";

		// 파일에 대한 정보가 넘어간다. null이면 넘어 온 파일이 없다는 뜻.
		MultipartFile multipartFile = vo.getMultipartFile();
		if (null != multipartFile) {
			// null이 아니면 오리지널 파일 이름을 불러온다
			imgName = multipartFile.getOriginalFilename();
			vo.setImgname(imgName);
			logger.info("method insertOk! OriginalFilename = {}", imgName);

			/*
			 * 절대경로와는 다른 realPath. 돌고있는 서버의 경로이다. 여기에 넣어야만 바로 이미지가 들어가서 보이게 된다. 로컬에 있는 폴더에
			 * write하면 새로고침을 하지 않으면 인식하지 않는다. realpath에는 파일 아웃풋과 썸네일 이미지(경량화한) 두 개가 생긴다. 웹에
			 * 뜨는 건 썸네일을 가져온 것.
			 */
			String realPath = request.getRealPath("resources/uploadimg");
			logger.info("method insertOk! realPath = {}", realPath);

			File origin_img = new File(realPath + "/" + imgName); // 오리지널 네임 추가
			multipartFile.transferTo(origin_img);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(origin_img);
			BufferedImage thumb_buffer_img = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			// 이미지 사이즈 조정
			graphic.drawImage(original_buffer_img, 0, 0, 100, 100, null);

			// 이미지 저장할 경로와 이미지의 이름값을 갖고 있는 오브젝트
			File thumb_file = new File(realPath + "/thumb_" + imgName);
			// 확장자명
			ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
		}
		
		service.insert(vo);
		
		// 이미지가 잘 저장됐는지 확인하는 용도
		 return "redirect:insertIMGview.do?img=" + imgName;
		// 썸네일을 보여달라고 하려면
		// return "redirect:insertIMGview.do?img=" + "/thumb_" + imgName;
	}

	@RequestMapping(value = "/insertIMGview.do", method = RequestMethod.GET)
	public String insertIMGview(Model model) {
		logger.info("Welcome insertIMGview!");
		List<MenuVO> list = service.selectAll();
		model.addAttribute("list", list);

		return "menu/insertIMGview";
	}

}
