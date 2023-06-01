/**
 * 
 */


var idCheck = false;
var nicknameCheck = false;
var telCheck = false;
var emailCheck = false;
$(document)
   .ready(
      function() {
         $(".login").attr("disabled", true), $(".login").css(
            "background-color", "#ccc");

         $(function() {
            $("#userName")
               .on(
                  'keyup',
                  function() {
                     var formData = $("#userName")
                        .val();
                     $
                        .ajax({
                           type: 'post',
                           url: "/user/check/userName",
                           contentType: "application/json; charset=UTF-8",
                           data: formData,
                           datatype: "json",
                           success: function(
                              res) {
                              if (res == 1) {
                                 $(
                                    "#error--userName")
                                    .empty();
                                 $(
                                    "#error--userName")
                                    .append(
                                       "해당 아이디가 존재합니다.");
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
                                 idCheck = false;
                              } else {
                                 $(
                                    "#error--userName")
                                    .empty();
                                 $(
                                    "#error--userName")
                                    .append(
                                       "사용할 수 있는 아이디 입니다.");
                                 idCheck = true;
                                 if ($(
                                    "#userName")
                                    .val().length > 0
                                    && $(
                                       "#password")
                                       .val().length > 0
                                    && $(
                                       "#nickname")
                                       .val().length > 0) {
                                    if ($(
                                       "#year")
                                       .val().length > 0
                                       && $(
                                          "#month")
                                          .val().length > 0
                                       && $(
                                          "#day")
                                          .val().length > 0
                                       && $(
                                          "#tel")
                                          .val().length > 10) {
                                       if (idCheck == true
                                          && nicknameCheck == true) {
                                          if (telCheck == true
                                             && emailCheck == true) {
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
                           },
                           error: function(
                              error) {
                           }
                        });
                  });
         });
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
                              res) {
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
                                    if ($(
                                       "#userName")
                                       .val().length > 0
                                       && $(
                                          "#password")
                                          .val().length > 0
                                       && $(
                                          "#nickname")
                                          .val().length > 0) {
                                       if ($(
                                          "#year")
                                          .val().length > 0
                                          && $(
                                             "#month")
                                             .val().length > 0
                                          && $(
                                             "#day")
                                             .val().length > 0
                                          && $(
                                             "#tel")
                                             .val().length > 10) {
                                          if (idCheck == true
                                             && nicknameCheck == true) {
                                             if (telCheck == true
                                                && emailCheck == true) {
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
                              res) {
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
                                       "#userName")
                                       .val().length > 0
                                       && $(
                                          "#password")
                                          .val().length > 0
                                       && $(
                                          "#nickname")
                                          .val().length > 0) {
                                       if ($(
                                          "#year")
                                          .val().length > 0
                                          && $(
                                             "#month")
                                             .val().length > 0
                                          && $(
                                             "#day")
                                             .val().length > 0
                                          && $(
                                             "#tel")
                                             .val().length > 10) {
                                          if (idCheck == true
                                             && nicknameCheck == true) {
                                             if (telCheck == true
                                                && emailCheck == true) {
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

$("#checkEmail")
   .click(
      function() {
         let userEmail = $("#email").val();
         if (userEmail.length < 5) {
            alert("잘못된 이메일 형식입니다.")
            return false;
         }
         $
            .ajax({
               type: "GET",
               url: "/user/check/findEmail",
               data: {
                  "userEmail": userEmail
               },
               success: function(res) {
                  emailCheck = false;
                  if (res['check']) {
                     if ('check') {
                        alert(
                           "발송 완료!",
                           "입력하신 이메일로 인증번호가 발송되었습니다.",
                           "success")
                     }
                     if ('check') {
                        $
                           .ajax({
                              type: "POST",
                              url: "/user/check/email/sendEmail",
                              data: {
                                 "userEmail": userEmail
                              },
                              success: function(
                                 res) {
                                 console
                                    .log(res);
                                 $(
                                    "#checkEmailNumber")
                                    .click(
                                       function() {
                                          let checkCode = $(
                                             "#emailCheck")
                                             .val()
                                          if (res == checkCode) {
                                             alert("인증 되었습니다.")
                                             emailCheck = true;
                                             if ($(
                                                "#userName")
                                                .val().length > 0
                                                && $(
                                                   "#password")
                                                   .val().length > 0
                                                && $(
                                                   "#nickname")
                                                   .val().length > 0) {
                                                if ($(
                                                   "#year")
                                                   .val().length > 0
                                                   && $(
                                                      "#month")
                                                      .val().length > 0
                                                   && $(
                                                      "#day")
                                                      .val().length > 0
                                                   && $(
                                                      "#tel")
                                                      .val().length > 10) {
                                                   if (idCheck == true
                                                      && nicknameCheck == true) {
                                                      if (telCheck == true
                                                         && emailCheck == true) {
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
                                          } else {
                                             alert("인증번호가 일치하지 않습니다.")
                                          }
                                       });
                              }
                           });
                     }

                     $('#checkMsg')
                        .html(
                           '<p style="color:darkblue"></p>');
                  } else {
                     alert("해당이메일이 존재합니다.", "success")
                  }
               }
            })
      })

var idck = 0;
$(function() {
   $('.info').on(
      'keyup',
      function() {
         if ($("#userName").val().length > 0
            && $("#password").val().length > 0
            && $("#nickname").val().length > 0) {
            if ($("#year").val().length > 0
               && $("#month").val().length > 0
               && $("#day").val().length > 0
               && $("#tel").val().length > 10) {
               if (idCheck == true && nicknameCheck == true) {
                  if (telCheck == true && emailCheck == true) {
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

