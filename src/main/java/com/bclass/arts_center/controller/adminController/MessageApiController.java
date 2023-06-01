package com.bclass.arts_center.controller.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.service.TicketService;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
public class MessageApiController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/sendMessage")
	public void sendMessage(Integer sessionTicketingId) throws NurigoEmptyResponseException, NurigoUnknownException {
		TicketCheckDto result = ticketService.readTicketIdById(sessionTicketingId);
		Message message = new Message();
		DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCSIUCBVWM1LNGYW", "PORQYCOTCZG40A9QVR77YYW0HS5IJM6Y", "https://api.coolsms.co.kr");
		message.setFrom("01024790491");
		message.setTo("01042410914");
		if(result.getShowTypeId()==1) {
			message.setText("공연 시간: "+result.getShowDate()+"일"+result.getShowTime()+"시 \n"
					+"공연정보: "+result.getTitle() +"("+result.getName()+"/"+result.getSeatName()+")\n"
							+ "즐거운 시간 되십시오");
		}else if(result.getShowTypeId()==2) {
			message.setText("전시회 시간: "+result.getShowDate()+"일"+result.getShowTime()+"시 \n"
					+ "전시회 정보: "+result.getTitle() +"("+result.getName()+")\n"
					+ "즐거운 시간 되십시오");
		}else {
			message.setText("아카데미 시간: "+result.getShowDate()+"일"+result.getShowTime()+"시 \n"
					+ "아카데미 정보: "+result.getTitle() +"("+result.getName()+")\n"
					+ "즐거운 시간 되십시오");
		}
		try {
			  messageService.send(message);
			} catch (NurigoMessageNotReceivedException exception2) {
		}
	}

//	@PostMapping("/send-mms")
//	public SingleMessageSentResponse sendMmsByResourcePath(Integer sessionTicketingId) throws IOException {
//		TicketCheckDto result = ticketService.readTicketIdById(sessionTicketingId);
//		String targetUrl = "https://github.com/jundaeyoung/art_center";
//		String parameters = "{\"file\":\"C:\\\\spring_upload\\\\arts_center\\\\upload\\\\\""+result.getQrCode() +".png\"}";
//		System.out.println(parameters+"parameters");
//		URL url = new URL(targetUrl);
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//		con.setRequestMethod("POST");
//
//		con.setRequestProperty("Authorization",
//				"HMAC-SHA256 apiKey=NCSAYU7YDBXYORXC, date=2019-07-01T00:41:48Z, salt=jqsba2jxjnrjor, signature=1779eac71a24cbeeadfa7263cb84b7ea0af1714f5c0270aa30ffd34600e363b4");
//		con.setRequestProperty("Content-Type", "application/json");
//
//		con.setDoOutput(true);
//		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//		wr.writeBytes(parameters);
//		wr.flush();
//		wr.close();
//
//		int responseCode = con.getResponseCode();
//		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		String line;
//		StringBuffer response = new StringBuffer();
//		while ((line = in.readLine()) != null) {
//			response.append(line);
//		}
//		in.close();
//
//		ClassPathResource resource = new ClassPathResource("C:\\spring_upload\\arts_center\\upload\\"+result.getQrCode()+".png");
//		DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCSIUCBVWM1LNGYW",
//				"PORQYCOTCZG40A9QVR77YYW0HS5IJM6Y", "https://api.coolsms.co.kr");
//		File file = resource.getFile();
//		String imageId = messageService.uploadFile(file, StorageType.MMS, null);
//
//		Message message = new Message();
//		// 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
//		message.setFrom("01024790491");
//		message.setTo("01042410914");
//		message.setText("한글 45자, 영자 90자 이하 입력되면 자동으로 SMS타입의 메시지가 추가됩니다.");
//		message.setImageId(imageId);
//
//		// 여러 건 메시지 발송일 경우 send many 예제와 동일하게 구성하여 발송할 수 있습니다.
//		SingleMessageSentResponse responsemessage = messageService.sendOne(new SingleMessageSendingRequest(message));
//		System.out.println(responsemessage);
//
//		return responsemessage;
//	}

}