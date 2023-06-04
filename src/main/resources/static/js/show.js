$(document).ready(function() {
	var isRequestInProgress = false; // 요청이 진행 중인지를 나타내는 변수


$("#show").on("click", function() {
    $.ajax({
        type: 'get',
        url: '/apiShow/categoryShow?category=공연&currentPage=1&begin=0&range=3',
        contentType: 'application/json; charset=utf-8',
    }).done(function(response) {

        $(".show__title").empty();

        let showTitle = `<span class="material-symbols-outlined"> square </span>
                            <div>
                            <h1>Show</h1>
                            <h2>공연</h2>
                            </div>`;
        $(".show__title").append(showTitle);

        $(".show").empty();
        for (let i = 0; i < response.data.length; i++) {
            let ratingContent = '';
            if (response.data[i].rating == null) {
                ratingContent = '<h3>평점이 아직 등록되지 않았습니다.</h3>';
            } else {
                ratingContent = '<h3>평점 : ' + response.data[i].rating + '</h3>';
            }

            let showContent = '<div class="review__content">' +
                '<div>' +
                '<a href="/show/showView/' + response.data[i].id + '"><img src="/images/' + response.data[i].imgRoute + '" width="230" height="300"></a>' +
                '</div>' +
                '<div class="show__content">' +
                '<h2>' + response.data[i].title + '&nbsp;(' + response.data[i].showType + ')</h2>' +
                '<p>' + response.data[i].content + '</p>' +
                ratingContent +
                '</div>' +
                '</div>';

            $(".show").append(showContent);
        }
        $(".page").empty();

        for (let i = 1; i <= response.data[0].count; i++) {
			let page = $("<a>");
			page.attr("href", "/show/categoryShow?category=공연&currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
			$(".page").append(page);

			let tagPageP = $("<p>");
			page.append(tagPageP);

			let value = (i);
			tagPageP.append(value);
		}
		let page1 = $("<a>");
		page1.attr("href", "/show/categoryShow?category=공연&currentPage=" + 1 + "&begin=0&range=3");
		$(".page").append(page1);

		if (response.data[0].count >= 2) {
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
        url: '/apiShow/categoryShow?category=전시회&currentPage=1&begin=0&range=3',
        contentType: 'application/json; charset=utf-8',
    }).done(function(response) {

        $(".show__title").empty();

        let showTitle = `<span class="material-symbols-outlined"> square </span>
                            <div>
                            <h1>Show</h1>
                            <h2>전시회</h2>
                            </div>`;
        $(".show__title").append(showTitle);

        $(".show").empty();
        for (let i = 0; i < response.data.length; i++) {
            let ratingContent = '';
            if (response.data[i].rating == null) {
                ratingContent = '<h3>평점이 아직 등록되지 않았습니다.</h3>';
            } else {
                ratingContent = '<h3>평점 : ' + response.data[i].rating + '</h3>';
            }

            let showContent = '<div class="review__content">' +
                '<div>' +
                '<a href="/show/showView/' + response.data[i].id + '"><img src="/images/' + response.data[i].imgRoute + '" width="230" height="300"></a>' +
                '</div>' +
                '<div class="show__content">' +
                '<h2>' + response.data[i].title + '&nbsp;(' + response.data[i].showType + ')</h2>' +
                '<p>' + response.data[i].content + '</p>' +
                ratingContent +
                '</div>' +
                '</div>';

            $(".show").append(showContent);
        }
        $(".page").empty();

        for (let i = 1; i <= response.data[0].count; i++) {
			let page = $("<a>");
			page.attr("href", "/show/categoryShow?category=전시회&currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
			$(".page").append(page);

			let tagPageP = $("<p>");
			page.append(tagPageP);

			let value = (i);
			tagPageP.append(value);
		}
		let page1 = $("<a>");
		page1.attr("href", "/show/categoryShow?category=전시회&currentPage=" + 1 + "&begin=0&range=3");
		$(".page").append(page1);

		if (response.data[0].count >= 2) {
			let tagPageP1 = $("<p>");
			page1.append(tagPageP1);
			let value1 = (">");
			tagPageP1.append(value1);
		}
		
    }).fail(function(error) {
        alert("현재 상영중인 공연이 없습니다.");
    });
});

$("#academy").on("click", function() {
    $.ajax({
        type: 'get',
        url: '/apiShow/categoryShow?category=아카데미&currentPage=1&begin=0&range=3',
        contentType: 'application/json; charset=utf-8',
    }).done(function(response) {

        $(".show__title").empty();

        let showTitle = `<span class="material-symbols-outlined"> square </span>
                            <div>
                            <h1>Show</h1>
                            <h2>아카데미</h2>
                            </div>`;
        $(".show__title").append(showTitle);

        $(".show").empty();
        for (let i = 0; i < response.data.length; i++) {
            let ratingContent = '';
            if (response.data[i].rating == null) {
                ratingContent = '<h3>평점이 아직 등록되지 않았습니다.</h3>';
            } else {
                ratingContent = '<h3>평점 : ' + response.data[i].rating + '</h3>';
            }

            let showContent = '<div class="review__content">' +
                '<div>' +
                '<a href="/show/showView/' + response.data[i].id + '"><img src="/images/' + response.data[i].imgRoute + '" width="230" height="300"></a>' +
                '</div>' +
                '<div class="show__content">' +
                '<h2>' + response.data[i].title + '&nbsp;(' + response.data[i].showType + ')</h2>' +
                '<p>' + response.data[i].content + '</p>' +
                ratingContent +
                '</div>' +
                '</div>';

            $(".show").append(showContent);
        }
        $(".page").empty();

      for (let i = 1; i <= response.data[0].count; i++) {
			let page = $("<a>");
			page.attr("href", "/show/categoryShow?category=아카데미&currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
			$(".page").append(page);

			let tagPageP = $("<p>");
			page.append(tagPageP);

			let value = (i);
			tagPageP.append(value);
		}
		let page1 = $("<a>");
		page1.attr("href", "/show/categoryShow?category=아카데미&currentPage=" + 1 + "&begin=0&range=3");
		$(".page").append(page1);

		if (response.data[0].count >= 2) {
			let tagPageP1 = $("<p>");
			page1.append(tagPageP1);
			let value1 = (">");
			tagPageP1.append(value1);
		}
		
	}).fail(function(error) {
		alert("현재 상영중인 공연이 없습니다.");
	});
});

$("#newest").on("click", function() {
    $.ajax({
        type: 'get',
        url: '/apiShow/newestShow?currentPage=1&begin=0&range=3',
        contentType: 'application/json; charset=utf-8',
    }).done(function(response) {

        $(".show__title").empty();

        let showTitle = `<span class="material-symbols-outlined"> square </span>
                            <div>
                            <h1>Show</h1>
                            <h2>최신순</h2>
                            </div>`;
        $(".show__title").append(showTitle);

        $(".show").empty();
        for (let i = 0; i < response.data.length; i++) {
            let ratingContent = '';
            if (response.data[i].rating == null) {
                ratingContent = '<h3>평점이 아직 등록되지 않았습니다.</h3>';
            } else {
                ratingContent = '<h3>평점 : ' + response.data[i].rating + '</h3>';
            }

            let showContent = '<div class="review__content">' +
                '<div>' +
                '<a href="/show/showView/' + response.data[i].id + '"><img src="/images/' + response.data[i].imgRoute + '" width="230" height="300"></a>' +
                '</div>' +
                '<div class="show__content">' +
                '<h2>' + response.data[i].title + '&nbsp;(' + response.data[i].showType + ')</h2>' +
                '<p>' + response.data[i].content + '</p>' +
                ratingContent +
                '</div>' +
                '</div>';

            $(".show").append(showContent);
        }
        $(".page").empty();

      for (let i = 1; i <= response.data[0].count; i++) {
			let page = $("<a>");
			page.attr("href", "/show/newestShow?currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
			$(".page").append(page);

			let tagPageP = $("<p>");
			page.append(tagPageP);

			let value = (i);
			tagPageP.append(value);
		}
		let page1 = $("<a>");
		page1.attr("href", "/show/newestShow?currentPage=" + 1 + "&begin=0&range=3");
		$(".page").append(page1);

		if (response.data[0].count >= 2) {
			let tagPageP1 = $("<p>");
			page1.append(tagPageP1);
			let value1 = (">");
			tagPageP1.append(value1);
		}
		
	}).fail(function(error) {
		alert("현재 상영중인 공연이 없습니다.");
	});
});

$("#highes__rated").on("click", function() {
    $.ajax({
        type: 'get',
        url: '/apiShow/highesRatedShow?currentPage=1&begin=0&range=3',
        contentType: 'application/json; charset=utf-8',
    }).done(function(response) {

        $(".show__title").empty();

        let showTitle = `<span class="material-symbols-outlined"> square </span>
                            <div>
                            <h1>Show</h1>
                            <h2>평점 높은순</h2>
                            </div>`;
        $(".show__title").append(showTitle);

        $(".show").empty();
        for (let i = 0; i < response.data.length; i++) {
            let ratingContent = '';
            if (response.data[i].rating == null) {
                ratingContent = '<h3>평점이 아직 등록되지 않았습니다.</h3>';
            } else {
                ratingContent = '<h3>평점 : ' + response.data[i].rating + '</h3>';
            }

            let showContent = '<div class="review__content">' +
                '<div>' +
                '<a href="/show/showView/' + response.data[i].id + '"><img src="/images/' + response.data[i].imgRoute + '" width="230" height="300"></a>' +
                '</div>' +
                '<div class="show__content">' +
                '<h2>' + response.data[i].title + '&nbsp;(' + response.data[i].showType + ')</h2>' +
                '<p>' + response.data[i].content + '</p>' +
                ratingContent +
                '</div>' +
                '</div>';

            $(".show").append(showContent);
        }
        $(".page").empty();

      for (let i = 1; i <= response.data[0].count; i++) {
			let page = $("<a>");
			page.attr("href", "/show/highesRatedShow?currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
			$(".page").append(page);

			let tagPageP = $("<p>");
			page.append(tagPageP);

			let value = (i);
			tagPageP.append(value);
		}
		let page1 = $("<a>");
		page1.attr("href", "/show/highesRatedShow?currentPage=" + 1 + "&begin=0&range=3");
		$(".page").append(page1);

		if (response.data[0].count >= 2) {
			let tagPageP1 = $("<p>");
			page1.append(tagPageP1);
			let value1 = (">");
			tagPageP1.append(value1);
		}
		
	}).fail(function(error) {
		alert("현재 상영중인 공연이 없습니다.");
	});
});

$("#lowest__rated").on("click", function() {
    $.ajax({
        type: 'get',
        url: '/apiShow/rowestRatedShow?currentPage=1&begin=0&range=3',
        contentType: 'application/json; charset=utf-8',
    }).done(function(response) {

        $(".show__title").empty();

        let showTitle = `<span class="material-symbols-outlined"> square </span>
                            <div>
                            <h1>Show</h1>
                            <h2>평점 낮은순</h2>
                            </div>`;
        $(".show__title").append(showTitle);

        $(".show").empty();
        for (let i = 0; i < response.data.length; i++) {
            let ratingContent = '';
            if (response.data[i].rating == null) {
                ratingContent = '<h3>평점이 아직 등록되지 않았습니다.</h3>';
            } else {
                ratingContent = '<h3>평점 : ' + response.data[i].rating + '</h3>';
            }

            let showContent = '<div class="review__content">' +
                '<div>' +
                '<a href="/show/showView/' + response.data[i].id + '"><img src="/images/' + response.data[i].imgRoute + '" width="230" height="300"></a>' +
                '</div>' +
                '<div class="show__content">' +
                '<h2>' + response.data[i].title + '&nbsp;(' + response.data[i].showType + ')</h2>' +
                '<p>' + response.data[i].content + '</p>' +
                ratingContent +
                '</div>' +
                '</div>';

            $(".show").append(showContent);
        }
        $(".page").empty();

      for (let i = 1; i <= response.data[0].count; i++) {
			let page = $("<a>");
			page.attr("href", "/show/rowestRatedShow?currentPage=" + i + "&begin=" + (3 * (i - 1)) + "&range=3");
			$(".page").append(page);

			let tagPageP = $("<p>");
			page.append(tagPageP);

			let value = (i);
			tagPageP.append(value);
		}
		let page1 = $("<a>");
		page1.attr("href", "/show/highesRatedShow?currentPage=" + 1 + "&begin=0&range=3");
		$(".page").append(page1);

		if (response.data[0].count >= 2) {
			let tagPageP1 = $("<p>");
			page1.append(tagPageP1);
			let value1 = (">");
			tagPageP1.append(value1);
		}
		
	}).fail(function(error) {
		alert("현재 상영중인 공연이 없습니다.");
	});
});



});