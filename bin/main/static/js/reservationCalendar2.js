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
			let selectDay = $(".choiceDay").html();

			let selectDate = selectYear + "-" + selectMonth + "-" + selectDay
			console.log(selectDate);
			let selectTime = $(".is-toggled").html();
			console.log(selectTime);
			let selectSeat = $(".selected").html();
			console.log(selectSeat);
			// 날짜, 시간, showId  	
			this.move(selectDate, selectTime, selectSeat);
		})
	},
	move: function(selectDate, selectTime, selectSeat) {

		let data = {
			date:selectDate,
			time:selectTime,
			seat:selectSeat,
		}
		

		// 이동 횟수
		$.ajax({
			type: "post",
			url: "/api/ticketCheck",
			contentType: "application/json; charset=utf-8",
			data: data,
			//dataType: "json"
		}).done(function(res, statusTesxt, xhr) {
			console.log("되랏");
			console.log(data);
			//location.href = "/ticket/ticketCheck";
		}).fail(function(error) {
			console.log(error);
		});
		// 파싱기술 <-- 
		// (@requestBody  )

		// 데이터베이스 접근 기술 -- 

		// controller 단에서 데이터로 응답 해야 할 때 
		// 사용해야는 어노테이션은 ?? 
		// @requestBody

		//console.log("11111");
		// 통신요청 -- 동기, 비동기
		// 서버 요청 
		// 실패 - 통신 ㅌ
		// 성공 - 페이지 이동 

	}
};

index.init();