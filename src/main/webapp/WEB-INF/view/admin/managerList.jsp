<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="layoutSidenav_content">
	<main>
	<div class="fouc">
		<div class="container-fluid px-4">
			<h1 class="mt-4">Manager</h1>
			<ol class="breadcrumb mb-4">
			</ol>
			<div class="card mb-4">
				<div class="card-body">ManagerList</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> ManagerList
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
							<c:forEach var="managerList" items="${managerList}">
								<tr>
									<td>${managerList.userName}</td>
									<td>${managerList.nickname}</td>
									<td>${managerList.email}</td>
									<td>${managerList.birthDate}</td>
									<td>${managerList.tel}</td>
									<td><a href="/admin/updateUser/${managerList.userName}">수정</a></td>
									<td><a href="/admin/deleteManager/${managerList.id}">삭제</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		
		
		
		