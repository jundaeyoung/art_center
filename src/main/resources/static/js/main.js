// 전대영
// 이미지 흘러가기 기능 구현 
var slides = document.querySelector('.slides'),
	slide = document.querySelector('.slides li'),
	currentIdx = 0,
	slideCount = $('.slides li').length,
	slideWidth = 200,
	slideMargin = 30,
	prevBtn = document.querySelector('.prev'),
	nextBtn = document.querySelector('.next');
makeClone();

function makeClone() {
	for (var i = 0; i < slideCount; i++) {
		var cloneSlide = slide.cloneNode(true);
		cloneSlide.classList.add('clone');
		slides.appendChild(cloneSlide);
	}
	for (var i = slideCount - 1; i >= 0; i--) {
		var cloneSlide = slide.cloneNode(true);
		cloneSlide.classList.add('clone');
		slides.prepend(cloneSlide);
	}
	console.log("dd" + slideCount);
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

nextBtn.addEventListener('click', function() {
	moveSlide(currentIdx + 1);
})
prevBtn.addEventListener('click', function() {
	moveSlide(currentIdx - 1);
})

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
// 상단 메뉴바 드롭다운 
$(document).ready(function() {
	$(".main>li").mouseover(function() {
		$(this).children(".sub").stop().slideDown(200);
	});
	$(".main>li").mouseleave(function() {
		$(this).children(".sub").stop().slideUp(200);
	});
});