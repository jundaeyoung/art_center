$(document).ready(function() {
	$('.hide').toggle();
	$('[id^="show_"]').each(function() {
		let id = $(this).attr("id");
		let num = id.split("_")[1];
		$(this).click(function() {
			$("#hide_" + num).toggle();
		});
	});

});
$(document).ready(function() {
	$('#answer__write').toggle();
	$('#show__write').each(function() {
		$(this).click(function() {
			$('#answer__write').toggle();
			$('#hide__search__box').toggle();
		});
	});
});
$('.summernote').summernote({
	tabsize: 2,
	height: 400,
	callbacks: {
		onInit: function(c) {
			c.editable.html('');
		}
	}
});

$(document)
	.ready(
		function() {
			$('input[type="checkbox"][name="questionTypeId"]')
				.click(
					function() {
						if ($(this).prop('checked')) {
							$(
								'input[type="checkbox"][name="questionTypeId"]')
								.prop('checked', false);
							$(this).prop('checked', true);
						}
					});
		});
		