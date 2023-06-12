<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/notice.css">


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
						<h2>${searchText}&nbsp;을(를)&nbsp;검색한&nbsp;결과입니다.</h2>
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
<div class="search" id="hide__search__box">
	<form action="/announcement/search" method="post">
		<input type="text" class="textbox" name="searchText"> <input type="submit" class="submit" value="검&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp색">
	</form>
</div>
<c:if test="${crud.equals(\"select\") }">
	<div class="question">
		<c:forEach var="announcements" items="${announcements}">
			<div class="question__content">
				<div>
					<div class="show__content">
						<div class="show">
							${announcements.title}<img src="/images/down.png" class="panel-img">
						</div>
						<div class="question__content_show">
								<p>${announcements.content}</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</c:if>

<script type="text/javascript" src="/js/noticeToggle.js"></script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>



