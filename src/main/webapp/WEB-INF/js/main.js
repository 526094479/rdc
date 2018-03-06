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


	$('.ma5slider').ma5slider();

    
   /***菜单 */
   /*
	$(window).scroll(()=>{ 
		let t = document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop,
			m_in = $("#outerdiv"),
			m_ab = $("#about"),
			m_fo = $("#form"),
			in_t = m_in.offset().top,
			ab_t = m_ab.offset().top,
			fo_t = m_fo.offset().top;
			
		    if(t<in_t-100)   $(".m_item").css("right","-100px");
			if(t>=in_t-100)  $(".m_in").css("right","-20px").siblings().css("right","-100px"); 
			if(t>=ab_t-100)  $(".m_ab").css("right","-20px").siblings().css("right","-100px");
			if(t>fo_t-200)   $(".m_fo").css("right","-20px").siblings().css("right","-100px");	
	 })
  */

	 /**下拉组别菜单 */
	 $(".down").on('click',()=>{
		 $("#select_menu").slideToggle();
	 })
	 $(".select_item").on('click',function(){
		 let val = $(this).text();
		 $("#selected").text(val);
		$("#select_menu").slideToggle();
	 })

	 $(".sex_choic").on('click',function(){
		if($(".sex").text()=='男'){
			  $(".sex").text("女");
			$(".sex_val").attr('value','女');
		}
		else {
			$(".sex").text("男");
			$(".sex_val").attr('value','男');
		}
	 })
})