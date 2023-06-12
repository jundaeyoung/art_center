<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="layoutSidenav_content">
	<main>
	<div class="fouc">
		<div class="container-fluid px-4">
			<h1 class="mt-4">Update</h1>
			<ol class="breadcrumb mb-4">
			</ol>
			<div class="card mb-4">
				<div class="card-body">Update</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i>Update
				</div>
				<div class="card-body">

					<form action="/admin/update" method="post">
						<input type="hidden"  value="${user.roleId}" name="roleId" id="roleId"> <input type="hidden" value="${user.id}" name="id">
						<p>user_name</p>
						<input class="form-control summernote"  value="${user.userName}" name="userName" id="userName"> <br>
						<p>nickname</p>
						<input class="form-control summernote" value="${user.nickname}" name="nickname" id="nickname"> <br>
						<p>email</p>
						<input class="form-control summernote" value="${user.email}" name="email" id="email"> <br>
						<p>birth_date</p>
						<input class="form-control summernote" value="${user.birthDate}" name="birthDate" id="birthDate"> <br>
						<p>tel</p>
						<input class="form-control summernote" value="${user.tel}" name="tel" id="tel"> <br>
						<button type="submit" class="btn" style="margin-left: 2000px; margin-top: 10px; border: 1px solid #ccc;">수정</button>
					</form>
				</div>
			</div>
		</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		