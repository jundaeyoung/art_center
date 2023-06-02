$(document).ready(function() {
	var isRequestInProgress = false; // 요청이 진행 중인지를 나타내는 변수

	$("#show").on("click", function() {
		$.ajax({
			type: 'get',
			url: '/apiReview/categoryReview?category=공연&currentPage=1&begin=0&range=3',
			contentType: 'application/json; charset=utf-8',
		}).done(function(response) {

			$(".review__title").empty();

			let reviewTitle = `<span class="material-symbols-outlined"> square </span>
								<div>
								<h1>리뷰</h1>
								<h2>공연</h2>
								</div>`;
			$(".review__title").append(reviewTitle);




			$(".review").empty();
			for (let i = 0; i < response.length; i++) {

				let reviewContent = `<div class="review__content">
			<div>
				<a href="/show/showView/`+ response[i].showId +`"><img src="/images/`+response[i].imgRoute+`" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>`+response[i].title+`&nbsp&nbsp&nbsp&nbsp(`+response[i].showType+`)</h2>
				<p>`+response[i].reviewContent+`</p>
				<div class="review__content__info">
					<h4 class="review__content__username">`+response[i].userName+`&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp`+response[i].reviewCreationDate+`</h4>
				</div>
				<h3>평점 : `+response[i].rating.toFixed(1)+`</h3>
			</div>
		</div>`;
				$(".review").append(reviewContent);
			}
			
			$(".page").empty();


			for (let i = 1; i <= response[0].count; i++) {
				let page = $("<a>");
				page.attr("href", "/review/categoryReview?category=공연&currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
				$(".page").append(page);

				let tagPageP = $("<p>");
				page.append(tagPageP);

				let value = (i);
				tagPageP.append(value);
			}
			let page1 = $("<a>");
			page1.attr("href", "/review/categoryReview?category=공연&currentPage=" + (response.length - 1) + "&begin=" + 3 * (response.length - 2) + "&range=3");
			$(".page").append(page1);

			if (response[0].count >= 2) {
				let tagPageP1 = $("<p>");
				page1.append(tagPageP1);
				let value1 = (">");
				tagPageP1.append(value1);
			}
		}).fail(function(error) {
			alert("현재 상영중인 공연이 없습니다.");
		});
	});
	// 공연까지


	$("#exhibition").on("click", function() {
		$.ajax({
			type: 'get',
			url: '/apiReview/categoryReview?category=전시회&currentPage=1&begin=0&range=3',
			contentType: 'application/json; charset=utf-8',
		}).done(function(response) {

			$(".review__title").empty();

			let reviewTitle = `<span class="material-symbols-outlined"> square </span>
								<div>
								<h1>리뷰</h1>
								<h2>전시회</h2>
								</div>`;
			$(".review__title").append(reviewTitle);




			$(".review").empty();
			for (let i = 0; i < response.length; i++) {

				let reviewContent = `<div class="review__content">
			<div>
				<a href="/show/showView/`+ response[i].showId +`"><img src="/images/`+response[i].imgRoute+`" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>`+response[i].title+`&nbsp&nbsp&nbsp&nbsp(`+response[i].showType+`)</h2>
				<p>`+response[i].reviewContent+`</p>
				<div class="review__content__info">
					<h4 class="review__content__username">`+response[i].userName+`&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp`+response[i].reviewCreationDate+`</h4>
				</div>
				<h3>평점 : `+response[i].rating.toFixed(1)+`</h3>
			</div>
		</div>`;
				$(".review").append(reviewContent);
			}
			$(".page").empty();


			for (let i = 1; i <= response[0].count; i++) {
				let page = $("<a>");
				page.attr("href", "/review/categoryReview?category=전시회&currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
				$(".page").append(page);

				let tagPageP = $("<p>");
				page.append(tagPageP);

				let value = (i);
				tagPageP.append(value);
			}
			let page1 = $("<a>");
			page1.attr("href", "/review/categoryReview?category=전시회&currentPage=" + (response.length - 1) + "&begin=" + 3 * (response.length - 2) + "&range=3");
			$(".page").append(page1);

			if (response[0].count >= 2) {
				let tagPageP1 = $("<p>");
				page1.append(tagPageP1);
				let value1 = (">");
				tagPageP1.append(value1);
			}
		}).fail(function(error) {
			alert("현재 상영중인 공연이 없습니다.");
		});
	});
	// 전시회까지
	
	
	$("#academy").on("click", function() {
		$.ajax({
			type: 'get',
			url: '/apiReview/categoryReview?category=아카데미&currentPage=1&begin=0&range=3',
			contentType: 'application/json; charset=utf-8',
		}).done(function(response) {

			$(".review__title").empty();

			let reviewTitle = `<span class="material-symbols-outlined"> square </span>
								<div>
								<h1>리뷰</h1>
								<h2>아카데미</h2>
								</div>`;
			$(".review__title").append(reviewTitle);




			$(".review").empty();
			for (let i = 0; i < response.length; i++) {

				let reviewContent = `<div class="review__content">
			<div>
				<a href="/show/showView/`+ response[i].showId +`"><img src="/images/`+response[i].imgRoute+`" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>`+response[i].title+`&nbsp&nbsp&nbsp&nbsp(`+response[i].showType+`)</h2>
				<p>`+response[i].reviewContent+`</p>
				<div class="review__content__info">
					<h4 class="review__content__username">`+response[i].userName+`&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp`+response[i].reviewCreationDate+`</h4>
				</div>
				<h3>평점 : `+response[i].rating.toFixed(1)+`</h3>
			</div>
		</div>`;
				$(".review").append(reviewContent);
			}
			$(".page").empty();


			for (let i = 1; i <= response[0].count; i++) {
				let page = $("<a>");
				page.attr("href", "/review/categoryReview?category=아카데미&currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
				$(".page").append(page);

				let tagPageP = $("<p>");
				page.append(tagPageP);

				let value = (i);
				tagPageP.append(value);
			}
			let page1 = $("<a>");
			page1.attr("href", "/review/categoryReview?category=아카데미&currentPage=" + (response.length - 1) + "&begin=" + 3 * (response.length - 2) + "&range=3");
			$(".page").append(page1);

			if (response[0].count >= 2) {
				let tagPageP1 = $("<p>");
				page1.append(tagPageP1);
				let value1 = (">");
				tagPageP1.append(value1);
			}
		}).fail(function(error) {
			alert("현재 상영중인 공연이 없습니다.");
		});
	});
	// 아카데미까지
	
	
	
	$("#newest").on("click", function() {
		$.ajax({
			type: 'get',
			url: '/apiReview/newestReview?currentPage=1&begin=0&range=3',
			contentType: 'application/json; charset=utf-8',
		}).done(function(response) {

			$(".review__title").empty();

			let reviewTitle = `<span class="material-symbols-outlined"> square </span>
								<div>
								<h1>리뷰</h1>
								<h2>아카데미</h2>
								</div>`;
			$(".review__title").append(reviewTitle);

			$(".review").empty();
			for (let i = 0; i < response.length; i++) {

				let reviewContent = `<div class="review__content">
			<div>
				<a href="/show/showView/`+ response[i].showId +`"><img src="/images/`+response[i].imgRoute+`" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>`+response[i].title+`&nbsp&nbsp&nbsp&nbsp(`+response[i].showType+`)</h2>
				<p>`+response[i].reviewContent+`</p>
				<div class="review__content__info">
					<h4 class="review__content__username">`+response[i].userName+`&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp`+response[i].reviewCreationDate+`</h4>
				</div>
				<h3>평점 : `+response[i].rating.toFixed(1)+`</h3>
			</div>
		</div>`;
				$(".review").append(reviewContent);
			}
			$(".page").empty();


			for (let i = 1; i <= response[0].count; i++) {
				let page = $("<a>");
				page.attr("href", "/review/newestReview?currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
				$(".page").append(page);

				let tagPageP = $("<p>");
				page.append(tagPageP);

				let value = (i);
				tagPageP.append(value);
			}
			let page1 = $("<a>");
			page1.attr("href", "/review/newestReview?currentPage=" + (response.length - 1) + "&begin=" + 3 * (response.length - 2) + "&range=3");
			$(".page").append(page1);

			if (response[0].count >= 2) {
				let tagPageP1 = $("<p>");
				page1.append(tagPageP1);
				let value1 = (">");
				tagPageP1.append(value1);
			}
		}).fail(function(error) {
			alert("현재 상영중인 공연이 없습니다.");
		});
	});
	// 최신순까지
	
	$("#highes__rated").on("click", function() {
		$.ajax({
			type: 'get',
			url: '/apiReview/highestRatedReview?currentPage=1&begin=0&range=3',
			contentType: 'application/json; charset=utf-8',
		}).done(function(response) {

			$(".review__title").empty();

			let reviewTitle = `<span class="material-symbols-outlined"> square </span>
								<div>
								<h1>리뷰</h1>
								<h2>아카데미</h2>
								</div>`;
			$(".review__title").append(reviewTitle);

			$(".review").empty();
			for (let i = 0; i < response.length; i++) {

				let reviewContent = `<div class="review__content">
			<div>
				<a href="/show/showView/`+ response[i].showId +`"><img src="/images/`+response[i].imgRoute+`" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>`+response[i].title+`&nbsp&nbsp&nbsp&nbsp(`+response[i].showType+`)</h2>
				<p>`+response[i].reviewContent+`</p>
				<div class="review__content__info">
					<h4 class="review__content__username">`+response[i].userName+`&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp`+response[i].reviewCreationDate+`</h4>
				</div>
				<h3>평점 : `+response[i].rating.toFixed(1)+`</h3>
			</div>
		</div>`;
				$(".review").append(reviewContent);
			}
			$(".page").empty();


			for (let i = 1; i <= response[0].count; i++) {
				let page = $("<a>");
				page.attr("href", "/review/highestRatedReview?currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
				$(".page").append(page);

				let tagPageP = $("<p>");
				page.append(tagPageP);

				let value = (i);
				tagPageP.append(value);
			}
			let page1 = $("<a>");
			page1.attr("href", "/review/highestRatedReview?currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
			$(".page").append(page1);

			if (response[0].count >= 2) {
				let tagPageP1 = $("<p>");
				page1.append(tagPageP1);
				let value1 = (">");
				tagPageP1.append(value1);
			}
		}).fail(function(error) {
			alert("현재 상영중인 공연이 없습니다.");
		});
	});
	// 평점 높은순까지
	
	
	$("#lowest__rated").on("click", function() {
		$.ajax({
			type: 'get',
			url: '/apiReview/rowestRatedReview?currentPage=1&begin=0&range=3',
			contentType: 'application/json; charset=utf-8',
		}).done(function(response) {

			$(".review__title").empty();

			let reviewTitle = `<span class="material-symbols-outlined"> square </span>
								<div>
								<h1>리뷰</h1>
								<h2>아카데미</h2>
								</div>`;
			$(".review__title").append(reviewTitle);

			$(".review").empty();
			for (let i = 0; i < response.length; i++) {

				let reviewContent = `<div class="review__content">
			<div>
				<a href="/show/showView/`+ response[i].showId +`"><img src="/images/`+response[i].imgRoute+`" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>`+response[i].title+`&nbsp&nbsp&nbsp&nbsp(`+response[i].showType+`)</h2>
				<p>`+response[i].reviewContent+`</p>
				<div class="review__content__info">
					<h4 class="review__content__username">`+response[i].userName+`&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp`+response[i].reviewCreationDate+`</h4>
				</div>
				<h3>평점 : `+response[i].rating.toFixed(1)+`</h3>
			</div>
		</div>`;
				$(".review").append(reviewContent);
			}
			$(".page").empty();


			for (let i = 1; i <= response[0].count; i++) {
				let page = $("<a>");
				page.attr("href", "/review/rowestRatedShow?currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
				$(".page").append(page);

				let tagPageP = $("<p>");
				page.append(tagPageP);

				let value = (i);
				tagPageP.append(value);
			}
			let page1 = $("<a>");
			page1.attr("href", "/review/rowestRatedShow?currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
			$(".page").append(page1);

			if (response[0].count >= 2) {
				let tagPageP1 = $("<p>");
				page1.append(tagPageP1);
				let value1 = (">");
				tagPageP1.append(value1);
			}
		}).fail(function(error) {
			alert("현재 상영중인 공연이 없습니다.");
		});
	});
	// 평점 낮은순까지
	
	
	



});
