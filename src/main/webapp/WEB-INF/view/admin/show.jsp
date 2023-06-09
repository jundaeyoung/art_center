<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



		<div id="layoutSidenav_content">
			<main>
			<div class="fouc">
				<div class="container-fluid px-4">
					<h1 class="mt-4">show</h1>
					<ol class="breadcrumb mb-4">
					</ol>
					<div class="card mb-4">
						<div class="card-body">
							show
						</div>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> showList
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
                                    <thead>
                                          <tr>
                                            <th>제목</th>
                                            <th>평점</th>
                                            <th>내용</th>
                                            <th>타입</th>
                                            <th>승낙여부</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="showList" items="${showList}">
                                    	<tr>
                                        <td>${showList.title}</td>
                                        <td>${showList.rating}</td>
                                        <td>${showList.content}</td>
                                        <td>${showList.showType}</td>
                                        <c:choose>
                                        <c:when test="${showList.showStatus == 1}">
                                        <td>완료</td>
                                        </c:when>
                                        <c:otherwise>
                                        <td>
                                         <a href="/admin/updateShow/${showList.id}/${showList.userId}">승인</a> 
                                        </td>
                                        </c:otherwise>
                                        </c:choose>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
						</div>
					</div>
				</div>
				</div>
<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>





