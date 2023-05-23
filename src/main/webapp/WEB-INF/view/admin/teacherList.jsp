<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Tables</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
						<li class="breadcrumb-item active">Tables</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">
							DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net/">official
								DataTables documentation</a> .
						</div>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> DataTable Example
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
                                        <c:forEach var="teacherList" items="${teacherList}">
                                        <tr>
                                        <td>${teacherList.userName}</td>
                                        <td>${teacherList.nickname}</td>
                                        <td>${teacherList.email}</td>
                                        <td>${teacherList.birthDate}</td>
                                        <td>${teacherList.tel}</td>
                                        <td>
                                        <form action="/admin/updateUser?username=${teacherList.userName}" method="get">
                                         <a href="/admin/updateUser?userName=${teacherList.id}">수정</a> 
                                        </form>
                                        </td>
                                        <td>
                                        <form action="/admin/deleteUser?id=${teacherList.id}" method="post">
                                        <a href="/admin/deleteUser?id=${teacherList.id}">삭제</a> 
                                        </form>
                                        </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
						</div>
					</div>
				</div>
<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
