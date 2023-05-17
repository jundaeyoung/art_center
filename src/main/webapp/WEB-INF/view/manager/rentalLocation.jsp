<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.content {
	width: 100%;
	height: 800px;
	margin-top: 100px;
}
</style>
<div class="content">
<div class="title">
		<h1>여기는 ${location} 대관페이지 입니다.</h1>
</div>
</div>
<script>
$(document).ready(function() {
	$(".main>li").mouseover(function() {
		$(this).children(".sub").stop().slideDown(200);
	});
	$(".main>li").mouseleave(function() {
		$(this).children(".sub").stop().slideUp(200);
	});
});
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>