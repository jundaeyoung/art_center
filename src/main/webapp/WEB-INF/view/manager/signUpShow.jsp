<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/manager/signUpShow.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<div class="show__header"></div>
<div class="signUpShow__content"
	style="display: flex; flex-direction: column;">
	<div class="show__title">
		<span class="material-symbols-outlined"> square </span>
		<div>
			<h1>공연등록</h1>
		</div>
	</div>
	<div class="signUpShow__info">
		<form action="/manager/sign-up" method="post"
			enctype="multipart/form-data">
			<div
				style="display: flex; width: 1400px; flex-direction: row; justify-content: space-between;">
				<div style="height: 400px;margin-top:-100px; display: flex; flex-direction: column">
					<div style="margin-bottom: -10px; margin-left: -25px;">
						<label for="file"
							style="width: 200px; margin-right: 80px; margin-left: -5px; margin-top: -10px;">이미지
							: </label>
						<div class="filebox" >
							<input class="upload-name" value="첨부파일" placeholder="첨부파일">
							<label for="file"style="margin-right: -12px;">이미지 </label> <input type="file" name="file"
								id="file" accept=".jpg,.jpeg,.png" style="width: 400px;">
						</div>
					</div>
					<div class="date" style="margin-left: 4px; color: black;">
						<label for="content">날짜 : </label> <input type="text"
							id="startDate" name="startDate" style="width: 300px;" />
					</div>
					<div>
						<label for="title">제목 : </label><input type="text" id="title"
							name="title">
					</div>
					<div>
						<label for="content">내용 : </label>
						<textarea id="content" name="content"
							style="resize: none; height: 100px; width: 420px;"></textarea>
					</div>

				</div>
				<div style="height: 500px; display: flex; flex-direction: column">
					<div>
						<label for="age">연령제한 : </label><select id="age"
							name="admissionAge" style="width: 220px;">
							<option value="전체 관람가">전체 관람가</option>
							<option value="12세 이상">12세 이상</option>
							<option value="18세 이상">18세 이상</option>
							<option value="19세 이상">19세 이상</option>
						</select>
					</div>
					<div>
						<label for="adult_rate">성인요금 : </label><input type="text"
							id="adult_rate" name="adultRate">
					</div>
					<div>
						<label for="youth_rate">청소년요금 : </label><input type="text"
							id="youth_rate" name="youthRate">
					</div>
					<div>
						<label for="showTypeId">카테고리 : </label><select name="showTypeId"
							id="showTypeId">
							<c:forEach var="categoryList" items="${categoryList}">
								<option value="${categoryList.id}">${categoryList.showType}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}"
							name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit">등 록</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>


<script type="text/javascript" src="/js/manager/managerSignUpShow.js"></script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

