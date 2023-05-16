<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/manager/signUpShow.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>

<div class="show__header"></div>
<div class="signUpShow__content">
	<div class="signUpShow__info">
		<form action="/manager/sign-up" method="post" enctype="multipart/form-data">
			<div style="display: flex; width: 900px; flex-direction: row; justify-content: space-between;">
				<div style="height: 500px; display: flex; flex-direction: column">
					<div>
						<label for="file">이미지 : </label> <input type="file" name="file" id="file" accept=".jpg,.jpeg,.png">
					</div>
					<div>
						<label for="title">제목 : </label><input type="text" id="title" name="title">
					</div>
					<div>
						<label for="content">내용 : </label><input type="text" id="content" name="content">
					</div>
					<div>
						<label for="start_date">시작일 : </label><input type="date" id="start_date" name="startDate">
					</div>
					<div>
						<label for="end_date">마감일 : </label><input type="date" id="end_date" name="endDate">
					</div>
					<div>
						<label for="age">연령제한 : </label><input type="text" id="age" name="admissionAge">
					</div>
				</div>
				<div style="height: 500px; display: flex; flex-direction: column">
					<div>
						<label for="adult_rate">성인 요금 : </label><input type="text" id="adult_rate" name="adultRate">
					</div>
					<div>
						<label for="youth_rate">청소년 요금 : </label><input type="text" id="youth_rate" name="youthRate">
					</div>
					<div>
						<label for="infant_rate">유아 요금 : </label><input type="text" id="infant_rate" name="infantRate">
					</div>
					<div>
						<label for="holeId">장소 : </label><select name="holeId" id="holeId">
							<c:forEach var="holeList" items="${holeList}">
								<option value="${holeList.id}">${holeList.name}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label for="showTypeId">카테고리 : </label><select name="showTypeId" id="showTypeId">
							<c:forEach var="categoryList" items="${categoryList}">
								<option value="${categoryList.id}">${categoryList.showType}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}" name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" >등 록</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>