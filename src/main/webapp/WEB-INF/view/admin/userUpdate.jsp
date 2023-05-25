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
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        <td>
                                        <form action="/admin/update" method="post">
                                        <input type="hidden" value="${userList.roleId}" name="roleId" id="roleId">
                                        <input type="hidden" value="${userList.id}" name= "id">
                                        <input type="text" value="${userList.userName}" name="userName" id="userName">
                                        </td>
                                         <td>
                                        <input type="text" value="${userList.nickname}" name="nickname" id ="nickname">
                                        </td>
                                         <td>
                                        <input type="text" value="${userList.email}" name="email" id ="email">
                                        </td>
                                         <td>
                                        <input type="text" value="${userList.birthDate}" name="birthDate" id="birthDate">
                                        </td>
                                         <td>
                                        <input type="text" value="${userList.tel}" name ="tel" id="tel">
                                        </td>
                                        <td><button class="userBtn">수정</button></td>
                                        </form>
                                        </tr>
                                    </tbody>
                                </table>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>