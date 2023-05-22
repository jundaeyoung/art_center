/**
 * 
 */

let index = {
	
	init: function() {

		// 이벤트 바인딩 처리 
		$(".btn--ticketing").on("click", () => {
			// 데이터 준비
			let selectYear = $("#calYear").html();
			let selectMonth = $("#calMonth").html();
			let selectDay= $(".choiceDay").html();
			
			let selectDate = selectYear+"-"+selectMonth+"-"+selectDay
			console.log(selectDate);
			let selectTime = $(".select").val();
			//console.log(selectTime); 
			// 날짜, 시간, showId  	
			this.move();
		})
	},
	move: function() {
		
		
		let data = {
			date : "", 
			time : "", 
			showId : "1"
		};
		
		$.ajax({
			type: "post", 
			url: "",
			contentType: "application/json;  charset=utf-8", 
			data: JSON.stringify(data)  
			
		}).doen().fail();
		
		// 파싱기술 <-- 
		// (@requestBody  )
		
		// 데이터베이스 접근 기술 -- 
		
		// controller 단에서 데이터로 응답 해야 할 때 
		// 사용해야는 어노테이션은 ?? 
		// @requestBody
		
		console.log("11111");
		// 통신요청 -- 동기, 비동기
		// 서버 요청 
		// 실패 - 통신 ㅌ
		// 성공 - 페이지 이동 

	}
};

index.init();