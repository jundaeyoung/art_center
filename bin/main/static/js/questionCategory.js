/**
 * 
 */

 /**
 * 
 */


$(document).ready(function() {
   $("body").on("click", "button[id='info'], button[id='rent__place'], button[id='academy'], button[id='recruitment']", function(event) {
      event.preventDefault();
      let url = $(this).parent().attr("href");
      loadQuestionContent(url);
      hideToggle();
      $('.question__btn').on('click', function() {
         summernoteToggle();
      });
   });


});
function loadQuestionContent(url) {
   $.ajax({
      type: 'get',
      url: url,
      contentType: 'application/json; charset=utf-8'
   }).done(function(response) {


      $('.question__title').html($(response).find('.question__title').html());
      $(".question").html($(response).find(".question").html());
      $(".page").html($(response).find(".page").html());
      $('.question__btn').on('click', function() {
         summernoteToggle();
      });
      hideToggle();
   }).fail(function(error) {
      console.error("Error: " + error);
   });

}

function hideToggle() {
   $('.hide').toggle();
   $('[id^="show_"]').each(function() {
      let id = $(this).attr("id");
      let num = id.split("_")[1];
      $(this).click(function() {
         $("#hide_" + num).toggle();
      });
   });
}

function summernoteToggle() {
   //$('#answer__write').toggle();
   $('#show__write').each(function() {
      /*$(this).on('click', function() {*/
         $('#answer__write').toggle();
         $('#hide__search__box').toggle();
   /*   });*/
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

   $('input[type="checkbox"][name="questionTypeId"]').click(function() {
      if ($(this).prop('checked')) {
         $('input[type="checkbox"][name="questionTypeId"]').prop('checked', false);
         $(this).prop('checked', true);
      }
   });
}
