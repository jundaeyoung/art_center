<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Announcement</h1>
			<ol class="breadcrumb mb-4">
			</ol>
			<div class="card mb-4">
				<div class="card-body">AnnouncementList</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i>AnnouncementList
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>제목</th>
								<th>내용</th>
								<th>작성날짜</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="announcements" items="${announcements}">
								<tr>
									<td>${announcements.title}</td>
									<td>${announcements.content}</td>
									<td>${announcements.createdDate}</td>
									<td><a href="/admin/announcement/detail?id=${announcements.id}">수정</a></td>
									<td><a href="/admin/announcement/delete?id=${announcements.id}">삭제</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<form action="/admin/announcement/board" method="get">
						<button type="submit" class="btn" style="margin-left: 2000px; margin-top: 10px; border: 1px solid #ccc;">글쓰기</button>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		
		
		
		