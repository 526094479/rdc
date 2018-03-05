$(function () {
	// $('.group').mouseenter(function(){
	// 	clearTimeout(a);
	// 	var that = this;
	// 	$(that).addClass("bounce animated");
	// 	var a =  setTimeout(function(){$(that).removeClass("bounce animated");}, 1000);
	// });
	$('.group').click(function(){
		var that = this;
		if(!$('.chosen:eq(0)').is(this)){
			//$('.chosen:eq(0)').animate({top:"0px"},1000);
			$('.chosen:eq(0)').removeClass("chosen");
			$(this).addClass("chosen");
			//$(this).animate({top:"100px"},1000);
			$('.slideIn:eq(0)').removeClass("slideIn").addClass("slideOut");
			setTimeout(function(){$('.slideOut:eq(0)').css("display", "none").removeClass("slideOut");$('.introdution:eq('+$(that).attr("groupid")+')').css("display", "block").addClass("slideIn")},1000);
		}
	});	


	//$('.group :first').click();
	// 在html里直接给前端加上chosen的class类，这样每次加载时不用等一秒才动
})