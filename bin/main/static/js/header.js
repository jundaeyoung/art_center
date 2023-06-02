
//상단 메뉴바 드롭다운
$(document).ready(function() {
	$(".main>li").mouseover(function() {
		$(this).children(".sub").stop().slideDown(200);
	});
	$(".main>li").mouseleave(function() {
		$(this).children(".sub").stop().slideUp(200);
	});
});

// 네이버 로그아웃
var naverPopUp;

function openPopUpNaver() {
	naverPopUp= window.open("https://nid.naver.com/nidlogin.logout", "_self", "width=10, height=10, left=-9999, top=-9999, visible=0");
	naverPopUp.blur();
}
function closePopUp1(){
	naverPopUp.close();
}
function naverLogout() {
	openPopUpNaver();
	setTimeout(function() {
		closePopUp1();
		location.href = "/naverlogout";
	}, 40);
}



// 구글 로그아웃
var googlePopUp;

function openPopUpGoogle(){
	googlePopUp = window.open("https://mail.google.com/mail/u/0/?logout&hl=en", "hiddenframe", "width=450, height=350, left=-500, top=-500,  scrollbars=no,status=no,toolbar=no,menubar=no,resizeable=no,location=no");
}
function closePopUp2(){
	googlePopUp.close();
}

function googleLogout(){
	openPopUpGoogle();
	setTimeout(function() {
		closePopUp2();
		location.href = "/googlelogout";
		}, 1000);
}
