<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/faq.css">

<div class="main">
	<div class="faq--header"></div>
	<div class="faq--title">
		<div class="category-list-table">
			<table class="faq-type">
				<tr>
					<td class="category-list">
						<button type="submit" class="show-type-btn" name="category" value="0">전체</button>
					</td>
					<c:forEach var="faqCategoryList" items="${faqCategoryList}">
						<td class="category-list">
							<button type="submit" class="show-type-btn" name="category" value="${faqCategoryList.categoryId}">${faqCategoryList.category}</button>
						</td>

					</c:forEach>
				</tr>
			</table>
		</div>
	</div>

</div>





<%@ include file="/WEB-INF/view/layout/footer.jsp"%>