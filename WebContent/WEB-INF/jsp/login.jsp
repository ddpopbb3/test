<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
<%
	String basePath = request.getContextPath();
%>
<title>达内电子商务门户</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="达内电子商务门户">
<link href="<%=basePath%>/css/tarena.css" rel=stylesheet>
</head>
	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
<!-- Header Start -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2">
			<tr>
				<td align="left" width="7%" background="<%=basePath%>/images/top_bg.gif"><img src="<%=basePath%>/images/logo.gif" width="286" height="58"></td>
				<td width="62%" background="<%=basePath%>/images/top_bg.gif">　</td>
				<td width="31%" background="<%=basePath%>/images/top_bg.gif" align="right"><img src="<%=basePath %>/images/top_r.gif" width="352" height="58" border="0"></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td background="<%=basePath%>/images/dh_bg.gif" align="left" height="12">
					<table width="100" border="0" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td width="5%"></td>
							
          <td width="10%"><a href="productList.do"><img name="Image1" border="0" src="<%=basePath%>/images/index.gif" width="90" height="36"></a></td>
							
          <td width="10%"><a href="userList.do"><img name="Image2" border="0" src="<%=basePath%>/images/reg.gif" width="92" height="36"></a></td>
							
          <td width="10%"><a href="tologin.do"><img name="Image4" border="0" src="<%=basePath%>/images/cart.gif" width="92" height="36"></a></td>
							
          <td width="10%"><a href="orderlist.do"><img name="Image5" border="0" src="<%=basePath%>/images/order.gif" width="92" height="36"></a></td>
							
          <td width="10%"><a href="tologin.do"><img name="Image6" border="0" src="<%=basePath%>/images/exit.gif" width="92" height="36"></a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table cellspacing="1" cellpadding="3" align="center" border="0" width="98%">
			<tr>
				<td width="65%"><br>
					>> 欢迎访问 <b>达内电子商务门户</b>
				</td>
				<td width="35%" align="right">
				</td>
			</tr>
		</table>
<!-- Header End -->
<!-- Body Start -->
		<table cellspacing="1" cellpadding="3" align="center" class="tableBorder2">
			<tr>
				<td height="25" valign="middle">
					<img src="<%=basePath%>/images/Forum_nav.gif" align="absmiddle">
					<a href=<%=basePath%>/index.jsp>达内电子商务门户</a> 用户登陆
				</td>
			</tr>
		</table>
		<br>
		<form method="post"  action="tologin.do">
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1">
			<tr>
				<td colspan="4" valign="middle" align="center" height="25" background="<%=basePath%>/images/bg2.gif" width="50">
					<font color="#ffffff">
						<b>用户登陆</b>
					</font>
				</td>
			</tr>
			<tr>
				<td class=tablebody1 valign="middle" height="20" width="30%">
					请输入您的用户名: 
				</td>
				<td class=tablebody1 valign="middle" height="20" width="80%">
						<input type="text"  id ="name" name="name">&nbsp;<a href="<%=basePath%>/userRegister.do">注册新用户</a>
				</td>
			</tr>   
			<tr>
				<td class=tablebody1 valign="middle" width="30%" height="25">
     					 请输入您的密码:
				 </td>
				<td class=tablebody1 valign="middle" width="80%">
						<input type=password  name="password">
					<c:if test="${!empty error}">
						<font color="red"><c:out value="${error}" /></font>
					</c:if>
				</td>
			</tr>   
			<tr>
				<td colspan="4" class=tablebody2 align="center" valign="middle" width="60%">
						<input  type=submit value=登陆 >
				 </td>
			</tr>   
		</table>
		</form>
		<br>
<!-- Body End -->
<!-- Footer Start -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" height="28">
			<tr>
				<td height="17" background="<%=basePath%>/images/bot_bg.gif">
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td bgcolor="#f1f1f6" height="53" valign="center">
					<p align="center">
						Copyright &copy;2014-2015 <a href="http://www.huawei.com.cn"><b>huawei.cn</b><font color="red"></font></a>
					</p>
				</td>
			</tr>
		</table>
<!-- Footer End -->
	</body>
</html>
