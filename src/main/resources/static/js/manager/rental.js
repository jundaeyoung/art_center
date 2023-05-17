/**
 * 작성자 : 김미정
 */
 $(document).ready(function() {
	$(".main>li").mouseover(function() {
		$(this).children(".sub").stop().slideDown(200);
	});
	$(".main>li").mouseleave(function() {
		$(this).children(".sub").stop().slideUp(200);
	});
});