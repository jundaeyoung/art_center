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

	@PostMapping("/sign-up")
	public String signUpShowProc(RequestSignUpShowDto requestSignUpShowDto) {
		MultipartFile file = requestSignUpShowDto.getFile();
		if (file.isEmpty() == false) {
			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("파일 크기는 20MB 이상 클 수 없습니다", HttpStatus.BAD_REQUEST);
			}
			// 확장자 검사 가능
			try {
				// 파일 저장 기능 구현 - 업로드 파일은 호스트 컴퓨터 다른 폴더로 관리
				String saceDirectory = Define.UPLOAD_DIRECTORY;
				// 폴더가 없다면 오류 발생(파일 생성 시)
				File dir = new File(saceDirectory);
				if (dir.exists() == false) {
					dir.mkdirs(); // 폴더가 없으면 폴더 생성
				}
				UUID uuid = UUID.randomUUID();
				String fileName = uuid + "_" + file.getOriginalFilename();
				String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;
				File destination = new File(uploadPath);
				file.transferTo(destination);

				requestSignUpShowDto.setOriginFileName(file.getOriginalFilename());
				requestSignUpShowDto.setUploadFileName(fileName);
				requestSignUpShowDto.setImgRoute(fileName);
				System.out.println(fileName.length());
			} catch (Exception e) {
				e.printStackTrace();
			}
			showService.createShow(requestSignUpShowDto);
		}
		return "redirect:/manager/signUpShow";
	}

}
