<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/faq.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<div class="faq__header"></div>
<div class="faq--title">
	<div class="category-list-table">
		<div class="faq-type">
			<ul>
				<li class="category-list">
					<button type="button" class="faq-type-btn" id="faq-all"
						name="category" value="0">전체</button>

				</li>
				<c:forEach var="faqCategoryList" items="${faqCategoryList}">
					<li class="category-list">
						<button type="button" class="faq-type-btn"
							id="${faqCategoryList.categoryId}">${faqCategoryList.category}</button>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
<div class="main">
	<div class="material-title">
		<span class="material-symbols-outlined"> square </span>
		<div class="faq--header">
			<h2>FAQ</h2>
		</div>
	</div>
	<div class="faq--container">
		<section id="faq">
			<c:forEach var="faqList" items="${faqList}">
				<div class="panel-question">
					<div class="panel-heading" id="faq-title">${faqList.title}<img src="/images/down.png" class="panel-img"></div>
					<div class="panel-body" id="thisone">
						<p>${faqList.content}</p>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>


</div>
<script>
function addPanelQuestion(){
	let panelQuestion = document.querySelectorAll('.panel-question');

	for (let pq of panelQuestion) {
	  pq.addEventListener('click', function () {
	    if (this.classList.contains('active')) {
	      this.classList.remove('active');
	    } else {
	      hideAll();
	      this.classList.add('active');
	    }
	  });
	}

	function hideAll() {
	  for (let q of panelQuestion) {
	    q.classList.remove('active');
	  }
	}

 }
</script>

<script type="text/javascript">
	  
addPanelQuestion();
$(document).ready(function () {
    $(".faq-type-btn").on("click", function () {
        let categoryId = parseInt($(this).attr("id"));
        $.ajax({
            type: 'get',
            url: '/api/selectFaq/' + categoryId,
            contentType: 'application/json; charset=utf-8',
        }).done(function (response) {
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
        }).fail(function (error) {
            console.log(error);
        });
  });

    
});

$(document).ready(function () {
    $("#faq-all").on("click", function () {
        $.ajax({
            type: 'get',
            url: '/api/faq/',
            contentType: 'application/json; charset=utf-8',
        }).done(function (response) {
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
        }).fail(function (error) {
            console.log(error);
        });
  });
    
});
</script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
