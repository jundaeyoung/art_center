package com.bclass.arts_center.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * 
 * @author 손주이
 *
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private ShowService showService;

	@Autowired
	private HttpSession session;

	@GetMapping("/ticketing/{showId}")
	public String ticketingPage(@PathVariable("showId") Integer showId, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		String userBirth = principal.getBirthDate();
		String replaceuserBirth = userBirth.replaceAll("-", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String nowDate = sdf.format(now);

		int startMonth1 = Integer.parseInt(replaceuserBirth.substring(0, 4));
		int startMonth2 = Integer.parseInt(nowDate.substring(0, 4));

		int userAge = startMonth2 - startMonth1;
		List<TicketingDto> showDateList = ticketService.readShowDate(showId);
		TicketCheckDto ticketId = ticketService.readTicketId();
		List<TicketingDto> showInfo = ticketService.readShowInfoForTicketing(showId);
		List<ShowViewDto> showInformation = showService.readShowInfoByShowId(showId);
		if (showInformation.get(0).getAdmissionAge().equals("19세 이상")) {
			if (userAge <= 20) {
				throw new CustomRestfullException("19세 미만은 관람하실 수 없습니다.", HttpStatus.BAD_REQUEST);
			}
		}
		if (showInformation.get(0).getAdmissionAge().equals("18세 이상")) {
			if (userAge <= 19) {
				throw new CustomRestfullException("18세 미만은 관람하실 수 없습니다.", HttpStatus.BAD_REQUEST);
			}
		}
		if (showInformation.get(0).getAdmissionAge().equals("12세 이상")) {
			if (userAge <= 13) {
				throw new CustomRestfullException("12세 미만은 관람하실 수 없습니다.", HttpStatus.BAD_REQUEST);
			}
		}
		model.addAttribute("ticketId", ticketId);
		if (showDateList == null || showDateList.isEmpty()) {
			model.addAttribute("showDateList", null);
		} else {
			model.addAttribute("showDateList", showDateList);
		}
		model.addAttribute("showId", showId);
		if (showInfo == null || showInfo.isEmpty()) {
			model.addAttribute("showInfo", null);
		} else {
			model.addAttribute("title", showInfo.get(0).getTitle());
			model.addAttribute("showTypeId", showInfo.get(0).getShowTypeId());
		}
		if (showInformation == null || showInformation.isEmpty()) {
			model.addAttribute("showInformation", null);
		} else {
			model.addAttribute("showInformation", showInformation.get(0).getLocationId());
		}
		return "/ticket/ticketing";
	}

	@PostMapping("/ticketing")
	public String ticketProc(TicketingDto ticketingDto, Integer showDatetimeId) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		String userBirth = principal.getBirthDate();
		String replaceuserBirth = userBirth.replaceAll("-", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String nowDate = sdf.format(now);

		ticketingDto.setUserId(principal.getId());

		Integer count = ticketService.countTicketing(ticketingDto.getShowDatetimeId());

		int startMonth1 = Integer.parseInt(replaceuserBirth.substring(0, 4));
		int startMonth2 = Integer.parseInt(nowDate.substring(0, 4));

		int userAge = startMonth2 - startMonth1;
		if (userAge < 20) {
			ticketingDto.setAgeGroupId(2);
		} else if (userAge >= 20) {
			ticketingDto.setAgeGroupId(3);
		}
		ticketingDto.setUserId(principal.getId());
		if (ticketingDto.getShowTypeId() == 3 && count >= 30) {
			throw new CustomRestfullException("예매 정원을 초과하였습니다.", HttpStatus.BAD_REQUEST);
		}
		if (ticketingDto.getShowTypeId() != 1) {
			ticketingDto.setSeatId(1);
		}
		ticketService.waitTicket(ticketingDto);
		ticketService.selectSeat(ticketingDto.getSeatId(), ticketingDto.getShowDatetimeId());
		return "redirect:/ticket/ticketCheck";

	}

	@GetMapping("/ticketCheck")
	public String ticketCheck(TicketingDto ticketingDto, Model model) throws WriterException, IOException {
		TicketCheckDto ticketid = ticketService.readTicketId();

		String savePath = "C:\\spring_upload\\arts_center\\upload\\"; 
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String showUrl = "https://github.com/jundaeyoung/art_center";

		String codeurl = new String(showUrl.getBytes("UTF-8"), "ISO-8859-1");

		// QRCode 색상값
		int qrcodeColor = 0xFF000000;
		// QRCode 배경색상값
		int backgroundColor = 0xefe3d3;

		// QRCode 생성
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE, 350, 350); // 200,200은 width, height

		MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);
		BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);

		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sd.format(new Date());
		
		File temp = new File(savePath + fileName + ticketid.getId() + ".png");
		String path = fileName + ticketid.getId();
		
		ImageIO.write(bufferedImage, "png", temp);

		ticketService.updateQrCode(ticketid.getId(), path);

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		List<TicketCheckDto> ticketListInfo = ticketService.checkTicket(principal.getId());

		if (ticketListInfo == null) {
			model.addAttribute("ticketListInfo", null);
		} else {
			model.addAttribute("ticketListInfo", ticketListInfo);
		}
		return "/ticket/ticketCheck";
	}

}
