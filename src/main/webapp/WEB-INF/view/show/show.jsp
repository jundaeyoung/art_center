<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/user/show.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript" src="/js/main.js"></script>





<div class="show__header"></div>

<div class="menu">
	<div>
		<span class="material-symbols-outlined"> <a href="/"><button>home</button></a>
		</span>
	</div>
	<div class="newest">
		<a><button id="show" class="s">공연</button></a>
	</div>
	<div class="highes__rated">
		<a><button id="exhibition">전시회</button> </a>
	</div>
	<div class="lowest__rated">
		<a><button id="academy" >아카데미</button> </a>
	</div>
	<div class="newest">
		<a><button id="newest" >최신순</button></a>
	</div>
	<div class="highes__rated">
		<a><button id="highes__rated" >평점 높은순</button></a>
	</div>
	<div class="lowest__rated" style="border-style: none;">
		<a><button id="lowest__rated" >평점 낮은순</button></a>
	</div>
</div>


<script type="text/javascript">
$(document).ready(function() {
	  var isRequestInProgress = false; // 요청이 진행 중인지를 나타내는 변수

	  $("#show").on("click", function() {
	      $.ajax({
	        	type: 'get',
	        	url: '/apiShow/categoryShow?category=공연&currentPage=1&begin=0&range=3',
	      	    contentType: 'application/json; charset=utf-8',
	      }).done(function(data) {
	    	  let response = data.data;
	    	  $(".show__title").empty();
	    	  let span = $("<span>");
	    	  span.attr("class", "material-symbols-outlined");
	    	  $(".show__title").append(span);
	    	  
	    	  let spanContent = ("square");
	    	  span.append(spanContent);
	    	  
	    	  let div = $("<div>");
	    	  $(".show__title").append(div);
	    	  
	    	  let divH1 = $("<h1>");
	    	  div.append(divH1);
	    	  
	    	  let divH1Content = ("Show");
	    	  divH1.append(divH1Content);
	    	  
	    	  let divH2 = $("<h2>");
	    	  div.append(divH2);
	    	  
	    	  let divH2Content = ("공연")
	    	  divH2.append(divH2Content);
	    	  
	    	  
	    	  
				$(".show").empty(); 
					for(let i = 0; i < response.length; i++) {
						let el = $("<div>");
						el.attr("class", "review__content");
						$(".show").append(el);
						
						let el2 = $("<div>");
						el.append(el2);
						
						let tagA = $("<a>");
						tagA.attr("href", "/show/showView/" + response[i].id);
						el2.append(tagA);
						
						let tagImg = $("<img>");
						tagA.append(tagImg);
						tagImg.attr("src", "/images/upload/" + response[i].imgRoute);
						tagImg.attr("width", "230");
						tagImg.attr("height", "300");
						
						let showcontent = $("<div>");
						showcontent.attr("class", "show__content");
						el.append(showcontent);
						
						let tagH2 = $("<h2>");
						showcontent.append(tagH2);
						
						let tagH2Info = (response[i].title+" ("+response[i].showType+")");
						tagH2.append(tagH2Info);
						
						let tagP = $("<p>");
						showcontent.append(tagP);
						
						let tagPInfo = (response[i].content)
						tagP.append(tagPInfo);
						
						let tagH3 = $("<h3>");
						showcontent.append(tagH3);
						
						let tagH3Info="";
						if(response[i].rating==null){
							tagH3Info="평점이 아직 등록되지 않았습니다.";
						}else{
							tagH3Info = ("평점 : " +response[i].rating);
						}
						tagH3.append(tagH3Info);
					}
					$(".page").empty(); 
					
					
					for(let i = 1; i <= response.length/3 ; i++) {
						let page=$("<a>");
						page.attr("href","/show/categoryShow?category=공연&currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
						$(".page").append(page);
						
						let tagPageP=$("<p>");
						page.append(tagPageP);
						
						let value = (i);
						tagPageP.append(value);
					}
					let page1=$("<a>");
					page1.attr("href","/show/categoryShow?category=공연&currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
					$(".page").append(page1);
					
					if(response[0].count >= 2){
						let tagPageP1=$("<p>");
						page1.append(tagPageP1);
						let value1 = (">");
						tagPageP1.append(value1);
	      			}
			}).fail(function(error) {
				alert("현재 상영중인 공연이 없습니다.");
			}); 
		});
	  
	  $("#exhibition").on("click", function() {
	      $.ajax({
	        	type: 'get',
	        	url: '/apiShow/categoryShow?category=전시회&currentPage=1&begin=0&range=3',
	      	    contentType: 'application/json; charset=utf-8',
	      }).done(function(data) {
	    	  let response = data.data;
	    	  $(".show__title").empty();
	    	  let span = $("<span>");
	    	  span.attr("class", "material-symbols-outlined");
	    	  $(".show__title").append(span);
	    	  
	    	  let spanContent = ("square");
	    	  span.append(spanContent);
	    	  
	    	  let div = $("<div>");
	    	  $(".show__title").append(div);
	    	  
	    	  let divH1 = $("<h1>");
	    	  div.append(divH1);
	    	  
	    	  let divH1Content = ("Show");
	    	  divH1.append(divH1Content);
	    	  
	    	  let divH2 = $("<h2>");
	    	  div.append(divH2);
	    	  
	    	  let divH2Content = ("전시회")
	    	  divH2.append(divH2Content);
	    	  
	    	  
	    	  
				$(".show").empty(); 
					for(let i = 0; i < response.length; i++) {
						let el = $("<div>");
						el.attr("class", "review__content");
						$(".show").append(el);
						
						let el2 = $("<div>");
						el.append(el2);
						
						let tagA = $("<a>");
						tagA.attr("href", "/show/showView/" + response[i].id);
						el2.append(tagA);
						
						let tagImg = $("<img>");
						tagA.append(tagImg);
						tagImg.attr("src", "/images/upload/" + response[i].imgRoute);
						tagImg.attr("width", "230");
						tagImg.attr("height", "300");
						
						let showcontent = $("<div>");
						showcontent.attr("class", "show__content");
						el.append(showcontent);
						
						let tagH2 = $("<h2>");
						showcontent.append(tagH2);
						
						let tagH2Info = (response[i].title+" ("+response[i].showType+")");
						tagH2.append(tagH2Info);
						
						let tagP = $("<p>");
						showcontent.append(tagP);
						
						let tagPInfo = (response[i].content)
						tagP.append(tagPInfo);
						
						let tagH3 = $("<h3>");
						showcontent.append(tagH3);
						
						let tagH3Info="";
						if(response[i].rating==null){
							tagH3Info="평점이 아직 등록되지 않았습니다.";
						}else{
							tagH3Info = ("평점 : " +response[i].rating);
						}
						tagH3.append(tagH3Info);
					}
					$(".page").empty(); 
					
					
					for(let i = 1; i <= response.length/3 ; i++) {
						let page=$("<a>");
						page.attr("href","/show/categoryShow?category=전시회&currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
						$(".page").append(page);
						
						let tagPageP=$("<p>");
						page.append(tagPageP);
						
						let value = (i);
						tagPageP.append(value);
					}
					let page1=$("<a>");
					page1.attr("href","/show/categoryShow?category=전시회&currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
					$(".page").append(page1);
					
					if(response[0].count >= 2){
						let tagPageP1=$("<p>");
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
	      }).done(function(data) {
	    	  
	    	  let response = data.data;
	    	  $(".show__title").empty();
	    	  let span = $("<span>");
	    	  span.attr("class", "material-symbols-outlined");
	    	  $(".show__title").append(span);
	    	  
	    	  let spanContent = ("square");
	    	  span.append(spanContent);
	    	  
	    	  let div = $("<div>");
	    	  $(".show__title").append(div);
	    	  
	    	  let divH1 = $("<h1>");
	    	  div.append(divH1);
	    	  
	    	  let divH1Content = ("Show");
	    	  divH1.append(divH1Content);
	    	  
	    	  let divH2 = $("<h2>");
	    	  div.append(divH2);
	    	  
	    	  let divH2Content = ("아카데미")
	    	  divH2.append(divH2Content);
	    	  
				$(".show").empty(); 
					for(let i = 0; i < response.length; i++) {
						let el = $("<div>");
						el.attr("class", "review__content");
						$(".show").append(el);
						
						let el2 = $("<div>");
						el.append(el2);
						
						let tagA = $("<a>");
						tagA.attr("href", "/show/showView/" + response[i].id);
						el2.append(tagA);
						
						let tagImg = $("<img>");
						tagA.append(tagImg);
						tagImg.attr("src", "/images/upload/" + response[i].imgRoute);
						tagImg.attr("width", "230");
						tagImg.attr("height", "300");
						
						let showcontent = $("<div>");
						showcontent.attr("class", "show__content");
						el.append(showcontent);
						
						let tagH2 = $("<h2>");
						showcontent.append(tagH2);
						
						let tagH2Info = (response[i].title+" ("+response[i].showType+")");
						tagH2.append(tagH2Info);
						
						let tagP = $("<p>");
						showcontent.append(tagP);
						
						let tagPInfo = (response[i].content)
						tagP.append(tagPInfo);
						
						let tagH3 = $("<h3>");
						showcontent.append(tagH3);
						
						let tagH3Info="";
						if(response[i].rating==null){
							tagH3Info="평점이 아직 등록되지 않았습니다.";
						}else{
							tagH3Info = ("평점 : " +response[i].rating);
						}
						tagH3.append(tagH3Info);
					}
					$(".page").empty(); 
					
					
					for(let i = 1; i <= response[0].count ; i++) {
						let page=$("<a>");
						page.attr("href","/show/categoryShow?category=아카데미&currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
						$(".page").append(page);
						
						let tagPageP=$("<p>");
						page.append(tagPageP);
						
						let value = (i);
						tagPageP.append(value);
					}
					let page1=$("<a>");
					page1.attr("href","/show/categoryShow?category=아카데미&currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
					$(".page").append(page1);
					
					if(response[0].count >= 2){
						let tagPageP1=$("<p>");
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
	      }).done(function(data) {
	    	  let response = data.data;
	    	  $(".show__title").empty();
	    	  let span = $("<span>");
	    	  span.attr("class", "material-symbols-outlined");
	    	  $(".show__title").append(span);
	    	  
	    	  let spanContent = ("square");
	    	  span.append(spanContent);
	    	  
	    	  let div = $("<div>");
	    	  $(".show__title").append(div);
	    	  
	    	  let divH1 = $("<h1>");
	    	  div.append(divH1);
	    	  
	    	  let divH1Content = ("Show");
	    	  divH1.append(divH1Content);
	    	  
	    	  let divH2 = $("<h2>");
	    	  div.append(divH2);
	    	  
	    	  let divH2Content = ("최신순")
	    	  divH2.append(divH2Content);
	    	  
	    	  
	    	  
				$(".show").empty(); 
					for(let i = 0; i < response.length; i++) {
						let el = $("<div>");
						el.attr("class", "review__content");
						$(".show").append(el);
						
						let el2 = $("<div>");
						el.append(el2);
						
						let tagA = $("<a>");
						tagA.attr("href", "/show/showView/" + response[i].id);
						el2.append(tagA);
						
						let tagImg = $("<img>");
						tagA.append(tagImg);
						tagImg.attr("src", "/images/upload/" + response[i].imgRoute);
						tagImg.attr("width", "230");
						tagImg.attr("height", "300");
						
						let showcontent = $("<div>");
						showcontent.attr("class", "show__content");
						el.append(showcontent);
						
						let tagH2 = $("<h2>");
						showcontent.append(tagH2);
						
						let tagH2Info = (response[i].title+" ("+response[i].showType+")");
						tagH2.append(tagH2Info);
						
						let tagP = $("<p>");
						showcontent.append(tagP);
						
						let tagPInfo = (response[i].content)
						tagP.append(tagPInfo);
						
						let tagH3 = $("<h3>");
						showcontent.append(tagH3);
						
						let tagH3Info="";
						if(response[i].rating==null){
							tagH3Info="평점이 아직 등록되지 않았습니다.";
						}else{
							tagH3Info = ("평점 : " +response[i].rating);
						}
						tagH3.append(tagH3Info);
					}
					$(".page").empty(); 
					
					
					for(let i = 1; i <= response[0].count ; i++) {
						let page=$("<a>");
						page.attr("href","/show/newestShow?currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
						$(".page").append(page);
						
						let tagPageP=$("<p>");
						page.append(tagPageP);
						
						let value = (i);
						tagPageP.append(value);
					}
					let page1=$("<a>");
					page1.attr("href","/show/newestShow?currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
					$(".page").append(page1);
					
					if(response[0].count >= 2){
						let tagPageP1=$("<p>");
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
			      }).done(function(data) {
			    	  let response = data.data;
			    	  $(".show__title").empty();
			    	  let span = $("<span>");
			    	  span.attr("class", "material-symbols-outlined");
			    	  $(".show__title").append(span);
			    	  
			    	  let spanContent = ("square");
			    	  span.append(spanContent);
			    	  
			    	  let div = $("<div>");
			    	  $(".show__title").append(div);
			    	  
			    	  let divH1 = $("<h1>");
			    	  div.append(divH1);
			    	  
			    	  let divH1Content = ("Show");
			    	  divH1.append(divH1Content);
			    	  
			    	  let divH2 = $("<h2>");
			    	  div.append(divH2);
			    	  
			    	  let divH2Content = ("평점높은순")
			    	  divH2.append(divH2Content);
			    	  
			    	  
			    	  $(".show").empty(); 
						for(let i = 0; i < response.length; i++) {
							let el = $("<div>");
							el.attr("class", "review__content");
							$(".show").append(el);
							
							let el2 = $("<div>");
							el.append(el2);
							
							let tagA = $("<a>");
							tagA.attr("href", "/show/showView/" + response[i].id);
							el2.append(tagA);
							
							let tagImg = $("<img>");
							tagA.append(tagImg);
							tagImg.attr("src", "/images/upload/" + response[i].imgRoute);
							tagImg.attr("width", "230");
							tagImg.attr("height", "300");
							
							let showcontent = $("<div>");
							showcontent.attr("class", "show__content");
							el.append(showcontent);
							
							let tagH2 = $("<h2>");
							showcontent.append(tagH2);
							
							let tagH2Info = (response[i].title+" ("+response[i].showType+")");
							tagH2.append(tagH2Info);
							
							let tagP = $("<p>");
							showcontent.append(tagP);
							
							let tagPInfo = (response[i].content)
							tagP.append(tagPInfo);
							
							let tagH3 = $("<h3>");
							showcontent.append(tagH3);
							
							let tagH3Info = ("평점 : " + (response[i].rating).toFixed(1));
							tagH3.append(tagH3Info);
						}
							$(".page").empty(); 
							
							
						for(let i = 1; i <= response[0].count ; i++) {
							let page=$("<a>");
							page.attr("href","/show/highesRatedShow?currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
							$(".page").append(page);
							
							let tagPageP=$("<p>");
							page.append(tagPageP);
							
							let value = (i);
							tagPageP.append(value);
						}
						let page1=$("<a>");
						page1.attr("href","/show/highesRatedShow?currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
						$(".page").append(page1);
						
						if(response[0].count >= 2){
							let tagPageP1=$("<p>");
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
			      }).done(function(data) {
			    	  let response = data.data;
			    	  $(".show__title").empty();
			    	  let span = $("<span>");
			    	  span.attr("class", "material-symbols-outlined");
			    	  $(".show__title").append(span);
			    	  
			    	  let spanContent = ("square");
			    	  span.append(spanContent);
			    	  
			    	  let div = $("<div>");
			    	  $(".show__title").append(div);
			    	  
			    	  let divH1 = $("<h1>");
			    	  div.append(divH1);
			    	  
			    	  let divH1Content = ("Show");
			    	  divH1.append(divH1Content);
			    	  
			    	  let divH2 = $("<h2>");
			    	  div.append(divH2);
			    	  
			    	  let divH2Content = ("평점낮은순")
			    	  divH2.append(divH2Content);
			    	  
			    	  
						$(".show").empty(); 
							for(let i = 0; i < response.length; i++) {
								let el = $("<div>");
								el.attr("class", "review__content");
								$(".show").append(el);
								
								let el2 = $("<div>");
								el.append(el2);
								
								let tagA = $("<a>");
								tagA.attr("href", "/show/showView/" + response[i].id);
								el2.append(tagA);
								
								let tagImg = $("<img>");
								tagA.append(tagImg);
								tagImg.attr("src", "/images/upload/" + response[i].imgRoute);
								tagImg.attr("width", "230");
								tagImg.attr("height", "300");
								
								let showcontent = $("<div>");
								showcontent.attr("class", "show__content");
								el.append(showcontent);
								
								let tagH2 = $("<h2>");
								showcontent.append(tagH2);
								
								let tagH2Info = (response[i].title+" ("+response[i].showType+")");
								tagH2.append(tagH2Info);
								
								let tagP = $("<p>");
								showcontent.append(tagP);
								
								let tagPInfo = (response[i].content)
								tagP.append(tagPInfo);
								
								let tagH3 = $("<h3>");
								showcontent.append(tagH3);
								
								let tagH3Info = ("평점 : " + (response[i].rating).toFixed(1));
								tagH3.append(tagH3Info);
							}
								$(".page").empty(); 
								
								
							for(let i = 1; i <= response[0].count ; i++) {
								let page=$("<a>");
								page.attr("href","/show/rowestRatedShow?currentPage="+i+"&begin="+(3*(i-1))+"&range=3");
								$(".page").append(page);
								
								let tagPageP=$("<p>");
								page.append(tagPageP);
								
								let value = (i);
								tagPageP.append(value);
							}
							let page1=$("<a>");
							page1.attr("href","/show/rowestRatedShow?currentPage="+(response.length-1)+"&begin="+3*(response.length-2)+"&range=3");
							$(".page").append(page1);
							
							if(response[0].count >= 2){
								let tagPageP1=$("<p>");
								page1.append(tagPageP1);
								let value1 = (">");
								tagPageP1.append(value1);
			      			}
					}).fail(function(error) {
						alert("현재 상영중인 공연이 없습니다.");
					}); 
				});
				});
	</script>

<div class="show__title">
	<span class="material-symbols-outlined"> square </span>
	<div>
		<h1>Show</h1>
		<h2>${message}</h2>
	</div>
</div>
<div class="show">
	<c:forEach var="showList" items="${showList}">
		<div class="review__content">
			<div>
				<a href="/show/showView/${showList.id}"><img src="/images/upload/${showList.imgRoute}" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>${showList.title}&nbsp;(${showList.showType})</h2>
				<p>${showList.content}</p>
				<c:choose>
					<c:when test="${showList.rating==null}">
						<h3>평점이 아직 등록되지 않았습니다.</h3>
					</c:when>
					<c:otherwise>
						<h3>평점 : ${showList.rating}</h3>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:forEach>
</div>
<div class="page">
	<c:choose>
		<c:when test="${message eq '최신순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/newestShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/show/newestShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/newestReview?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${message eq '평점높은순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/highesRatedShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/show/highesRatedShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/highesRatedShow?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${message eq '평점낮은순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/rowestRatedShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/show/rowestRatedShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/rowestRatedShow?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/categoryShow?category=${message}&currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/show/categoryShow?category=${message}&currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/categoryShow?category=${message}&currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>


	</c:choose>


</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


