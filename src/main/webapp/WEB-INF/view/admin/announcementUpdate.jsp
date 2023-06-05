<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="layoutSidenav_content">
	<main>
	<div class="fouc">
		<div class="container-fluid px-4">
			<h1 class="mt-4">Announcement</h1>
			<ol class="breadcrumb mb-4">
			</ol>
			<div class="card mb-4">
				<div class="card-body">Announcement Update</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> Announcement
				</div>
				<div class="card-body">
					<form action="/admin/announcement/update" method="post">
						<p>제목</p>
						<input type="hidden" value="${announcement.id}" name="id" id="id">
						<textarea class="form-control summernote" rows="1" id="title" name="title">${announcement.title}</textarea>
						<br>
						<p>내용</p>
						<textarea class="form-control summernote" rows="5" id="content" name="content">${announcement.content}</textarea>
						<button type="submit" class="btn" style="margin-left: 2000px; margin-top: 10px; border: 1px solid #ccc;">수정</button>
					</form>
				</div>
			</div>
		</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		
		
		
		