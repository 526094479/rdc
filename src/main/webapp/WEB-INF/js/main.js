$(function () {
    setTimeout(function () {
        if(document.readyState === 'complete') {
            $('.feidie').removeClass('tiaodong').addClass('xiaoshi');
            setTimeout(function(){
            $('.feidie').css('display', 'none');    
            $('.loader').fadeOut();    
            $('#main').fadeIn();
            $('.slides').css('height', '100px');
            console.log($('.slides'))
            },500);
        }
    },1600);


	$('.group').click(function(){
		var that = this;
		if(!$('.chosen:eq(0)').is(this) && $('.bounceIn').length){
			$('.chosen:eq(0)').removeClass("chosen");
			$(this).addClass("chosen");
			$('.bounceIn:eq(0)').removeClass("bounceIn animated").addClass("bounceOut animated");
			setTimeout(function(){$('.bounceOut:eq(0)').css("display", "none").removeClass("bounceOut animated");$('.introdution:eq('+$(that).attr("groupid")+')').css("display", "block").addClass("bounceIn animated")},500);
		}
	});	

	//window.sr = ScrollReveal();
     sr.reveal('.about_text_wrapper', { duration: 800 ,reset: true });
	 sr.reveal('.slides', { duration: 800, reset: true  });
	 sr.reveal('.introdution_f', { duration: 800 });
	 sr.reveal('#form', { duration: 800 ,reset: true });
	

	$('.ma5slider').ma5slider();


	 /**下拉组别菜单 */
	$(".down").on('click',()=>{
	 $("#select_menu").slideToggle(200);
	})

	$(".select_item").on('click',function(){
	 let val = $(this).text();
	 $("#selected").text(val);
	$("#select_menu").slideToggle(200);
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

    $("a").on('click', function(event){
        setTimeout(event.preventDefault(),400);
    })
    var handler2 = function (captchaObj) {
        const validate = captchaObj.getValidate();
        captchaObj.onSuccess(function(){
            $.ajax({
                url: '/rdc/user/validate',
                type: 'POST',
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
                    organize: $("#selected").html(),
                    speciality: $("input[name='speciality']").val(),
                    introduce: $("textarea[name='introduce']").val(),
                    purpose: $("textarea[name='name']").val(),
                    challenge: validate.geetest_challenge,
                    validate: validate.geetest_validate,
                    seccode: validate.geetest_seccode
                },
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.result == 'success') {
                        alert('报名成功');
                        captchaObj.reset();
                    } else {
                        alert('报名失败');
                    }
                }
            })
        })
        $("#submit").click(function () {
            var mess = result();
            if(mess != true)
            	Alert(mess); 
            else{
                if(!validate)
                $(".geetest_holder").click();
            }
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
    $("#tipBox_subbmit").on('click',function () {AlertClose(); });
    $(".mask").on('click',function () {AlertClose(); });
})

//前端验证
function result(){
	if(!/^[^ ]+$/.test($("input[name='name']").val()))
		return '名字不能为空或不能有空格!';
    if(/^3[1,2]1[1,2,3,4,5]\d{6}$/.test($("input[name='number']").val()))
        return '仅限大一同学报名!'
	if(!/^3[1,2]1[6,7]\d{6}$/.test($("input[name='number']").val()))
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

//弹出框
function Alert(mess){
    $('.tipBox_main').html(mess);
    $('#tipBox').css('display','block').addClass('bounceIn animated');
    $('.mask').css('display','block');
    setTimeout(function(){
        $('#tipBox').removeClass('bounceIn animated');
    }, 700);
}
function AlertClose(){
    $('#tipBox').addClass('bounceOut animated');
    $('.mask').css('display','none');
    setTimeout(function(){
        $('#tipBox').css('display','none').removeClass('bounceOut animated');
    }, 700);
}