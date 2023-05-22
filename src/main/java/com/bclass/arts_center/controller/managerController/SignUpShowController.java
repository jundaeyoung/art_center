package com.bclass.arts_center.controller.managerController;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.Category;
import com.bclass.arts_center.repository.model.Hole;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.CategoryService;
import com.bclass.arts_center.service.HoleService;
import com.bclass.arts_center.service.NoticeService;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/manager")
public class SignUpShowController {

	@Autowired
	private HoleService holeService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ShowService showService;
	@Autowired
	private HttpSession session;
	@Autowired
	private NoticeService noticeService;
	
	/*
	 * 작성자 : 전대영
	 * show 등록 화면 들어가기
	 */
	@GetMapping("/signUpShow")
	public String signUpShow(Model model) {
		List<Hole> holeList = holeService.readHoleAll();
		List<Category> categoryList = categoryService.readCategoryAll();
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			model.addAttribute("principal", null);
		} else {
			model.addAttribute("principal", principal);
		}
		if (holeList.isEmpty()) {
			model.addAttribute("holeList", null);
		} else {
			model.addAttribute("holeList", holeList);
		}
		if (categoryList.isEmpty()) {
			model.addAttribute("categoryList", null);
		} else {
			model.addAttribute("categoryList", categoryList);
		}
		return "/manager/signUpShow";
	}

	/*
	 * 작성자 : 전대영
	 * show 등록
	 */
	@PostMapping("/sign-up")
	public String signUpShowProc(RequestSignUpShowDto requestSignUpShowDto) {
		MultipartFile file = requestSignUpShowDto.getFile();
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer adminId = 3;
		String notice = principal.getNickname()+"님이 공연등록을 신청하였습니다.";
		if (file.isEmpty() == false) {
			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("파일 크기는 20MB 이상 클 수 없습니다", HttpStatus.BAD_REQUEST);
			}
			try {
				String saceDirectory = Define.UPLOAD_DIRECTORY;
				File dir = new File(saceDirectory);
				if (dir.exists() == false) {
					dir.mkdirs();
				}
				UUID uuid = UUID.randomUUID();
				String fileName = uuid + "_" + file.getOriginalFilename();
				String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;
				File destination = new File(uploadPath);
				file.transferTo(destination);

				requestSignUpShowDto.setOriginFileName(file.getOriginalFilename());
				requestSignUpShowDto.setUploadFileName(fileName);
				requestSignUpShowDto.setImgRoute(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String str = requestSignUpShowDto.getStartDate();
			String[] split = str.split("~");
			requestSignUpShowDto.setStartDate(split[0]);
			requestSignUpShowDto.setEndDate(split[1]);
			noticeService.createNotice(notice,principal.getId(),adminId);
			showService.createShow(requestSignUpShowDto);
		}
		return "redirect:/manager/signUpShow";
	}

}
