<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="layoutSidenav_content">
	<main>
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
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>user_name</th>
								<th>nickname</th>
								<th>email</th>
								<th>birth_date</th>
								<th>tel</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<form action="/admin/update" method="post">
									<input type="hidden" value="${user.roleId}" name="roleId" id="roleId"> 
									<input type="hidden" value="${user.id}" name="id"> 
								<td><input type="text"value="${user.userName}" name="userName" id="userName"></td>
								<td><input type="text" value="${user.nickname}" name="nickname" id="nickname"></td>
								<td><input type="text" value="${user.email}" name="email" id="email"></td>
								<td><input type="text" value="${user.birthDate}" name="birthDate" id="birthDate"></td>
								<td><input type="text" value="${user.tel}" name="tel" id="tel"></td>
								<td><button class="btn">수정</button></td>
								</form>
								<td>
									<form action="/admin/deleteUser?userName=${user.userName}" method="post">
										<button class="btn">삭제</button>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		
		