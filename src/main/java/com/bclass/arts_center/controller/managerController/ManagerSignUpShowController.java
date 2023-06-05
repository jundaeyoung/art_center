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
public class ManagerSignUpShowController {

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

	@GetMapping("/signUpShow")
	public String signUpShow(Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		List<Hole> holeList = holeService.readHoleAll();
		List<Category> categoryList = categoryService.readCategoryAll();
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

	@PostMapping("/sign-up")
	public String signUpShowProc(RequestSignUpShowDto requestSignUpShowDto) {
		if (requestSignUpShowDto.getFile() == null || requestSignUpShowDto.getFile().isEmpty()) {
			throw new CustomRestfullException("이미지를 업로드해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (requestSignUpShowDto.getTitle() == null || requestSignUpShowDto.getTitle().isEmpty()) {
			throw new CustomRestfullException("제목을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (requestSignUpShowDto.getContent() == null || requestSignUpShowDto.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (requestSignUpShowDto.getAdultRate() == null || requestSignUpShowDto.getAdultRate().isEmpty()) {
			throw new CustomRestfullException("성인 요금을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (requestSignUpShowDto.getYouthRate() == null || requestSignUpShowDto.getYouthRate().isEmpty()) {
			throw new CustomRestfullException("청소년 요금을 입력해주세요.", HttpStatus.BAD_REQUEST);
		}

		MultipartFile file = requestSignUpShowDto.getFile();
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer adminId = 3;
		String notice = principal.getNickname() + "님이 공연등록을 신청하였습니다.";
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
			String date = requestSignUpShowDto.getStartDate();
			String[] startDateAndEndDate = date.split("~");
			requestSignUpShowDto.setStartDate(startDateAndEndDate[0]);
			requestSignUpShowDto.setEndDate(startDateAndEndDate[1]);
			noticeService.createAdminNotice(notice, principal.getId(), adminId);
			showService.createShow(requestSignUpShowDto);
		}
		return "redirect:/rental";
	}

}
