package com.bclass.arts_center.controller.managerController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ManagerShowSaleService;
import com.bclass.arts_center.utils.Define;

@RestController
@RequestMapping("/apiShowSale")
public class ManagerShowSaleApiController {

	@Autowired
	private ManagerShowSaleService managerShowSaleService;
	@Autowired
	private HttpSession session;

	
	
	@GetMapping("/manager/showSale")
	public List<RequestManagerShowSaleDto> managerShowSale(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> selectCount = managerShowSaleService.readAndCount(requestManagerShowSaleDto);
		return selectCount;
	}
}
