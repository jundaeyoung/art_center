<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/question.css">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<div class="question__header"></div>

<div class="menu">
	<div>
		<span class="material-symbols-outlined"> <a href="/">home</a>
		</span>
	</div>
	<div class="newest">
		<a href="/quest/info?category=안내&currentPage=1&begin=0&range=5">안내</a>
	</div>
	<div class="newest">
		<a href="/quest/info?category=대관&currentPage=1&begin=0&range=5">대관</a>
	</div>
	<div class="newest">
		<a href="/quest/info?category=아카데미&currentPage=1&begin=0&range=5">아카데미</a>
	</div>
	<div class="newest">
		<a href="/quest/info?category=모집&currentPage=1&begin=0&range=5">모집</a>
	</div>
</div>
<div class="question__title">
	<div>
		<span class="material-symbols-outlined"> square </span>
		<c:choose>
			<c:when test="${category==null}">
				<c:choose>
					<c:when test="${searchText==''}">
						<div>
							<h2>QnA</h2>
							<h1>전 체</h1>
						</div>
					</c:when>
					<c:otherwise>
						<h2>${searchText}&nbsp을(를)&nbsp검색한&nbsp결과입니다.</h2>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<div>
					<h2>QnA</h2>
					<h1>${category}</h1>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<c:choose>
			<c:when test="${principal.getRoleId()==1}">
				<div id=show__write>
					<button type="submit">질문하기</button>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="answer__write" id="answer__write">
	<form action="/quest/insert" method="post">
		<div class="form-group bg-white"
			style="width: 1000px; margin-bottom: 50px;">
			<div class="question__type">
				<div>
					<input type="text" placeholder="제목" name="title"
						style="width: 400px; font-size: 20px; height: 30px; margin-bottom: 10px;">
				</div>
				<div class="question__category__info">
					<input type="hidden" name="userId" value="${principal.getId()}">
					<input type="hidden" name="currentPage" value="1"> <input
						type="hidden" name="begin" value="0"> <input type="hidden"
						name="range" value="5"> <input type="hidden"
						name=searchText value=""> <input type="checkbox"
						name="questionTypeId" value="1" id="안내"><label for="안내">안내</label>
					<input type="checkbox" name="questionTypeId" value="2" id="대관"><label
						for="대관">대관</label> <input type="checkbox" name="questionTypeId"
						value="3" id="아카데미"><label for="아카데미">아카데미</label> <input
						type="checkbox" name="questionTypeId" value="4" id="모집"><label
						for="모집">모집</label>
				</div>
			</div>
			<textarea class="form-control summernote" rows="5" id="content"
				name="content" placeholder="내용"></textarea>
		</div>
		<button type="submit" class="submit" style="margin-left: 30px;">작&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp성</button>
	</form>
</div>
<div class="search" id="hide__search__box">
	<form action="/quest/search" method="get">
		<input type="text" class="textbox" name="searchText"> <input
			type="hidden" name="currentPage" value="1"> <input
			type="hidden" name="begin" value="0"> <input type="hidden"
			name="range" value="5"> <input type="submit" class="submit"
			value="검&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp색">
	</form>
</div>

<div class="question">
	<c:forEach var="questionList" items="${questionList}">
		<div class="question__content">
			<div>
				<div class="show__content">
					<div class="question__category">
						<h2>${questionList.questionType}</h2>
					</div>
					<div class="question__content_show">
						<div class="show">
							<h2>${questionList.title}</h2>
						</div>
						<div class="answer">
							<c:choose>
								<c:when test="${questionList.answerStatus==1}">
									<div class="answer_status">답변완료</div>
									<div>
										<c:choose>
											<c:when test="${questionList.userId==principal.getId()}">
												<form action="" method="get">
													<button type="submit">삭제</button>
												</form>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</div>
								</c:when>
								<c:otherwise>
									<div class="answer_status">답변미완료</div>
									<div class="delete">
										<c:choose>
											<c:when test="${questionList.userId==principal.getId()}">
												<form action="/quest/delete" method="get">
												<input type="hidden"name="id" value="${questionList.id}">
													<button type="submit" >삭제</button>
												</form>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when
									test="${questionList.answerStatus==0 && principal.getRoleId()==4}">
									<div>
										<form action="" method="get" class="answer__btn">
											<button type="submit">답변달기</button>
										</form>
									</div>
								</c:when>
							</c:choose>
						</div>
						<div class="show" id="show_${questionList.id}">
							<span class="material-symbols-outlined">expand_more</span>
						</div>
					</div>
				</div>
				<div class="hide" id="hide_${questionList.id}">
					<h4>${questionList.content}</h4>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<div class="page">
	<c:choose>
		<c:when test="${searchText!=null}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/quest/search?searchText=${searchText}&currentPage=1&begin=${5*(1-1)}&range=5"><p><<</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a
							href="/quest/search?searchText=${searchText}&currentPage=${i}&begin=${5*(i-1)}&range=5"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page}">
				</c:when>
				<c:otherwise>
					<a
						href="/quest/search?searchText=${searchText}&currentPage=${page}&type=${type}&begin=${5*(page-1)}&range=5"><p>>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/quest/info?category=${category}&currentPage=1&begin=${5*(1-1)}&range=5"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a
							href="/quest/info?category=${category}&currentPage=${i}&begin=${5*(i-1)}&range=5"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/quest/info?category=${category}&currentPage=${page}&type=${type}&begin=${5*(page-1)}&range=5"><p>></p></a>
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
