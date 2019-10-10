package test.com.spring03;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

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

import test.com.spring03.TestVO;
import test.com.spring03.model.BoardVO;
import test.com.spring03.service.BoardService;

@Controller
public class MenuController {

	// index에서 어떤 메뉴라도 index로 돌아가는 문제 발생

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	@Autowired
	BoardService service;

	@RequestMapping(value = "/BoardIndex.do", method = RequestMethod.GET)
	public String index() {
		logger.info("/BoardIndex.do");

		return "BoardIndex";
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
			return "redirect:BoardUpdate.do?=num" + vo.getNum();
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

	////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/insertFile.do", method = RequestMethod.GET)
	public String insertFile() {
		logger.info("/insertFile.do");

		return "insertFile";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/insertFileOK.do", method = RequestMethod.POST)
	public String insertFileOK(@ModelAttribute("vo") BoardVO vo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("method insertOk! getNum = {}", vo.getNum());
		logger.info("method insertOk! getTitle = {}", vo.getTitle());
		logger.info("method insertOk! getContent = {}", vo.getContent());
		logger.info("method insertOk! getWriter = {}", vo.getWriter());
		logger.info("method insertOk! getReg_date = {}", vo.getReg_date());
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
		// return "redirect:insertIMGview.do?img=" + imgName;
		// 썸네일을 보여달라고 하려면
		return "redirect:insertIMGview.do?img=" + "/thumb_" + imgName;
	}

	@RequestMapping(value = "/insertIMGview.do", method = RequestMethod.GET)
	public String insertIMGview() {
		logger.info("Welcome insertIMGview!");
		service.selectAll();

		return "insertIMGview";
	}

}
