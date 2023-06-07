<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="utf-8" xmlns:th="http://www.thymeleaf.org"></html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/css/user/userInfoUpdate.css">
<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<div class="container">
   <div class="signInContainer">
      <div class="loginContainer">
         <div class="login--title">
            <img alt="" src="/images/background/logo.png" class="loginLogo">
         </div>
         <br>
         <form action="/user/update" method="post">

            <br>
            <div id="ipw">
               <p>닉네임 :</p>
               <i class="material-icons">insert_emoticon</i> <input type="text" placeholder="닉네임을 입력하세요" name="nickname" id="nickname" class="info" value="${user.nickname}"><br>
            </div>
            <span class="error--messege" id="error--nickname" th:if="${valid_nickname}">${valid_nickname}</span> <br>
            <div id="ipw">
               <p>이메일 :</p>
               <i class="material-icons">mail_outline</i> <input type="email" placeholder="이메일을 입력하세요" name="email" id="email" readonly="readonly" class="info" value="${user.email}"><br>
            </div>
            <span class="error--messege" th:if="${valid_email}">${valid_email}</span> <br> <input type="hidden" name="birthDate" id="birthDate">
            <div id="ipw">
               <p>전화번호 :</p>
               &nbsp; <i class="material-icons">phone_android</i> <input type="text" placeholder="전화번호를 입력하세요" name="tel" id="tel" class="info" value="${user.tel}"><br>
            </div>
            <span class="error--messege" id="error--tel" th:if="${valid_tel}">${valid_tel}</span> <br> <input type="hidden" class="form-control" id="userName" name="userName" value="${user.userName}">

            <c:choose>
               <c:when test="${user.apiId != null}">
                  <input type="hidden" name="password" id="password" value="${user.password}">
               </c:when>
               <c:otherwise>
                  <h3 style="margin-top: 100px; margin-left: 180px; font-size: 25px;">현재 비밀번호를 입력해주세요.</h3>
                  <div id="ipw">
                     <p style="margin-left: -10px;">비밀번호 :</p>
                     <i class="material-icons">lock_outline</i> <input type="password" placeholder="비밀번호를 입력하세요" name="password" id="password" class="infoPw"> <br>
                  </div>
               </c:otherwise>
            </c:choose>
            <span class="error--messege" th:if="${valid_password}">${valid_password}</span> <br> <input type="hidden" value="${userInfo.id}" id="apiId" name="apiId"> <input type="submit"
               value="정보수정" class="login">
         </form>
         <c:choose>
            <c:when test="${user.apiId != null}">
            </c:when>
            <c:otherwise>
               <form action="/user/updatePassword">
                  <input type="submit" class="updatePassword" value="비밀번호 변경하기">
               </form>
            </c:otherwise>
         </c:choose>
      </div>
   </div>
</div>
<script type="text/javascript">

var nicknameCheck = false;
var telCheck = false;
$(document)
   .ready(
      function() {
         $(".login").attr("disabled", true), $(".login").css(
            "background-color", "#ccc");

         $(function() {
            $("#nickname")
               .on(
                  'keyup',
                  function() {
                     var formData = $("#nickname")
                        .val();
                     $
                        .ajax({
                           type: 'post',
                           url: "/user/check/nickname",
                           contentType: "application/json; charset=UTF-8",
                           data: formData,
                           datatype: "json",
                           success: function(
                              data) {
                              let res = data.data;
                              if (formData.length <= 1) {
                                 $(
                                    "#error--nickname")
                                    .empty();
                                 $(
                                    "#error--nickname")
                                    .append(
                                       "닉네임은 최소 2글자입니다.");
                                 $(
                                    ".login")
                                    .attr(
                                       "disabled",
                                       true),
                                    $(
                                       ".login")
                                       .css(
                                          "background-color",
                                          "#ccc");
                                 nicknameCheck = false;
                              } else {
                                 if (res == 1) {
                                    $(
                                       "#error--nickname")
                                       .empty();
                                    $(
                                       "#error--nickname")
                                       .append(
                                          "해당 닉네임이 존재합니다.");
                                    $(
                                       ".login")
                                       .attr(
                                          "disabled",
                                          true),
                                       $(
                                          ".login")
                                          .css(
                                             "background-color",
                                             "#ccc");
                                    nicknameCheck = false;
                                 } else {
                                    $(
                                       "#error--nickname")
                                       .empty();
                                    $(
                                       "#error--nickname")
                                       .append(
                                          "사용할 수 있는 닉네임 입니다.");
                                    nicknameCheck = true;
                                    if ($("#nickname").val().length > 0) {
                                       if ((nicknameCheck == true||$("#nickname").val()==`${user.nickname}`) && (telCheck == true||$("#tel").val()==`${user.tel}`)) {
                                          {
                                             $(".login").attr("disabled", false),
                                                $(".login").css("background-color", "rgb(255, 80, 90)")
                                          }
                                       } else {
                                          $(".login").attr("disabled", true),
                                             $(".login").css("background-color", "#ccc");
                                       }
                                    }
                                 }
                              }
                           },
                           error: function(
                              error) {
                           }
                        });
                  });
         });
         $(function() {
            $("#tel")
               .on(
                  'keyup',
                  function() {
                     var formData = $("#tel").val();
                     $
                        .ajax({
                           type: 'post',
                           url: "/user/check/tel",
                           contentType: "application/json; charset=UTF-8",
                           data: formData,
                           datatype: "json",
                           success: function(
                              data) {
                              let res = data.data;
                              if ((formData.length == 11) == false) {
                                 telCheck = false;
                                 $(
                                    "#error--tel")
                                    .empty();
                                 $(
                                    "#error--tel")
                                    .append(
                                       "올바른 전화번호가 아닙니다.");
                                 $(
                                    ".login")
                                    .attr(
                                       "disabled",
                                       true),
                                    $(
                                       ".login")
                                       .css(
                                          "background-color",
                                          "#ccc");
                              } else {
                                 if (res == 1) {
                                    telCheck = false;
                                    $(
                                       "#error--tel")
                                       .empty();
                                    $(
                                       "#error--tel")
                                       .append(
                                          "등록된 전화번호입니다.");
                                    $(
                                       ".login")
                                       .attr(
                                          "disabled",
                                          true),
                                       $(
                                          ".login")
                                          .css(
                                             "background-color",
                                             "#ccc");
                                 } else {
                                    telCheck = true;
                                    $(
                                       "#error--tel")
                                       .empty();
                                    $(
                                       "#error--tel")
                                       .append(
                                          "사용할 수 있는 전화번호 입니다.");
                                    if ($(
                                          "#nickname")
                                          .val().length > 0) {
                                       if ($(
                                             "#tel")
                                             .val().length > 10) {
                                          if ((nicknameCheck == true||$("#nickname").val()==`${user.nickname}`) && (telCheck == true||$("#tel").val()==`${user.tel}`)) {
                                             if (telCheck == true
                                                ) {
                                                $(
                                                   ".login")
                                                   .attr(
                                                      "disabled",
                                                      false),
                                                   $(
                                                      ".login")
                                                      .css(
                                                         "background-color",
                                                         "rgb(255, 80, 90)")
                                             }
                                          } else {
                                             $(
                                                ".login")
                                                .attr(
                                                   "disabled",
                                                   true),
                                                $(
                                                   ".login")
                                                   .css(
                                                      "background-color",
                                                      "#ccc");
                                          }
                                       }
                                    }
                                 }
                              }
                           },
                           error: function(
                              error) {
                           }
                        });
                  });
         });

      });

function save() {
   var year = document.getElementById("year").value;
   var month = document.getElementById("month").value;
   var day = document.getElementById("day").value;

   var date = new Date(year, month - 1, day);

   var birthDate = date.toISOString().slice(0, 10);
   document.getElementById("birthDate").value = birthDate;
}

$('.modal').on('hidden.bs.modal', function(e) {
   $(this).find('form')[0].reset()
});


var idck = 0;
$(function() {
   $('.info').on(
      'keyup',
      function() {
         if (
            $("#nickname").val().length > 0) {
               if(
                  $("#tel").val().length > 10) {
               if ( nicknameCheck == true) {
                  if (telCheck == true) {
                     $(".login").attr("disabled", false), $(
                        ".login").css("background-color",
                           "rgb(255, 80, 90)")
                  }
               } else {
                  $(".login").attr("disabled", true), $(".login")
                     .css("background-color", "#ccc");
               }
            }
         }
      });
});


</script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

