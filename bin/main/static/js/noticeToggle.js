/**
 * 
 */

addPanelNotice();

function addPanelNotice() {
	let panelNotice = document.querySelectorAll('.show__content');

	for (let pn of panelNotice) {
		pn.addEventListener('click', function() {
			if (this.classList.contains('active')) {
				this.classList.remove('active');
			} else {
				hideAll();
				this.classList.add('active');
			}
		});
	}

	function hideAll() {
		for (let n of panelNotice) {
			n.classList.remove('active');
		}
	}

}