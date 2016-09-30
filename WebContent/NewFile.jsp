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
	<form class="popup" method="post" action="userLogin.do">
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
					width="60%"><input type=submit value=登陆></td>
			</tr>
			<tr>
				<td>
					<div id="embed-captcha"></div>
					<p id="wait" class="show">正在加载验证码......</p>
					<p id="notice" class="hide">请先拖动验证码到相应位置</p>
				</td>
			</tr>
		</table>
	</form>
	<script>
		var handlerEmbed = function(captchaObj) {

			$("#embed-submit").click(function(e) {
				var validate = captchaObj.getValidate();
				if (!validate) {
					$("#notice")[0].className = "show";
					setTimeout(function() {
						$("#notice")[0].className = "hide";
					}, 2000);
					e.preventDefault();
				}
			});

			// 将验证码加到id为captcha的元素里
			captchaObj.appendTo("#embed-captcha");

			captchaObj.onReady(function() {
				$("#wait")[0].className = "hide";
			});

			// 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
		};
		$.ajax({
			// 获取id，challenge，success（是否启用failback）
			url : "userLogin.do",
			type : "get",
			dataType : "json",
			success : function(data) {

				// 使用initGeetest接口
				// 参数1：配置参数
				// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
				initGeetest({
					gt : data.gt,
					challenge : data.challenge,
					product : "embed", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
					offline : !data.success
				// 表示用户后台检测极验服务器是否宕机，一般不需要关注
				}, handlerEmbed);
			}
		});
	</script>
</body>
</html>