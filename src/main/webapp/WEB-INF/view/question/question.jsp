<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/question.css">

<div class="question__header"></div>

<div class="menu">
	<div>
		<span class="material-symbols-outlined"> <a href="/">home</a>
		</span>
	</div>
	<div class="newest">
		<a href="/quest/info?category=안내&currentPage=1&begin=0&range=10">안내</a>
	</div>
	<div class="newest">
		<a href="/quest/info?category=대관&currentPage=1&begin=0&range=10">대관</a>
	</div>
	<div class="newest">
		<a href="/quest/info?category=아카데미&currentPage=1&begin=0&range=10">아카데미</a>
	</div>
	<div class="newest">
		<a href="/quest/info?category=모집&currentPage=1&begin=0&range=10">모집</a>
	</div>
</div>
<div class="question__title">
	<div>
		<span class="material-symbols-outlined"> square </span>
		<c:choose>
			<c:when test="${category==null}">
				<h2>${searchText}을검색한 결과 입니다.</h2>
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
				<form action="" method="get" class="question__btn">
					<button type="submit">질문하기</button>
				</form>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="search">
	<form action="/quest/search" method="get">
		<input type="text" class="textbox" name="searchText"> <input
			type="hidden" name="currentPage" value="1"> <input
			type="hidden" name="begin" value="0"> <input type="hidden"
			name="range" value="10"> <input type="submit" class="submit"
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
								</c:when>
								<c:otherwise>
									<div class="answer_status">답변미완료</div>
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
						<div class="show">
							<span class="material-symbols-outlined">expand_more</span>
						</div>
					</div>
				</div>
				<div id="hide">
					<h4>${questionList.content}</h4>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<div class="page">
	<c:choose>
		<c:when test="${currentPage==1 || currentPage==null}">
		</c:when>
		<c:otherwise>
			<a href="/review/newestReview?currentPage=1&begin=${3*(1-1)}&range=3"><p><<</p></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${currentPage==null}">
		</c:when>
		<c:otherwise>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a
					href="/review/newestReview?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${currentPage==page}">
		</c:when>
		<c:otherwise>
			<a
				href="/review/newestReview?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>>></p></a>
		</c:otherwise>
	</c:choose>
</div>


<script>
	$(document).ready(function() {
		$('#hide').toggle();
		$('.show').each(function() {
			$(this).click(function() {
				$('#hide').toggle();
			});
		});
	});
</script>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
