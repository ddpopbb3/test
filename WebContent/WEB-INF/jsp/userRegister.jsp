﻿<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>达内电子商务门户</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="description" content="达内电子商务门户">
		<link href="<%=request.getContextPath() %>/css/tarena.css" rel=stylesheet>
		<script language="javascript" src="uservalidate.js">
	       </script>
	</head>
	<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">

<!-- Header Start -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2">
			<tr>
				<td align="left" width="7%" background="<%=request.getContextPath() %>/images/top_bg.gif"><img src="<%=request.getContextPath() %>/images/logo.gif" width="286" height="58"></td>
				<td width="62%" background="<%=request.getContextPath() %>/images/top_bg.gif">　</td>
				<td width="31%" background="<%=request.getContextPath() %>/images/top_bg.gif" align="right"><img src="<%=request.getContextPath() %>/images/top_r.gif" width="352" height="58" border="0"></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td background="<%=request.getContextPath() %>/images/dh_bg.gif" align="left" height="12">
					<table width="100" border="0" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td width="5%"></td>
							
							<td width="10%"><a href="productList.do"><img name="Image1" border="0" src="<%=request.getContextPath() %>/images/index.gif" width="90" height="36"></a></td>
							
							<td width="10%"><a href="userList.do"><img name="Image2" border="0" src="<%=request.getContextPath() %>/images/reg.gif" width="92" height="36"></a></td>

							<td width="10%"><a href="<%=request.getContextPath()%>/goods.do"><img name="Image4" border="0" src="<%=request.getContextPath() %>/images/cart.gif" width="92" height="36"></a></td>

							<td width="10%"><a href="<%=request.getContextPath()%>/orderlist.do"><img name="Image5" border="0" src="<%=request.getContextPath() %>/images/order.gif" width="92" height="36"></a></td>

							<td width="10%"><a href="tologin.do"><img name="Image6" border="0" src="<%=request.getContextPath() %>/images/exit.gif" width="92" height="36"></a></td>
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
					<img src="<%=request.getContextPath() %>/images/Forum_nav.gif" align="absmiddle">
					<a href=<%=request.getContextPath() %>/index.jsp>达内电子商务门户</a> → 用户注册
				</td>
			</tr>

		</table>
		<br>
		<form method="post" name="reg" action="<%=request.getContextPath() %>/douserRegister.do">
			<table class="tableborder1" id="table1" align="center" cellpadding="3" cellspacing="1">
			<tbody>
			<tr>
				<td colspan="2" align="center" background="<%=request.getContextPath() %>/images/bg2.gif" height="25" valign="middle">
				<font color="#ffffff"><b>新用户注册</b></font></td>

			</tr>

			<tr>
				<td class="tablebody1" width="40%"><b>用户名</b>:<br>
				英文字母或数字,最大长度8位</td>
				<td class="tablebody1" width="60%">
				<input maxlength="12" size="32" name="name" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">
				<font color="#ff0000">*</font>
					<c:if test="${!empty error}">
						<font color="red"><c:out value="${error}" /></font>
					</c:if>
					</td>

			</tr>
			
			<tr>
				<td class="tablebody1" width="40%"><b>密码</b>:<br>
				数字,6到8位
				</td>
				<td class="tablebody1" width="60%">
				<input maxlength="12" size="32" name="password" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="password">
				<font color="#ff0000">*</font>
				<c:if test="${!empty error2}">
						<font color="red"><c:out value="${error2}" /></font>
					</c:if>
				</td>
					
					</td>
			</tr>
			
			<tr>
				<td class="tablebody1" width="40%"><b>确认密码</b>:<br>
				数字,6到8位
				</td>
				<td class="tablebody1">
				<input maxlength="12" size="32" name="password2" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="password">
				<font color="#ff0000">*</font>
				<c:if test="${!empty error3}">
						<font color="red"><c:out value="${error3}" /></font>
					</c:if>
				</td>

			</tr>
			
			<%String country[]={"中国","中国香港","中国台湾"} ;%>
			<%String province[]={"安徽","北京","重庆","福建","广东","甘肃","广西","贵州","河南","湖北","河北","海南","香港","黑龙江","湖南","吉林","江苏","江西","辽宁"}; %>
			
			<tr>
				<td class="tablebody1"><b>所在地区</b>：</td>
				<td class="tablebody1"> 
  			
				<select name="country" onchange="javascript:initProvince(this.value)" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);">
					<option value="1">-----请选择(国家)-----</option>
							<%for(int i=0;i<country.length;i++){
               		  		String ii = String.valueOf(i+1) ;
							 %>
							 <option value="<%=i+1 %>"><%=country[i] %> </option>
							<%
							 }
							%>
				</select>
				<select name="province" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);">
					<option value="1">-----请选择(省)-----</option>
							<%for(int i=0;i<province.length;i++){
               		  		String ii = String.valueOf(i+1) ;
							 %>
							 <option value="<%=i+1 %>"><%=province[i] %> </option>
							<%
							 }
							%>
				</select>
				<input size="8" name="city" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">市/区/县</td>
			</tr>
			
			<tr>

				<td class="tablebody1"><b>联系地址1</b>:</td>
				<td class="tablebody1">
				<input size="64" maxlength="32" name="street1" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">
				</td>
			</tr>
			
			<tr>
				<td class="tablebody1"><b>联系地址2</b>:</td>

				<td class="tablebody1">
				<input size="64" maxlength="32" name="street2" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">
				</td>
			</tr>
			
			<tr>
				<td class="tablebody1"><b>邮编</b>:</td>
				<td class="tablebody1">
				<input size="32" maxlength="8" name="zip" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">

				</td>
			</tr>

			<tr>
				<td class="tablebody1"><b>家庭电话</b>:</td>
				<td class="tablebody1">
				<input size="32" maxlength="16" name="homephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">
				</td>

			</tr>
			
			<tr>
				<td class="tablebody1"><b>办公室电话</b>:</td>
				<td class="tablebody1">
				<input size="32" maxlength="16" name="officephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">
				</td>
			</tr>
			
			<tr>

				<td class="tablebody1"><b>手机</b>:</td>
				<td class="tablebody1">
				<input size="32" maxlength="16" name="cellphone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);" type="text">
				</td>
			</tr>
			
			<tr>
				<td class="tablebody1"><b>Email地址</b>:<br>

				请输入有效的邮件地址</td>
				<td class="tablebody1">
				<input size="32" maxlength="50" name="email" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: rgb(0, 0, 0);"></td>
			</tr>
			
			<tr>
				<td class="tablebody2" colspan="2" align="center" valign="middle">
				<input value="注 册" type="submit">&nbsp;&nbsp;
				<input value="清 除" type="reset"></td>

			</tr>
			</tbody>
			</table>
		</form>
<!-- Body End -->
<!-- Footer Start -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" height="28">
			<tr>
				<td height="17" background="<%=request.getContextPath() %>/images/bot_bg.gif">
				</td>

			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td bgcolor="#f1f1f6" height="53" valign="center">
					<p align="center">
						Copyright &copy;2004 - 2005 <a href="http://www.tarena.com.cn"><b>Tarena</b><font color="red">.com.cn</font></a>

					</p>
				</td>
			</tr>
		</table>
<!-- Footer End -->
	</body>
</html>
