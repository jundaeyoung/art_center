// 전대영
// 중복 클릭 방지
$(".button").on("click", function() {
	$(this).attr("disabled", true);
	setTimeout(function() {
		$(".button").attr("disabled", false);
	}, 550);
});

// 전대영 
// 상단 메뉴바 드롭다운 
$(document).ready(function() {
	$(".main>li").mouseover(function() {
		$(this).children(".sub").stop().slideDown(200);
	});
	$(".main>li").mouseleave(function() {
		$(this).children(".sub").stop().slideUp(200);
	});
});

// 전대영
// 이미지 흘러가기 기능 구현 
var slides = document.querySelector('.slides'),
	slide = document.querySelectorAll('.slides li'),

	currentIdx = 0,
	slideCount = $('.slides li').length,
	slideWidth = 150,
	slideMargin = 30,
	prevBtn = document.querySelector('.prev'),
	nextBtn = document.querySelector('.next');
makeClone();

function makeClone() {
	for (let i = 0; i < slideCount; i++) {
		let cloneSlide = slide[i].cloneNode(true);
		cloneSlide.classList.add('clone');
		slides.appendChild(cloneSlide);
	}
	for (let i = slideCount - 1; i >= 0; i--) {
		let cloneSlide = slide[i].cloneNode(true);
		cloneSlide.classList.add('clone');
		slides.prepend(cloneSlide);
	}
	updateWidth();
	setInitialPos();
	setTimeout(function() {
		slides.classList.add('animated');
	}, 100);
}

function updateWidth() {
	var currentSlides = document.querySelectorAll('.slides li');
	var newSlideCount = currentSlides.length;

	var newWidth = (slideWidth + slideMargin) * newSlideCount - slideMargin + 'px';
	slides.style.width = newWidth;
}
function setInitialPos() {
	var initialTranslateValue = -(slideWidth + slideMargin) * slideCount;
	slides.style.transform = 'translateX(' + initialTranslateValue + 'px)';
}

function moveSlide(num) {
	slides.style.left = - num * (slideWidth + slideMargin) + 'px';
	currentIdx = num;


	if (currentIdx == slideCount || currentIdx == -slideCount) {

		setTimeout(function() {
			slides.classList.remove('animated');
			slides.style.left = '0px';
			currentIdx = 0;
		}, 500);
		setTimeout(function() {
			slides.classList.add('animated');
		}, 600);

	}

}

// 전대영
// 슬라이드 뒷 배경 
$(function() {
	var $slider = $('.slider'),
		$firstSlide = $slider.find('li').first() // 첫번째 슬라이드
			.stop(true).animate({ 'opacity': 1 }, 200); // 첫번째 슬라이드만 보이게 하기

	function PrevSlide() { // 이전버튼 함수
		var $lastSlide = $slider.find('li').last() //마지막 슬라이드
			.prependTo($slider); //마지막 슬라이드를 맨 앞으로 보내기  
		$secondSlide = $slider.find('li').eq(1)//두 번째 슬라이드 구하기
			.stop(true).animate({ 'opacity': 0 }, 400); //밀려난 두 번째 슬라이드는 fadeOut 시키고
		$firstSlide = $slider.find('li').first() //맨 처음 슬라이드 다시 구하기
			.stop(true).animate({ 'opacity': 1 }, 400);//새로 들어온 첫 번째 슬라이드는 fadeIn 시키기
	}

	function NextSlide() { // 다음 버튼 함수
		$firstSlide = $slider.find('li').first() // 첫 번째 슬라이드
			.appendTo($slider); // 맨 마지막으로 보내기
		var $lastSlide = $slider.find('li').last() // 맨 마지막으로 보낸 슬라이드
			.stop(true).animate({ 'opacity': 0 }, 400); // fadeOut시키기
		$firstSlide = $slider.find('li').first()// 맨 처음 슬라이드
			.stop(true).animate({ 'opacity': 1 }, 400);// fadeIn 시키기
	}

	$('#next').on('click', function() { //다음버튼 클릭
		moveSlide(currentIdx + 1);
		NextSlide();
	});
	$('#prev').on('click', function() { //이전 버튼 클릭
		PrevSlide();
		moveSlide(currentIdx - 1);

	});

});


