$(function () {
	// $('.group').mouseenter(function(){
	// 	clearTimeout(a);
	// 	var that = this;
	// 	$(that).addClass("bounce animated");
	// 	var a =  setTimeout(function(){$(that).removeClass("bounce animated");}, 1000);
	// });
	$('.group').click(function(){
		var that = this;
		if(!$('.chosen:eq(0)').is(this) && $('.slideIn').length){
            console.log($('.slideIn').length);
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

    $(".f_title").on('click',()=>{
        $("#form_main").slideToggle();
        if($(".f_title").hasClass('faguang')){
            $(".f_title").removeClass('faguang');
            $("[href='#form']").click();
        }
        else
            $(".f_title").addClass('faguang');
     })
var handler2 = function (captchaObj) {
        $("#submit").click(function (e) {
            var validate = captchaObj.getValidate();
            var mess = result();
            if (!validate)
            	alert('请先验证!');
            else if(mess != true)
            	alert(mess);  
            else{
                $.ajax({
                    url: '/rdc/user/validate',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        name: $("input[name='name']").val(),
                        number: $("input[name='number']").val(),
                        sex: $("input[name='sex']").val(),
                        majorAndClass: $("input[name='majorAndClass']").val(),
                        duties: $("input[name='duties']").val(),
                        phone: $("input[name='phone']").val(),
                        shortNumber: $("input[name='shortNumber']").val(),
                        email: $("input[name='email']").val(),
                        QQ: $("input[name='QQ']").val(),
                        organize: $("#selected").val(),
                        speciality: $("input[name='speciality']").val(),
                        introduce: $("textarea[name='introduce']").val(),
                        purpose: $("textarea[name='name']").val(),
                        challenge: result.geetest_challenge,
                        validate: result.geetest_validate,
                        seccode: result.geetest_seccode
                    },
                    success: function (data) {
                        if (data.status === 'success') {
                            alert('报名成功');
                        } else if (data.status === 'fail') {
                            alert('报名失败');
                        }
                    }
                })
            }
            e.preventDefault();
        });
        // 将验证码加到id为form的元素里，同时会有三个input的值用于表单提交
        captchaObj.appendTo("#form");
        captchaObj.onReady(function () {
            $("#wait2").hide();
        });
        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };
    $.ajax({
        url: "/rdc/user/ready?t=" + (new Date()).getTime(), // 加随机数防止缓存
        type: "get",
        dataType: "json",
        success: function (data) {
            // 调用 initGeetest 初始化参数
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                product: "popup", // 产品形式，包括：float，popup
                width: "100%"
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handler2);
        }
    });
})

//前端验证
function result(){
	if(!/^[^ ]+$/.test($("input[name='name']").val()))
		return '名字不能为空或不能有空格!';
	if(!/^\d{10}$/.test($("input[name='number']").val()))
		return '请填写正确的学号!';
	if(!/^[^ ]+$/.test($("input[name='majorAndClass']").val()))
		return '学院专业班级不能为空或不能有空格!';
	if(!/^1[3,4,5,7,8]\d{9}$/.test($("input[name='phone']").val()))
		return '请填写正确的手机号码!';
	if($("input[name='email']").val() && !/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($("input[name='email']").val()))
		return '请填写正确的邮箱!';
	if(!/^\d{1,}$/.test($("input[name='QQ']").val()))
		return '请填写正确的QQ号码!';
	if(!/^[^ ]+$/.test($("textarea[name='introduce']").val()))
		return '自我简介不能为空或不能有空格!';
	return true;
}