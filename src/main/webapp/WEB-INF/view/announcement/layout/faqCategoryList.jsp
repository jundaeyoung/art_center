<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="faq--title">
	<div class="category-list-table">
		<div class="faq-type">
			<ul>
				<li class="category-list">
					<button type="submit" class="faq-type-btn" name="category" value="0">전체</button>
				</li>
				<c:forEach var="faqCategoryList" items="${faqCategoryList}">
					<li class="category-list"><a href="/notice/faq/${faqCategoryList.categoryId}" class="faq-type-btn" id="category">${faqCategoryList.category}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>