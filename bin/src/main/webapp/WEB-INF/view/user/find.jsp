<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/css/styles.css">
<link rel="stylesheet" href="/css/user/signIn.css">

<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <h4><span class="glyphicon glyphicon-lock"></span> 비밀번호 찾기</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <div style="color: #ac2925">
                        <center>입력된 정보로 임시 비밀번호가 전송됩니다.</center>
                    </div>
                    <hr>
                    <form role="form">
                        <div class="form-group">
                            <label for="userEmail"><span class="glyphicon glyphicon-user"></span>email</label>
                            <input type="text" class="form-control" id="userEmail" placeholder="가입시 등록한 이메일을 입력하세요.">
                        </div>
                        <div class="form-group">
                            <label for="userName"><span class="glyphicon glyphicon-eye-open"></span> name</label>
                            <input type="text" class="form-control" id="userName" placeholder="가입시 등록한 이름을 입력하세요.">
                        </div>
                    </form>
                        <button type="button" class="btn btn-success btn-block" id="checkEmail">OK</button>
                    <hr>
                    <div class="text-center small mt-2" id="checkMsg" style="color: red"></div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span
                            class="glyphicon glyphicon-remove"></span> Cancel
                    </button>
                </div>
            </div>

        </div>
    </div>
</div>
<button type="button" class="btn btn-link" data-bs-toggle="modal" data-bs-target="#findPw">비밀번호를 잊으셨나요?</button>
<script>

    $('.modal').on('hidden.bs.modal', function (e) {
        console.log('modal close');
        $(this).find('form')[0].reset()
    });

    $("#checkEmail").click(function () {
        let userEmail = $("#userEmail").val();
        let userName = $("#userName").val();

        $.ajax({
            type: "GET",
            url: "/check/findPw",
            data: {
                "userEmail": userEmail,
                "userName": userName
            },
            success: function (res) {
                if (res['check']) {
                    swal("발송 완료!", "입력하신 이메일로 임시비밀번호가 발송되었습니다.", "success").then((OK) = > {
                        if(OK) {
                            $.ajax({
                                type: "POST",
                                url: "/check/findPw/sendEmail",
                                data: {
                                    "userEmail": userEmail,
                                    "userName": userName
                                }
                            })
                            window.location = "/login";
                        }


                    }
                )
                    $('#checkMsg').html('<p style="color:darkblue"></p>');
                } else {
                    $('#checkMsg').html('<p style="color:red">일치하는 정보가 없습니다.</p>');
                }
            }
        })
    })
</script>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

