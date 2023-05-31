/**
 * @author 손주이
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

