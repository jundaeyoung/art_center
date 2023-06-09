$(document).ready(function() {
	buildCalendar();
}); // 웹 페이지가 로드되면 buildCalendar 실행

let nowMonth = new Date(); // 현재 달을 페이지를 로드한 날의 달로 초기화
let today = new Date(); // 페이지를 로드한 날짜를 저장
today.setHours(0, 0, 0, 0); // 비교 편의를 위해 today의 시간을 초기화

// 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
function buildCalendar() {
	let createDateList = [];
	let createDate;
	let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1); // 이번달 1일
	let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0); // 이번달 마지막날

	let tbody_Calendar = document.querySelector(".Calendar > tbody");
	document.getElementById("calYear").innerText = nowMonth.getFullYear(); // 연도 숫자 갱신
	document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1); // 월 숫자 갱신

	// 이전 출력결과가 남아있는 경우 초기화
	while (tbody_Calendar.rows.length > 0) {
		tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
	}

	let nowRow = tbody_Calendar.insertRow(); // 첫번째 행 추가           

	// 이번달 1일의 요일만큼 열 추가
	for (let j = 0; j < firstDate.getDay(); j++) {
		let nowColumn = nowRow.insertCell();
	}

	// day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  
	let dateIndex = 0;
	for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {

		let nowColumn = nowRow.insertCell(); // 새 열을 추가

		let newDIV = document.createElement("p");
		newDIV.innerHTML = leftPad(nowDay.getDate()); // 추가한 열에 날짜 입력
		nowColumn.appendChild(newDIV);

		if (nowDay.getDay() == 6) { // 토요일인 경우
			nowRow = tbody_Calendar.insertRow(); // 새로운 행 추가
		}

		if (nowDay < today) { // 지난날인 경우
			newDIV.className = "pastDay";
		} else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우
			newDIV.className = "today";
			newDIV.onclick = function() {
				choiceDate(this);
			}
		} else { // 미래인 경우
			newDIV.className = "futureDay";
			newDIV.onclick = function() {
				choiceDate(this);
			}
		}

		createDate = document.getElementById("calYear").textContent + "-" + document.getElementById("calMonth").textContent + "-" + newDIV.textContent;
		createDateList.push(createDate);
	}
	matchDate(createDateList);
}

function matchDate(createDateList) {

	let arrayDateList = [];
	let hiddenDateValue = document.getElementsByClassName('listDate');  // db에 저장된 공연일정 정보 가져오기

	for (let i = 0; i < hiddenDateValue.length; i++) {
		arrayDateList.push(hiddenDateValue[i].value);
	}

	let matchDateIndex = [];
	for (let i = 0; i < createDateList.length; i++) {
		for (let j = 0; j < arrayDateList.length; j++) {
			if (createDateList[i] === arrayDateList[j]) {
				matchDateIndex.push(i);
				continue;
			}
		}
	}

	// 매치해서 같은 날짜에 색 입히기
	let paragraphs = $("p");
	for (let i = 0; i < matchDateIndex.length; i++) {
		let index = matchDateIndex[i] + 2;
		if (index >= 0 && index < paragraphs.length) {
			paragraphs[index].style.backgroundColor = '#F5A9BC';
		}
	}
}

// 날짜 선택
function choiceDate(newDIV) {

	let selectShowId = $("#hiddenShowId").val();
	let selectDate = document.getElementById("calYear").textContent + "-" + document.getElementById("calMonth").textContent + "-" + newDIV.textContent;

	if (document.getElementsByClassName("choiceDay")[0]) { // 기존에 선택한 날짜가 있으면
		document.getElementsByClassName("choiceDay")[0].classList.remove("choiceDay"); // 해당 날짜의 "choiceDay" class 제거
	}
	newDIV.classList.add("choiceDay"); // 선택된 날짜에 "choiceDay" class 추가
	selectDateForTime(selectShowId, selectDate);
}

// 이전달 버튼 클릭
function prevCalendar() {
	nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate()); // 현재 달을 1 감소
	buildCalendar(); // 달력 다시 생성
}
// 다음달 버튼 클릭
function nextCalendar() {
	nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate()); // 현재 달을 1 증가
	buildCalendar(); // 달력 다시 생성
}

// input값이 한자리 숫자인 경우 앞에 '0' 붙여주는 함수
function leftPad(value) {
	if (value < 10) {
		value = "0" + value;
		return value;
	}
	return value;
}

function selectDateForTime(showId, date) {
	//해당 공연일에 공연시간을 갖고오기 위함
	$.ajax({
		type: "get",
		url: "/api/selectDate/" + showId + "/" + date,
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(data) {
		let showTimeList = data.data;
		$(".timeTableList").remove();
		$(".TagPlay").append(`<ul class="timeTableList"></ul>`);
		showTimeList.forEach((showTime) => {
			let addTime = `<li class="timeTableItem"><a class="timeTableLabel" data-tabtoggle="timeTableList" role="button" data-seq="${showTime.id}">${showTime.showTime}</li>`
			$(".timeTableList").append(addTime);

			$(document).on("click", `.timeTableLabel[data-seq="${showTime.id}"]`, function() {
				$(".timeTableLabel").removeClass("is-toggled");
				$(this).addClass("is-toggled");
				$(".timeTableLabel").append(`<input type="hidden" id="hiddenshowDatetimeId" name="showDatetimeId" value="${showTime.id}">`);


				// 해당 공연장의 좌석 정보를 가져오기 위함
				seatInfo(showId, showTime);
				// 해당 공연일 공연장의 예매 완료된 좌석 정보를 가져오기 위함
				//occupiedSeat(showTime);
			});
		});
	}).fail(function(error) {
		console.log(error);
	});
}

function seatInfo(showId, showTime) {
	//좌석정보를 갖고 오기 위함
	$.ajax({
		type: "get",
		url: "/api/selectSeats/" + showId + "/" + showTime.id,
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(data) {
		let seatList = data.data;
		$(".seat--info").empty();
		$(".seat--info").append(`<div class="screen"></div>`);
		$(".seat--info").append(`<div class="row"></div>`);
		let seatsPerRow = 5;
		let currentRow = $(".row");

		let arrSeat = [];
		seatList.forEach((seat, index) => {
			if (index % seatsPerRow === 0 && index !== 0) {
				currentRow = $("<div class='row'></div>");
				$(".seat--info").append(currentRow);
			}

			let addSeat = `<div class="seat" data-seq="${seat.seatId}" value="${seat.seatId}">${seat.seatName}</div>`;
			currentRow.append(addSeat);

			$(document).on('click', `.seat[data-seq="${seat.seatId}"]`, function() {
				$(".seat").removeClass("selected");
				$(this).addClass("selected");
				$(".seat--info").append(`<input type="hidden" id="hiddenSeatId" name="seatId" value="${seat.seatId}">`);
			});
		});

		$.ajax({
			type: "get",
			url: "/api/occupied/" + showTime.id,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data) {
			let occupiedList = data.data;
			occupiedList.forEach((occupiedSeat) => {
				arrSeat.push(occupiedSeat.seatId);
				$(`.seat[data-seq="${occupiedSeat.seatId}"]`).attr("disabled", true);
				$(`.seat[data-seq="${occupiedSeat.seatId}"]`).addClass("occupied");
			});
		}).fail(function(error) {
			console.log(error);

		});

	}).fail(function(error) {
		console.log(error);
	});

	$.ajax({
		type: "get",
		url: "/api/remainingCount/" + showTime.id,
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(data) {
		let remainingCount = data.data;
		$("#remainingCount").text(remainingCount);

	}).fail(function(error) {
		console.log(error);
	});
}
