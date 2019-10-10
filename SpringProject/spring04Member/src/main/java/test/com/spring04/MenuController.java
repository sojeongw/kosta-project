package test.com.spring04;

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

import test.com.spring04.TestVO;
import test.com.spring04.model.MemberVO;
import test.com.spring04.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MenuController {

	@Autowired
	MemberService service;

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/MemberInsert.do", method = RequestMethod.GET)
	public String insert(MemberVO vo) {
		logger.info("/MemberInsert.do");

		return "MemberInsert";
	}

	@RequestMapping(value = "/MemberInsertOK.do", method = RequestMethod.POST)
	public String insertOK(MemberVO vo) {
		logger.info("/MemberInsertOK.do");
		int result = service.insert(vo);

		if (result == 1) {
			return "redirect:MemberSelectAll.do";
		} else
			return "MemberInsert";
	}

	@RequestMapping(value = "/MemberSelectAll.do", method = RequestMethod.GET)
	public String selectAll(MemberVO vo, Model model) {
		logger.info("/MemberSelectAll.do");

		model.addAttribute("list", service.selectAll());

		return "MemberSelectAll";
	}

	@RequestMapping(value = "/MemberUpdate.do", method = RequestMethod.GET)
	public String update(MemberVO vo, Model model) {
		logger.info("/MemberUpdate.do");
		MemberVO mvo = service.selectOne(vo);
		model.addAttribute("mvo", mvo);

		return "MemberUpdate";
	}

	@RequestMapping(value = "/MemberUpdateOK.do", method = RequestMethod.GET)
	public String updateOK(MemberVO vo) {
		logger.info("/MemberUpdateOK.do");
		int result = service.update(vo);

		if (result == 1) {
			return "redirect:MemberSelectAll.do";
		} else
			return "MemberUpdate";

	}

	@RequestMapping(value = "/MemberDeleteOK.do", method = RequestMethod.GET)
	public String deleteOK(MemberVO vo) {
		logger.info("/MemberDeleteOK.do");
		service.delete(vo);

		return "redirect:MemberSelectAll.do";

	}

	@RequestMapping(value = "/jSelectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<MemberVO>> jSelectAll() {
		logger.info("/jSelectAll.do");
		List<MemberVO> list = service.selectAll();
		Map<String, List<MemberVO>> map = new HashMap<String, List<MemberVO>>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/jSelectAll2.do", method = RequestMethod.GET)
	@ResponseBody
	public List<MemberVO> jSelectAll2() {
		logger.info("/jSelectAll2.do");
		List<MemberVO> list = service.selectAll();
		return list;
	}

	@RequestMapping(value = "/jSelectOne.do", method = RequestMethod.GET)
	@ResponseBody
	public MemberVO jSelectOne(MemberVO vo) {
		logger.info("/jSelectOne.do");
		MemberVO mvo = service.selectOne(vo);
		return mvo;
	}

	////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/insertFile.do", method = RequestMethod.GET)
	public String insertFile() {
		logger.info("/insertFile.do");

		return "insertFile";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/insertFileOK.do", method = RequestMethod.POST)
	public String insertFileOK(@ModelAttribute("tvo") TestVO vo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("method insertOk! getId = {}", vo.getId());
		String imgName = "";

		// 파일에 대한 정보가 넘어간다. null이면 넘어 온 파일이 없다는 뜻.
		MultipartFile multipartFile = vo.getMultipartFile();
		if (null != multipartFile) {
			// null이 아니면 오리지널 파일 이름을 불러온다
			imgName = multipartFile.getOriginalFilename();
			vo.setImgName(imgName);
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

		// 이미지가 잘 저장됐는지 확인하는 용도
		return "redirect:insertIMGview.do?img=" + imgName;
		// 썸네일을 보여달라고 하려면
		// return "redirect:insertIMGview.do?img=" + "/thumb_" + imgName;
	}

	@RequestMapping(value = "/insertIMGview.do", method = RequestMethod.GET)
	public String insertIMGview() {
		logger.info("Welcome insertIMGview!");

		return "insertIMGview";
	}

}
