function addPanelQuestion(){
	let panelQuestion = document.querySelectorAll('.panel-question');

	for (let pq of panelQuestion) {
	  pq.addEventListener('click', function () {
	    if (this.classList.contains('active')) {
	      this.classList.remove('active');
	    } else {
	      hideAll();
	      this.classList.add('active');
	    }
	  });
	}

	function hideAll() {
	  for (let q of panelQuestion) {
	    q.classList.remove('active');
	  }
	}

 }