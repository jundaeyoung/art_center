<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="layoutSidenav_content">
	<main>
	<div class="fouc">
		<div class="container-fluid px-4">
			<h1 class="mt-4">Answer</h1>
			<ol class="breadcrumb mb-4">
			</ol>
			<div class="card mb-4">
				<div class="card-body">
					Question에 답글을 달아주세요.
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i>Question
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>제목</th>
								<th>내용</th>
								<th>카테고리</th>
								<th>답변상태</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>${questionList.title}</th>
								<th>${questionList.content}</th>
								<th>${questionList.questionType}</th>
								<c:choose>
									<c:when test="${questionList.answerStatus==1}">
										<th>답변완료</th>
									</c:when>
									<c:otherwise>
										<th>답변 미완료</th>
									</c:otherwise>
								</c:choose>
							</tr>
						</tbody>
					</table>
					<div>
						<c:choose>
							<c:when test="${questionList.answerStatus==1}">
								<form action="/admin/answer/update/${questionList.id}">
									<textarea class="form-control summernote" rows="5" id="content" name="content">${answer.content}</textarea>
									<button type="submit" class="btn" style="margin-left: 2000px; margin-top: 10px; border: 1px solid #ccc;">수정하기</button>
								</form>
							</c:when>
							<c:otherwise>
								<form action="/admin/answer/create" method="post">
									<textarea class="form-control summernote" rows="5" id="content" name="content">${answer.content}</textarea>
									<input type="hidden" name="userId" value="${principal.id}">
									<input type="hidden" name="questionId" value="${questionList.id}">
									<button type="submit" class="btn" style="margin-left: 2000px; margin-top: 10px; border: 1px solid #ccc;">답변달기</button>
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		