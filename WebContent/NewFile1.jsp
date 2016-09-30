<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 为使用方便，直接使用jquery.js库 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<!-- 引入封装了failback的接口--initGeetest -->
<script src="http://static.geetest.com/static/tools/gt.js"></script>
</head>
<body>
	<form class="popup" method="post" action="MyGeeTestServlet">
		<table cellpadding="3" cellspacing="1" align="center"
			class="tableborder1">
			<tr>
				<td colspan="4" valign="middle" align="center" height="25"
					background="/images/bg2.gif" width="50"><font color="#ffffff">
						<b>用户登陆</b>
				</font></td>
			</tr>
			<tr>
				<td class=tablebody1 valign="middle" height="20" width="30%">
					请输入您的用户名:</td>
				<td class=tablebody1 valign="middle" height="20" width="80%"><input
					type="text" id="name" name="name">&nbsp;<a
					href="/userRegister.do">注册新用户</a></td>
			</tr>
			<tr>
				<td class=tablebody1 valign="middle" width="30%" height="25">
					请输入您的密码:</td>
				<td class=tablebody1 valign="middle" width="80%"><input
					type=password name="password"> 
					<c:if test="${!empty error}">
						<font color="red"><c:out value="${error}" /></font>
					</c:if></td>
			</tr>
			<tr>
				<td colspan="4" class=tablebody2 align="center" valign="middle"
					width="60%"><input id="popup-submit" type=submit value=登陆></td>
			</tr>
			<tr>
				<td>
					<div id="popup-captcha"></div>
					<p id="wait" class="show">正在加载验证码......</p>
					<p id="notice" class="hide">请先拖动验证码到相应位置</p>
				</td>
			</tr>
		</table>
	</form>
	<script>

	// 代码详细说明
	var handlerPopup = function (captchaObj) {
	    // 注册提交按钮事件，比如在登陆页面的登陆按钮
	    $("#popup-submit").click(function () {
	        
	        
	        // 先校验是否点击了验证码
	        var validate = captchaObj.getValidate();
	        if (!validate) {
	            alert('请先完成验证！');
	            return;
	        }
	        // 提交验证码信息，比如登陆页面，你需要提交登陆信息，用户名和密码等登陆数据
	        $.ajax({
	            url: "../web/VerifyLoginServlet.php",
	            type: "post",
	            // dataType: "json",
	            data: {
	                // 用户名和密码等其他数据放在这里
	                username:username,
	                password:password,

	                // 验证码数据，这些数据不用自己获取
	                // 这是二次验证所需的三个值
	                geetest_challenge: validate.geetest_challenge,
	                geetest_validate: validate.geetest_validate,
	                geetest_seccode: validate.geetest_seccode
	            },
	            // 这里是返回结果的处理函数
	            success: function (data) {
	                   	console.log("11111");
	                    if (data && (data.status === "success")) {

	                        $(document.body).html('<h1>登录成功</h1>');

	                    } else {

	                        $(document.body).html('<h1>登录失败</h1>');
	                    }
	                }
	        });
	    });
	    // 弹出式需要绑定触发验证码弹出按钮
	    // 比如在登陆页面，这个触发按钮就是登陆按钮
	    captchaObj.bindOn("#popup-submit");
	     

	    // 验证码会在页面上id为#popup-captcha的元素里显示出来
	    captchaObj.appendTo("#popup-captcha");

	};
	
	$.ajax({
        // 获取id，challenge，success（是否启用failback）
        url: "StartCaptchaServlet",
        type: "get",
        dataType: "json",
        success: function (data) {

            // 使用initGeetest接口
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                product: "popup", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
                offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
            }, handlerPopup);
        }
    });
	</script>
	</script>
</body>
</html>