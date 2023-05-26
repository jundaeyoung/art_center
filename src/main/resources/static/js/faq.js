/**
 * @author 손주이
 */



/*
function moveCategory(categoryId) {
	let categoryButton = document.querySelectorAll(".faq-type-btn")


	$.ajax({
		type: "get",
		url: "/api/selectFaq/" + categoryId,
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(faqList){
		
		
		
		
		
		
		
	}).fail();


}

*/









let panelQuestion = document.querySelectorAll('.panel-question');

for (let pq of panelQuestion) {
	pq.addEventListener('click', function() {
		hideAll();
		this.classList.add('active');
	});
}

function hideAll() {
	for (q of panelQuestion) {
		q.classList.remove('active');
	}
}

