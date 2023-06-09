<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/faq.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<div class="faq__header"></div>
<div class="faq--title">
	<div class="category-list-table">
		<div class="faq-type">
			<ul>
				<li class="category-list">
					<button type="button" class="faq-type-btn" id="faq-all" name="category" value="0">전체</button>

				</li>
				<c:forEach var="faqCategoryList" items="${faqCategoryList}">
					<li class="category-list">
						<button type="button" class="faq-type-btn" id="${faqCategoryList.categoryId}">${faqCategoryList.category}</button>
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
					<div class="panel-heading" id="faq-title">${faqList.title}<img src="/images/down.png" class="panel-img">
					</div>
					<div class="panel-body" id="thisone">
						<p>${faqList.content}</p>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>


</div>
<script type="text/javascript" src="/js/faqTogle.js"></script>

<script type="text/javascript" src="/js/faq.js"></script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


