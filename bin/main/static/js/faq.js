addPanelQuestion();
$(document).ready(function() {
	$(".faq-type-btn").on("click", function() {
		let categoryId = parseInt($(this).attr("id"));
		$.ajax({
			type: 'get',
			url: '/api/selectFaq/' + categoryId,
			contentType: 'application/json; charset=utf-8',
		}).done(function(data) {
			let response = data.data;
			$(".faq--container").empty();
			let faq = `<section id="faq">`;
			$(".faq--container").append(faq);
			for (let i = 0; i < response.length; i++) {
				var faqcontent = `<div class="panel-question">
					<div class="panel-heading" id="faq-title" onclick="addPanelQuestion()">`+ response[i].title + `<img src="/images/down.png" class="panel-img"></div>
					<div class="panel-body" id="thisone">
					    <p>`+ response[i].content + `</p>
					</div>
					</div>`;
				$("#faq").append(faqcontent);
			}
		}).fail(function(error) {
			console.log(error);
		});
	});


});

$(document).ready(function() {
	$("#faq-all").on("click", function() {
		$.ajax({
			type: 'get',
			url: '/api/faq/',
			contentType: 'application/json; charset=utf-8',
		}).done(function(data) {
			let response = data.data;
			$(".faq--container").empty();
			let faq = `<section id="faq">`;
			$(".faq--container").append(faq);
			for (let i = 0; i < response.length; i++) {
				let faqcontent = `<div class="panel-question">
					<div class="panel-heading" id="faq-title" onclick="addPanelQuestion()">`+ response[i].title + `<img src="/images/down.png" class="panel-img"></div>
					<div class="panel-body" id="thisone">
					    <p>`+ response[i].content + `</p>
					</div>
					</div>`;
				$("#faq").append(faqcontent);
			}
		}).fail(function(error) {
			console.log(error);
		});
	});

});