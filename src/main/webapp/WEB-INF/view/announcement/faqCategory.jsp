<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/faq.css">


<div class="main">
	<div class="faq--header">
		<h2>FAQ</h2>
	</div>
	<%@ include file="/WEB-INF/view/announcement/layout/faqCategoryList.jsp"%>
	<div class="faq--container">
		<section id="faq">
			<c:forEach var="faqList" items="${faqList}">
				<div class="panel-question">
					<div class="panel-heading">${faqList.title}</div>
					<div class="panel-body" id="thisone">
						<p>${faqList.content}</p>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>


</div>

<script type="text/javascript" src="/js/faq.js"></script>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>