<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/announcement.css">

<script type="text/javascript" src="/js/main.js"></script>

<div class="question__header"></div>
<div class="question__title">
	<div>
		<span class="material-symbols-outlined"> square </span>
		<c:choose>
			<c:when test="${announcements==null}">
				<c:choose>
					<c:when test="${searchText==''}">
						<div>
							<h2>공지사항</h2>
						</div>
					</c:when>
					<c:otherwise>
						<h2>${searchText}&nbsp을(를)&nbsp검색한&nbsp결과입니다.</h2>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<div>
					<h2>공지사항</h2>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div></div>
</div>
<div class="answer__write" id="answer__write">
	<form action="/quest/insert" method="post">
		<div class="form-group bg-white" style="width: 1000px; margin-bottom: 50px;">
			<div class="question__type">
				<div>
					<input type="text" placeholder="제목" name="title" style="width: 400px; font-size: 20px; height: 30px; margin-bottom: 10px;">
				</div>
				<div class="question__category__info">
					<input type="hidden" name="userId" value="${principal.getId()}"> <input type="hidden" name="currentPage" value="1"> <input type="hidden" name="begin" value="0"> <input
						type="hidden" name="range" value="5"> <input type="hidden" name=searchText value=""> <input type="checkbox" name="questionTypeId" value="1" id="안내"><label for="안내">안내</label>
					<input type="checkbox" name="questionTypeId" value="2" id="대관"><label for="대관">대관</label> <input type="checkbox" name="questionTypeId" value="3" id="아카데미"><label for="아카데미">아카데미</label>
					<input type="checkbox" name="questionTypeId" value="4" id="모집"><label for="모집">모집</label>
				</div>
			</div>
			<textarea class="form-control summernote" rows="5" id="content" name="content" placeholder="내용"></textarea>
		</div>
		<button type="submit" class="submit" style="margin-left: 30px;">작&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp성</button>
	</form>
</div>
<div class="search" id="hide__search__box">
	<form action="/quest/search" method="get">
		<input type="text" class="textbox" name="searchText"> <input type="hidden" name="currentPage" value="1"> <input type="hidden" name="begin" value="0"> <input type="hidden"
			name="range" value="5"> <input type="submit" class="submit" value="검&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp색">
	</form>
</div>

	<form action="/announcement/update?id=${announcement.id}" method="post">
		<div class="question">
			<div class="question__content">
				<div>
					<div class="show__content">
						<div class="updateTitle">
							<input type="text" value="${announcement.title}" name="title">
						</div>
						<div class="question__content_show">
							<div class="updateContent">
								<input type="text" value="${announcement.content}" name="content">
							</div>
							<button class="update--btn">수정</button>
							<div class="delete"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</form>
<div class="page">
	<c:choose>
		<c:when test="${searchText!=null}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/quest/search?searchText=${searchText}&currentPage=1&begin=${5*(1-1)}&range=5"><p><<</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/quest/search?searchText=${searchText}&currentPage=${i}&begin=${5*(i-1)}&range=5"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page}">
				</c:when>
				<c:otherwise>
					<a href="/quest/search?searchText=${searchText}&currentPage=${page}&type=${type}&begin=${5*(page-1)}&range=5"><p>>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/quest/info?category=${category}&currentPage=1&begin=${5*(1-1)}&range=5"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/quest/info?category=${category}&currentPage=${i}&begin=${5*(i-1)}&range=5"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/quest/info?category=${category}&currentPage=${page}&type=${type}&begin=${5*(page-1)}&range=5"><p>></p></a>
				</c:otherwise>
			</c:choose>

		</c:otherwise>
	</c:choose>

</div>





<script>
	$(document).ready(function() {
		$('.hide').toggle();
		$('[id^="show_"]').each(function() {
			let id = $(this).attr("id");
			let num = id.split("_")[1];
			$(this).click(function() {
				$("#hide_" + num).toggle();
			});
		});

	});
	$(document).ready(function() {
		$('#answer__write').toggle();
		$('#show__write').each(function() {
			$(this).click(function() {
				$('#answer__write').toggle();
				$('#hide__search__box').toggle();
			});
		});
	});
	$('.summernote').summernote({
		tabsize : 2,
		height : 400
	});

	$(document)
			.ready(
					function() {
						$('input[type="checkbox"][name="questionTypeId"]')
								.click(
										function() {
											if ($(this).prop('checked')) {
												$(
														'input[type="checkbox"][name="questionTypeId"]')
														.prop('checked', false);
												$(this).prop('checked', true);
											}
										});
					});
</script>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>